package com.mthree.scala.service

import org.springframework.stereotype.Service
import com.mthree.dao.TaskDao
import com.mthree.dao.CategoryDao
import com.mthree.entity.Task
import com.mthree.entity.Category
import com.mthree.exception.{CategoryNotFoundException, TaskNotFoundException}
import com.mthree.service.TaskServiceTrait

import java.util.Optional
import scala.jdk.CollectionConverters._

@Service
class TaskServiceImpl(
                       taskRepo: TaskDao,
                       categoryRepo: CategoryDao
                     ) extends TaskServiceTrait {

  override def createTask(task: Task, categoryId: Long): Optional[Task] = {
    val catOpt = categoryRepo.findById(categoryId)
    if (!catOpt.isPresent) throw new CategoryNotFoundException(s"Category with id ${categoryId} not found.")

    task.setCategory(catOpt.get)
    Optional.of(taskRepo.save(task))
  }

  override def getAllTasks(): java.util.List[Task] =
    taskRepo.findAll().asScala.toList.asJava

  override def getTaskById(id: Long): Optional[Task] =
    taskRepo.findById(id)

  override def getTasksByCategory(categoryId: Long): java.util.List[Task] = {
    val catOpt = categoryRepo.findById(categoryId)

    if (!catOpt.isPresent)
      throw new CategoryNotFoundException("Category with id: "+categoryId+" is not found")

    catOpt.get().getTasks.asScala.toList.asJava
  }




  override def updateTask(id: Long, updated: Task): Optional[Task] = {
    val taskOpt = taskRepo.findById(id)
    if (!taskOpt.isPresent) throw new TaskNotFoundException(s"Task with id ${id} not found.")

    val existing = taskOpt.get
    existing.setTitle(updated.getTitle)
    existing.setDescription(updated.getDescription)
    existing.setDueDate(updated.getDueDate)
    existing.setPriority(updated.getPriority)
    existing.setCompleted(updated.isCompleted)

    Optional.of(taskRepo.save(existing))
  }

  override def deleteTask(id: Long): Boolean = {
    if (!taskRepo.existsById(id)) throw new TaskNotFoundException(s"Task with id ${id} not found.")
    taskRepo.deleteById(id)
    true
  }
}
//
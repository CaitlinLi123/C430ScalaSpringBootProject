package com.mthree.scala.service

import org.springframework.stereotype.Service
import com.mthree.dao.TaskDao;
import com.mthree.dao.CategoryDao;
import com.mthree.entity.Task;
import com.mthree.entity.Category;
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
    if (!catOpt.isPresent) return Optional.empty()

    task.setCategory(catOpt.get)
    Optional.of(taskRepo.save(task))
  }

  override def getAllTasks(): List[Task] =
    taskRepo.findAll().asScala.toList

  override def getTaskById(id: Int): Optional[Task] =
    taskRepo.findById(id)

  override def getTasksByCategory(categoryId: Long): List[Task] = {
    val catOpt = categoryRepo.findById(categoryId)

    if (!catOpt.isPresent)
      return List.empty[Task]

    catOpt.get().getTasks.asScala.toList
  }




  override def updateTask(id: Int, updated: Task): Optional[Task] = {
    val taskOpt = taskRepo.findById(id)
    if (!taskOpt.isPresent) return Optional.empty()

    val existing = taskOpt.get
    existing.setTitle(updated.getTitle)
    existing.setDescription(updated.getDescription)
    existing.setDueDate(updated.getDueDate)
    existing.setPriority(updated.getPriority)
    existing.setCompleted(updated.isCompleted)

    Optional.of(taskRepo.save(existing))
  }

  override def deleteTask(id: Int): Boolean = {
    if (!taskRepo.existsById(id)) return false
    taskRepo.deleteById(id)
    true
  }
}

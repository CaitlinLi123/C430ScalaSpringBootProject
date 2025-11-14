package com.mthree.service

import com.mthree.dao.{CategoryDao, TaskDao}
import com.mthree.entity.Task
import org.springframework.stereotype.Service

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

  override def getAllTasks(): java.util.List[Task] =
    taskRepo.findAll().asScala.toList.asJava

  override def getTaskById(id: Long): Optional[Task] =
    taskRepo.findById(id)

  override def getTasksByCategory(categoryId: Long): java.util.List[Task] = {
    val catOpt = categoryRepo.findById(categoryId)

    if (!catOpt.isPresent)
      return List.empty[Task].asJava

    catOpt.get().getTasks.asScala.toList.asJava
  }




  override def updateTask(id: Long, updated: Task): Optional[Task] = {
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

  override def deleteTask(id: Long): Boolean = {
    if (!taskRepo.existsById(id)) return false
    taskRepo.deleteById(id)
    true
  }
}
//
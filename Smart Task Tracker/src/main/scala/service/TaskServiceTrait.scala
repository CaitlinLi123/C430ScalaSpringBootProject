package com.mthree.scala.service

import java.util.Optional
import com.mthree.entity.Task

trait TaskServiceTrait {
  def createTask(task: Task, categoryId: Long): Optional[Task]
  def getAllTasks(): List[Task]
  def getTaskById(id: Long): Optional[Task]
  def getTasksByCategory(categoryId: Long): List[Task]
  def updateTask(id: Long, updated: Task): Optional[Task]
  def deleteTask(id: Long): Boolean
}
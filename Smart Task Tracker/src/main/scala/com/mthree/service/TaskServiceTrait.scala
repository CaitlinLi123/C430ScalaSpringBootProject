package com.mthree.service

import java.util.Optional
import com.mthree.entity.Task

trait TaskServiceTrait {
  def createTask(task: Task, categoryId: Long): Optional[Task]
  def getAllTasks(): List[Task]
  def getTaskById(id: Int): Optional[Task]
  def getTasksByCategory(categoryId: Long): List[Task]
  def updateTask(id: Int, updated: Task): Optional[Task]
  def deleteTask(id: Int): Boolean
}
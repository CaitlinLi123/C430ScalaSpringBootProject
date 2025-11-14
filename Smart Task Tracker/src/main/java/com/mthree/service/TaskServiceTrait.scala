package com.mthree.service

import com.mthree.entity.Task

import java.util.Optional

trait TaskServiceTrait {
  def createTask(task: Task, categoryId: Long): Optional[Task]
  def getAllTasks(): java.util.List[Task]
  def getTaskById(id: Long): Optional[Task]
  def getTasksByCategory(categoryId: Long): java.util.List[Task]
  def updateTask(id: Long, updated: Task): Optional[Task]
  def deleteTask(id: Long): Boolean
}
//
package com.mthree.service

import com.mthree.entity.Category

import java.util.Optional

trait CategoryServiceTrait {

  def createCategory(category: Category): Optional[Category]

  def getAllCategories(): java.util.List[Category]

  def getCategoryById(id: Long): Optional[Category]

  def updateCategory(updated: Category): Optional[Category]

  def deleteCategory(id: Long): Unit

}

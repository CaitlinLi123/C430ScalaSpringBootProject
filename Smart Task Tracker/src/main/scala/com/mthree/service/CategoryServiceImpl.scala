package service

import com.mthree.entity.Category

import java.util.Optional

class CategoryServiceImpl extends CategoryServiceTrait {

  override def createCategory(category: Category): Optional[Category] = ???

  override def getAllCategories(): List[Category] = ???

  override def getCategoryById(id: Long): Optional[Category] = ???

  override def updateCategory(updated: Category): Optional[Category] = ???

  override def deleteCategory(id: Long): Unit = ???
}

package service

import com.mthree.dao.CategoryDao
import com.mthree.entity.Category
import com.mthree.exception.{CategoryAlreadyExistsException, CategoryNotFoundException}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.Optional

@Service
class CategoryServiceImpl @Autowired() (val categoryDao: CategoryDao) extends CategoryServiceTrait {



  override def createCategory(category: Category): Optional[Category] = {
    if (category.getName == null || category.getName.trim.isEmpty)
      throw new IllegalArgumentException("Category name cannot be empty")



    val existing = categoryDao.findById(category.getId)

    if (existing.isPresent) {
      throw new CategoryAlreadyExistsException(
        s"Category with ID ${category.getId} already exists"
      )
      //Customed exceptions?
    }
    Optional.of(categoryDao.save(category))
  }

  override def getAllCategories(): java.util.List[Category] = {

    categoryDao.findAll()
  }

  override def getCategoryById(id: Long): Optional[Category] = {
    val result = categoryDao.findById(id)

    if (!result.isPresent) {
      throw new CategoryNotFoundException(s"Category with ID $id not found")

    }

    result
  }

  override def updateCategory(updated: Category): Optional[Category] = {
    if (updated.getName == null || updated.getName.trim.isEmpty)
      throw new IllegalArgumentException("Category name cannot be empty")


    Optional.of(categoryDao.save(updated))
  }

  override def deleteCategory(id: Long): Unit = {
    categoryDao.deleteById(id)
  }
}

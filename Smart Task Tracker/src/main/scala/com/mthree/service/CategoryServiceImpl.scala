package service

import com.mthree.dao.CategoryDao
import com.mthree.entity.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.Optional

@Service
class CategoryServiceImpl @Autowired() (val categoryDao: CategoryDao) extends CategoryServiceTrait {



  override def createCategory(category: Category): Optional[Category] = {
    val existing = categoryDao.findById(category.getId)

    if (existing.isPresent) {
//      throw new CategoryAlreadyExistsException(
//        s"Category with ID ${category.getId} already exists"
//      )
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
      //throw new CategoryNotFoundException(s"Category with ID $id not found")
      //Customed exception?
    }

    result
  }

  override def updateCategory(updated: Category): Optional[Category] = {
    Optional.of(categoryDao.save(updated))
  }

  override def deleteCategory(id: Long): Unit = {
    categoryDao.deleteById(id)
  }
}

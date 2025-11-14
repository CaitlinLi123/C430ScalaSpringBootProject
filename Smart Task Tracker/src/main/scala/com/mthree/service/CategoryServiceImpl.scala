package service

import com.mthree.dao.CategoryDao
import com.mthree.entity.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.Optional

@Service
class CategoryServiceImpl @Autowired() (val categoryDao: CategoryDao) extends CategoryServiceTrait {



  override def createCategory(category: Category): Optional[Category] = {
    Optional.of(categoryDao.save(category))
  }

  override def getAllCategories(): java.util.List[Category] = {
    categoryDao.findAll()
  }

  override def getCategoryById(id: Long): Optional[Category] = {
    categoryDao.findById(id)
  }

  override def updateCategory(updated: Category): Optional[Category] = {
    Optional.of(categoryDao.save(updated))
  }

  override def deleteCategory(id: Long): Unit = {
    categoryDao.deleteById(id)
  }
}

package com.mthree.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mthree.entity.Category;

public interface CategoryDao extends CrudRepository<Category, Long> {

    /*
     * Writes the given category to the database
     */
    @Override
    public Category save(Category category);

    /*
     * Returns a list of all categories in the database.
     */
    @Override
    public List<Category> findAll();

    /*
     * Returns the category with the given id, or empty if no such category exists.
     */
    @Override
    public Optional<Category> findById(Long id);

    /*
     * Deletes any category with the same id as the given category.
     */
    @Override
    public void delete(Category category);

}
package com.mthree.dao;

import java.util.List;
import java.util.Optional;

import com.mthree.entity.Category;

interface CategoryDao {
    /*
     * Writes the given category to the database.
     * May throw an exception (which?)
     */
    public void create(Category category);

    /*
     * Returns a list of all categories in the database.
     */
    public List<Category> listAll();

    /*
     * Returns the category with the given id, or empty
     *  if no such category exists.
     */
    public Optional<Category> getById(Long id);

    /*
     * Writes the given category to the database,
     *  overwriting an existing category with the same id.
     * May throw an exception (which?)
     */
    public void update(Category category);

    /*
     * Deletes any category with the same id as the given category.
     * May throw an exception? (which?)
     */
    public void delete(Category category);

}
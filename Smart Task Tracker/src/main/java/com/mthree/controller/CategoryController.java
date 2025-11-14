package com.mthree.controller;

import com.mthree.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mthree.service.*;
import java.util.List;
import java.util.Optional;

import com.mthree.service.CategoryServiceTrait;

@RestController
@RequestMapping("/categories")
//@CrossOrigin
public class CategoryController {
    //service
    @Autowired
    private CategoryServiceTrait categoryService;

//    public CategoryController(CategoryServiceTrait categoryService) {
//        this.categoryService = categoryService;
//    }

    @GetMapping("")
    public List<Category> getAllCategories() {

        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public Optional<Category> updateCategory(@PathVariable int id, @RequestBody Category category){
        return categoryService.updateCategory(category);
    }

    @PostMapping("/{id}")
    public Optional<Category> addCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
    }

}

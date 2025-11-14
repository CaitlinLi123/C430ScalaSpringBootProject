package com.mthree.controller;

import com.mthree.entity.Category;
import org.springframework.web.bind.annotation.*;
//import com.mthree.service.CategoryServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin
public class CategoryController {
    //service
    //CategoryServiceImpl categoryService;

    @GetMapping("")
    public List<Category> getAllCategories() {
        return null;
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id){
        return null;
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable int id, @RequestBody Category category){
        return null;
    }

    @PostMapping("/{id}")
    public Category addCategory(@RequestBody Category category){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id){
        //
    }

}

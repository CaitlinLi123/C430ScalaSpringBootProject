package com.mthree.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.entity.Category;
import com.mthree.entity.Task;

@Repository
public interface TaskDao extends JpaRepository<Task, Long> {

    /*
    *List tasks given category
     */
    List<Task> findByCategory(Category category);
}




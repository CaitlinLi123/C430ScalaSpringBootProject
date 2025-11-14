package com.mthree.dao;

import com.mthree.entity.Category;
import com.mthree.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDao extends JpaRepository<Task, Integer> {
    List<Task> findByCategory(Category category);
}




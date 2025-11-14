package com.mthree.dao;

import com.mthree.entity.Category;
import com.mthree.entity.Task;
import com.mthree.entity.Task;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TaskDao extends JpaRepository<Task, Integer> {

}

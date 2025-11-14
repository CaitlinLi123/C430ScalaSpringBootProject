package com.mthree.dao;

import com.mthree.entity.Task;

import java.util.List;
import java.util.Optional;

interface TaskDao {
    //create
    void create(Task task);
    //getAll
    List<Task> listAll();
    //getOne
    Optional<Task> getById(Long id);
    //update
    void update(Task task);
    //delete
    void delete(Task task);

}

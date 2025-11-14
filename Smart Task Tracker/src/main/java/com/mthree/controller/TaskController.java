package com.mthree.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.entity.Task;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class TaskController {

    @PostMapping("/tasks")
    public ResponseEntity<Task> createANewTask(@RequestBody Task task) {
        Task taskCreated = null;

        return ResponseEntity.status(HttpStatus.CREATED).body(taskCreated);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = new ArrayList<>();

        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable long id) {
        Task task = null;
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @GetMapping("/categories/{id}/tasks")
    public ResponseEntity<List<Task>> getTaskByCategory(@PathVariable long id) {
        List<Task> tasksByCategory = new ArrayList<>();

        return ResponseEntity.status(HttpStatus.OK).body(tasksByCategory);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateATask(@PathVariable long id, @RequestBody Task task) {
        Task taskUpdated = null;
        return ResponseEntity.status(HttpStatus.OK).body(taskUpdated);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteATask(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}

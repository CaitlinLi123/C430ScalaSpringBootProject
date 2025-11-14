package com.mthree.controller;

import com.mthree.dto.CreateTaskDto;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.mthree.service.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private final TaskServiceTrait taskService;

    public TaskController(TaskServiceTrait taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createANewTask(@RequestBody CreateTaskDto dto) {
        Task taskCreated = taskService.createTask(dto.getTask(),dto.getCategoryId()).orElseThrow(
                () -> {
                    throw new IllegalArgumentException("Something went wrong with creating a new task");
                }
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(taskCreated);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();

        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id).orElseThrow(
                () -> {throw new IllegalArgumentException("Unfound");}
        );
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @GetMapping("/categories/{id}/tasks")
    public ResponseEntity<List<Task>> getTaskByCategory(@PathVariable long id) {
        List<Task> tasksByCategory = taskService.getTasksByCategory(id);

        return ResponseEntity.status(HttpStatus.OK).body(tasksByCategory);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateATask(@PathVariable long id, @RequestBody Task task){
        Task taskUpdated = taskService.updateTask(id,task).orElseThrow(
                () -> {throw new IllegalArgumentException("Something went wrong with updating a new task");}
        );
        return ResponseEntity.status(HttpStatus.OK).body(taskUpdated);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteATask(@PathVariable long id) throws Exception {
        boolean deleted = taskService.deleteTask(id);
        if(deleted){
            return ResponseEntity.status(HttpStatus.OK).body("Success");
        }else{
            throw new Exception("Something went wrong with deleting the task with id: "+id);
        }

    }

}

package com.mthree.dto;

import com.mthree.entity.Task;

public class CreateTaskDto {
    private Task task;
    private Long categoryId;

    public CreateTaskDto(){

    }

    public CreateTaskDto(Long categoryId, Task task) {
        this.categoryId = categoryId;
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}

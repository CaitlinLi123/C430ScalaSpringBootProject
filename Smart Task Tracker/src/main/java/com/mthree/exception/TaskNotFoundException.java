package com.mthree.exception;

public class TaskNotFoundException extends Exception{
    public TaskNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskNotFoundException(String message) {
        super(message);
    }
}

package com.mthree.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // This will be uncommented when all other custom exception classes are handled
    // in this file. Comment it for now to prevent hiding important information when
    // exception happens.
    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<String> handleGeneric(Exception e) {
    // return
    // ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went
    // wrong. " + e.getMessage());
    // }
    //    @ExceptionHandler(CategoryNotFoundException.class)
    //    public ResponseEntity<?> handleCategoryNotFound(CategoryNotFoundException e) {
    //        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    //    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(CategoryAlreadyExistsException.class)
    public ResponseEntity<String> handleCategoryExists(CategoryAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> handleCategoryNotFound(CategoryNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }






}

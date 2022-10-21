package com.crud.tasks.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(TaskNotFoundException.class)
//    public ResponseEntity<Object> handleTaskNotFoundException(TaskNotFoundException exception) {
//        return new ResponseEntity<>("Task with given id doesn't exist", HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<Object> handleTaskNotFoundException(TaskNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(EmptyResultDataAccessException.class)
//    public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException exception) {
//        return new ResponseEntity<>("Task with given id doesn't exist", HttpStatus.BAD_REQUEST);
//    }
}

package com.example.courierservice.advice;


import org.example.commondtos.exception.NoSuchEntityException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = NoSuchEntityException.class)
    public String exceptionHandler(NoSuchEntityException e) {

        return e.getLocalizedMessage();
    }
}


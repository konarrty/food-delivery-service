package com.example.orderservice.advice;

import org.example.commondtos.exception.BusinessLogicException;
import org.example.commondtos.exception.NoSuchEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerAdviceProcessor {

    @ExceptionHandler(BusinessLogicException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String businessLogicException(BusinessLogicException e) {

        return e.getLocalizedMessage();
    }

    @ExceptionHandler(NoSuchEntityException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noSuchEntityException(NoSuchEntityException e) {

        return e.getLocalizedMessage();
    }
}

package com.example.triviaSpring.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.triviaSpring.exceptions.BadRequestException;
import com.example.triviaSpring.exceptions.NotFoundException;
import com.example.triviaSpring.dtos.ErrorDto;

@ControllerAdvice(basePackages = { "com.example.triviaSpring.controllers" })
@ResponseBody
public class TriviaControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ErrorDto handleBadRequestException(BadRequestException badRequestException) {
        return new ErrorDto(badRequestException.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorDto handleNotFoundException(NotFoundException notFoundException) {
        return new ErrorDto(notFoundException.getMessage());
    }

}
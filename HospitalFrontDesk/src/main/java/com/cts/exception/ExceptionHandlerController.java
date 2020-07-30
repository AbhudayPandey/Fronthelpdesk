package com.cts.exception;

import java.util.ArrayList;
import java.util.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> specialist = new ArrayList<String>();
        specialist.add(ex.getLocalizedMessage());
        ExceptionResponse error = new ExceptionResponse("Specialist Not Found", specialist);
        return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
    }
 
    @ExceptionHandler(SpecialistException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(SpecialistException ex, WebRequest request) {
        List<String> specialist = new ArrayList<String>();
        specialist.add(ex.getLocalizedMessage());
        ExceptionResponse error = new ExceptionResponse("Specialist Not Found", specialist);
        return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
    }
 
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> specialist = new ArrayList<String>();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
        	specialist.add(error.getDefaultMessage());
        }
        ExceptionResponse error = new ExceptionResponse("Validation Failed", specialist);
        return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

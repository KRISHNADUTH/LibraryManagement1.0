package com.krishna.LibraryManageMent.exception;

import java.util.Date;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.krishna.LibraryManageMent.exception.bookException.BookTitleNotFoundException;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    // For this method "@ExceptionHandler" annotation is defined inside "ResponseEntityExceptionHandler" class
    @Override   
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>(
                new CustomErrorDetails(new Date(), "From MethodArgumentNotValidException in GEH", ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
    
    // For this method "@ExceptionHandler" annotation is defined inside "ResponseEntityExceptionHandler" class
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>(
                new CustomErrorDetails(new Date(), "From handleHttpRequestMethodNotSupported in GEH", ex.getMessage()),
                HttpStatus.METHOD_NOT_ALLOWED);
    }
    
    @ExceptionHandler(BookTitleNotFoundException.class)
    public final ResponseEntity<Object> handleBookTitleNotFoundException(BookTitleNotFoundException ex,
            WebRequest request) {
        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<Object>(customErrorDetails, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,
            WebRequest request) {
        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<Object>(customErrorDetails, HttpStatus.NOT_FOUND);
    }
}

package com.insurance.policy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionErrorStructure> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ExceptionErrorStructure error = new ExceptionErrorStructure(HttpStatus.NOT_FOUND, ex.getMessage(), request.getDescription(true));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ExceptionErrorStructure> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
		ExceptionErrorStructure error = new ExceptionErrorStructure(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(true));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ExceptionErrorStructure> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, WebRequest request) {
		ExceptionErrorStructure error = new ExceptionErrorStructure(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(true));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ExceptionErrorStructure> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
		ExceptionErrorStructure error = new ExceptionErrorStructure(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(true));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionErrorStructure> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionErrorStructure error = new ExceptionErrorStructure(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", request.getDescription(true));
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}

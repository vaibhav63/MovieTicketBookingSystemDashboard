package com.cg.sbrms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.sbrms.exception.ShowException;

@RestControllerAdvice
public class ShowControllerAdvice {

	@ExceptionHandler(ShowException.class)
	public ResponseEntity<String> handle(ShowException exception){
		
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handle(Exception exception){
		
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
}

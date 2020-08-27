package com.cg.oms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.oms.exception.ScreenException;


@RestControllerAdvice
public class ScreenControllerAdvice {

	@ExceptionHandler(ScreenException.class)
	public ResponseEntity<String> handle(ScreenException exception){
		
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handle(Exception exception){
		
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
}

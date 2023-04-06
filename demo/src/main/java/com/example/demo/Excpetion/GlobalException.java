package com.example.demo.Excpetion;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(EntryExpection.class)
	public ResponseEntity<Error_Details>ExpcetionHandler(EntryExpection e, WebRequest request)
	
	{
		
		Error_Details erro = new Error_Details(e.getMessage(), request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
	}

}

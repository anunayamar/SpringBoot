package com.example.interview.InterviewDemo.hardcoded.exceptions.handlers;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.interview.InterviewDemo.hardcoded.exceptions.UserNotFoundException;
import com.example.interview.InterviewDemo.hardcoded.exceptions.responses.CustomExceptionResponse;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	//This handles all UserNotFoundException thrown by any controller. Curly bracket is an array and multiple exception types can be added
	@ExceptionHandler({ UserNotFoundException.class })
	public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new CustomExceptionResponse(new Date(), ex.getMessage()));
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		//Please note, here ex.getMessage is pretty raw and should be processed more to only show user friendly message. Also, avoid sharing code details
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new CustomExceptionResponse(new Date(), ex.getMessage()));
	}
}

package io.gustavo.starwars.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SWExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = IllegalArgumentException.class)
	public ResponseEntity<Object> handleIllegalArgumentException(RuntimeException ex, WebRequest request){
		var bodyOfResponse = new Error(ex.getMessage());
		
		return handleExceptionInternal(ex, bodyOfResponse, 
		          new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(value = RebelNotFoundException.class)
	public ResponseEntity<Object> handleRebelNotFound(RebelNotFoundException ex, WebRequest request){
		var bodyOfResponse = new Error(ex.getMessage());
		
		return handleExceptionInternal(ex, bodyOfResponse, 
		          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

}

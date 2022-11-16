package com.eCommerce.Excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice 
public class GlobalExceptionHandler extends Exception{

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Error>illegalArgumentException(Exception exception){
		Error error = new Error();
		error.setMensaje(exception.getMessage());
		error.setEstatus("ERROR");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Error>resourceNotFoundException(Exception exception){
		Error error = new Error();
		error.setMensaje(exception.getMessage());
		error.setEstatus("ERROR");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<Error>resourceAlreadyExistsException(Exception exception){
		Error error = new Error();
		error.setMensaje(exception.getMessage());	
		error.setEstatus("ERROR");
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
}
}

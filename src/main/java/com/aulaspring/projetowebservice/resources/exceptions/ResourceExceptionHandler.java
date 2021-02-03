package com.aulaspring.projetowebservice.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.boot.model.relational.Database;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aulaspring.projetowebservice.service.exceptions.DatabaseException;
import com.aulaspring.projetowebservice.service.exceptions.ResourceNotFoundException;

//Anotation que irá interceptar as exceções que ocorrerem para o objeto fazer o tratamento
@ControllerAdvice
public class ResourceExceptionHandler {

	//Utilizamos essa anotation para ele interceptar o erro e cair no nosso método
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND; //Código 404
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST; //Código 400
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	
}

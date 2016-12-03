package com.example.exception;

import org.springframework.data.rest.core.RepositoryConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.ErrorResource;
import com.example.FieldErrorResource;

@ControllerAdvice
public class RestREsponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = { RepositoryConstraintViolationException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		
		RepositoryConstraintViolationException rcve = (RepositoryConstraintViolationException) ex;
		
		ErrorResource errResource = new ErrorResource();
		errResource.setCode(rcve.getErrors().getFieldError().getCode());
		errResource.setMessage("Ha habido errores procesando el objeto solicitado");
		
		for (FieldError fError : rcve.getErrors().getFieldErrors()) {
			FieldErrorResource fer = new FieldErrorResource();
			fer.setCode(fError.getCode());
			fer.setField(fError.getField());
			fer.setResource(fError.getObjectName());
			fer.setMessage(fError.getDefaultMessage());
			errResource.getFieldErrors().add(fer);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(ex, errResource, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
    }

}

package com.pe.sanfernando.ventas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pe.sanfernando.ventas.dtos.ResponseDTO;

import lombok.extern.slf4j.Slf4j;


@RestControllerAdvice
@Slf4j
public class ExceptionGlobalResponse extends ResponseEntityExceptionHandler {		

	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ResponseDTO> notFoundExeption (NotFoundException ex) {		
		ResponseDTO response = new ResponseDTO("error", ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);		
	}
	

	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<ResponseDTO> badRequestException (BadRequestException ex) {		
		ResponseDTO response = new ResponseDTO("error", ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);		
	}
	
	
	@ExceptionHandler(MethodNotAllowedException.class)
	public final ResponseEntity<ResponseDTO> methodNotAllowedException (MethodNotAllowedException ex) {		
		ResponseDTO response = new ResponseDTO("error", ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);		
	}	
	
	@ExceptionHandler(VentasException.class)
	public final ResponseEntity<ResponseDTO> sgmExceptionPersonalizado(VentasException ex) {	
		log.error("Ingreso a ventasException global==========="); 			
		ResponseDTO response = new ResponseDTO(ex.getTipo(), ex.getMensaje());			
		return new ResponseEntity<>(response, HttpStatus.NOT_IMPLEMENTED);		
	}		
		

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ResponseDTO> manejarTodasExcepciones(Exception ex) {		
		log.error("Ingreso a Exception global==========="); 	
		
		String message = ex.getCause()!=null?(ex.getCause().getCause()!=null?ex.getCause().getCause().getMessage():ex.toString()):
			ex.toString();		
			
		ResponseDTO response = new ResponseDTO("error",  message);			
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}



}

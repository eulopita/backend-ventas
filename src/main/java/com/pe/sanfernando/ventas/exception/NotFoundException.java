package com.pe.sanfernando.ventas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -5079766881152293893L;

	public NotFoundException(String mensaje) {
		super(mensaje);
	}

}

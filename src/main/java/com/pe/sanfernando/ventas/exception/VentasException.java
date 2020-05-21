package com.pe.sanfernando.ventas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
public class VentasException extends RuntimeException {		
	
	private static final long serialVersionUID = 7422398171133598173L;

	private String mensaje;

	private String tipo;
	

	public VentasException(String tipo,String mensaje){		
		this.mensaje=mensaje;			
		if(tipo.equals(Tipo.SUCCESS.getValor())){
			this.tipo= Tipo.SUCCESS.getValor();
		}else if(tipo.equals(Tipo.ERROR.getValor())){
			this.tipo= Tipo.ERROR.getValor();	
		}else if(tipo.equals(Tipo.WARNING.getValor())){
			this.tipo= Tipo.WARNING.getValor();	
		}else if(tipo.equals(Tipo.INFO.getValor())){
			this.tipo= Tipo.INFO.getValor();		
		}	
	}		
	
	public VentasException(String mensaje){		
		this.mensaje=mensaje;			
	}	
	

	public String getMensaje() {	
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setInfo(String mensaje) {
		this.mensaje = mensaje;
		this.tipo= Tipo.ERROR.getValor();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}		
	

	public enum Tipo {	

		INFO("info"),
		ERROR("error"),
		WARNING("warning"),
		SUCCESS("success");

		private final String codigo;


		Tipo(String codigo) {
			this.codigo = codigo;
		}

		public String getValor() {
			return codigo;
		}
	}

}

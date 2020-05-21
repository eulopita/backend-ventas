package com.pe.sanfernando.ventas.dtos;


import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data	
@NoArgsConstructor
public class ResponseDTO {

	private String status; // success, info, error
	private Object data; //Devuelve el Object
	private String mensaje;//Mensaje
	private List<?> lista;//Retorna la lista siempre y cuando sea Success 	
	private Date timestamp;	//La fecha y hora de consulta o transaccion
	private Long id; //Id del objeto persistido cuando la transaccion es success

	

	public ResponseDTO(String status, Object data, String mensaje){
		this.status = status;
		this.data = data;
		this.mensaje = mensaje;
	} 

	public ResponseDTO(String status, List<?> lista, String mensaje){
		this.status = status;
		this.lista = lista;
		this.mensaje = mensaje;
	} 

	public ResponseDTO(String status, String mensaje, Long id){
		this.status = status;
		this.mensaje = mensaje;
		this.id = id;
	} 

	public ResponseDTO(String status, String mensaje){
		this.status = status;
		this.mensaje = mensaje;
	} 	
	

	public Date getTimestamp() {
		return timestamp!=null?timestamp:new Date();
	}

}

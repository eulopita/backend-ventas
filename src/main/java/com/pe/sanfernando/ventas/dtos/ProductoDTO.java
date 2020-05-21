package com.pe.sanfernando.ventas.dtos;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDTO {

	private Long idproducto;

	private String nombre;	

	private BigDecimal precio;

	private Integer estado;

	//Datos de la categoria

	private Long idcategoria;
	
	private String nombreCategoria;	
	
	private String descripcion;
	
	

}

package com.pe.sanfernando.ventas.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="TTCLIENTE")
@Data
@NoArgsConstructor
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_SEQ")
	@SequenceGenerator(name="CLIENTE_SEQ", sequenceName = "CLIENTE_SEQ", allocationSize=1)	
	private Long idcliente;

	private Integer estado;

	private String email;

	private String direccion;
	
	private String referencia;
	
	private String nombres;

	private String primerapellido;
	
	private String segundopellido;
	
	private String numerodocumento;

	private String tipodocumento;

	private String telefono;
	
	private String celular;
	
	private String sexo;	

}
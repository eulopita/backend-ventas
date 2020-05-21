package com.pe.sanfernando.ventas.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="TTPRODUCTO")
@Data
@NoArgsConstructor
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTO_SEQ")
	@SequenceGenerator(name="PRODUCTO_SEQ", sequenceName = "PRODUCTO_SEQ", allocationSize=1)	
	private Long idproducto;
	
	private String nombre;	
	
	private BigDecimal precio;

	private Integer estado;

	//bi-directional many-to-one association to Categoria	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDCATEGORIA", nullable = false)
	private Categoria categoria;
	

}
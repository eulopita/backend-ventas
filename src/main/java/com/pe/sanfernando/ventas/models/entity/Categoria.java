package com.pe.sanfernando.ventas.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="TTCATEGORIA")
@Data
@NoArgsConstructor
public class Categoria implements Serializable {	

    private static final long serialVersionUID = 1L;

	@Id		
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORIA_SEQ")
	@SequenceGenerator(name="CATEGORIA_SEQ", sequenceName = "CATEGORIA_SEQ", allocationSize=1)	
	private Long idcategoria;
	
	@Size(min = 3, message = "Nombre de Categoria debe tener minimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 150)
	private String nombre;	
		
	@Column(name = "descripcion", nullable = false, length = 150)
	private String descripcion;
	
	private Integer estado;

	//bi-directional many-to-one association to Producto	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	private List<Producto> productos;
	
	
	
	

}
package com.pe.sanfernando.ventas.services;

import java.util.List;

import com.pe.sanfernando.ventas.models.entity.Categoria;

public interface CategoriaService {	
	
	public List<Categoria> listarCategorias();
	
	public Categoria obtenerCategoria(Long id);
	
	public Categoria registrarCategoria(Categoria categoria);	

	public Categoria actualizarCategoria(Categoria categoria);	    
	
	public void eliminarCategoria(Long id);

}

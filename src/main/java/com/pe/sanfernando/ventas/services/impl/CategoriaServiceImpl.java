package com.pe.sanfernando.ventas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pe.sanfernando.ventas.models.entity.Categoria;
import com.pe.sanfernando.ventas.models.repository.CategoriaRepository;
import com.pe.sanfernando.ventas.services.CategoriaService;

@Service
@Transactional(readOnly = true)
public class CategoriaServiceImpl implements CategoriaService {

	
	@Autowired
	private CategoriaRepository categoriaRepository;


	@Override
	public List<Categoria> listarCategorias() {
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria obtenerCategoria(Long id) {
		return categoriaRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public Categoria registrarCategoria(Categoria categoria) {		
		return categoriaRepository.save(categoria);
	}

	
	@Override
	@Transactional(readOnly = false)
	public Categoria actualizarCategoria(Categoria categoria) {
		
		Categoria categoriaM = obtenerCategoria(categoria.getIdcategoria());
		
		if (null == categoriaM){
			return null;
		}
		categoriaM.setNombre(categoria.getNombre());
				
		return categoriaRepository.save(categoriaM);
	}
	
    
	@Override
	@Transactional(readOnly = false)
	public void eliminarCategoria(Long id) {			
		categoriaRepository.deleteById(id);
	}

}

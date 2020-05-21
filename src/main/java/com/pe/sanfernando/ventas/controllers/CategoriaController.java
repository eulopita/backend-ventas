package com.pe.sanfernando.ventas.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.sanfernando.ventas.models.entity.Categoria;
import com.pe.sanfernando.ventas.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {


	@Autowired
	private CategoriaService categoriaService ;
	
	

	@GetMapping
	public ResponseEntity<List<Categoria>> listar() {

		List<Categoria> categorias = new ArrayList<>();

		categorias = categoriaService.listarCategorias();

		if (categorias.isEmpty()){
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(categorias);
	}


	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> obtener(@PathVariable("id") Long id) {
		Categoria categoria =  categoriaService.obtenerCategoria(id);
		if (null==categoria){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(categoria);
	}


	@PostMapping
	public ResponseEntity<Categoria> registrar(@Valid @RequestBody Categoria categoria) {        

		Categoria categoriaCreate =  categoriaService.registrarCategoria(categoria);

		return new ResponseEntity<Categoria>(categoriaCreate, HttpStatus.OK);		
	}


	@PutMapping
	public ResponseEntity<Categoria> modificar(@Valid @RequestBody Categoria categoria){       

		Categoria categoriaEdit =  categoriaService.actualizarCategoria(categoria);

		return new ResponseEntity<Categoria>(categoriaEdit, HttpStatus.OK);		
	}



	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Long id){
		categoriaService.eliminarCategoria(id); 
	}



}

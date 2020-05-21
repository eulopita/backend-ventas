package com.pe.sanfernando.ventas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.sanfernando.ventas.dtos.ProductoDTO;
import com.pe.sanfernando.ventas.dtos.ResponseDTO;
import com.pe.sanfernando.ventas.exception.NotFoundException;
import com.pe.sanfernando.ventas.exception.VentasException;
import com.pe.sanfernando.ventas.services.ProductoService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping("/productos")
public class ProductoController {		

	@Autowired
	private ProductoService productoService;	
	

	//Metodo para listar productos
	@GetMapping
	public ResponseEntity<List<ProductoDTO>> listar() {		
		List<ProductoDTO> lista = productoService.listarProductos();		
		return new ResponseEntity<List<ProductoDTO>>(lista, HttpStatus.OK);
	}	


	//metodo para obtener producto por id
	@GetMapping("/{id}")
	public ResponseEntity<ProductoDTO> obtener(@PathVariable("id") Long idproducto) {
		ProductoDTO producto = productoService.obtenerProducto(idproducto);
		if(producto.getIdproducto()==null) {
			throw new NotFoundException("ID NO ENCONTRADO: " + idproducto);
		}
		return new ResponseEntity<ProductoDTO>(producto, HttpStatus.OK);
	}


	//Metodo para registrar y actualizar producto
	@PostMapping
	public ResponseEntity<ResponseDTO> registrar(@RequestBody ProductoDTO productoDTO) 
			throws VentasException {

		log.info("Entrando a registrar producto======");		
		

		Long rpta = productoService.registrarProducto(productoDTO);		


		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO("success",
				"Producto registrado correctamente", rpta));		

	}
	
	


}

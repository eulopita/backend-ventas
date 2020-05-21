package com.pe.sanfernando.ventas.services;

import java.util.List;

import com.pe.sanfernando.ventas.dtos.ProductoDTO;
import com.pe.sanfernando.ventas.exception.VentasException;

public interface ProductoService {
	
	List<ProductoDTO> listarProductos();
	
	 ProductoDTO obtenerProducto(Long idproducto);

	 Long registrarProducto(ProductoDTO productoDTO) throws VentasException;
}

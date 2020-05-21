package com.pe.sanfernando.ventas.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pe.sanfernando.ventas.dtos.ProductoDTO;
import com.pe.sanfernando.ventas.exception.VentasException;
import com.pe.sanfernando.ventas.models.entity.Producto;
import com.pe.sanfernando.ventas.models.repository.CategoriaRepository;
import com.pe.sanfernando.ventas.models.repository.ProductoRepository;
import com.pe.sanfernando.ventas.services.ProductoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(readOnly = true)
public class ProductoServiceImpl implements ProductoService {


	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;
	


	@Override
	public List<ProductoDTO> listarProductos() {

		List<ProductoDTO> lista = new ArrayList<>();

		List<Producto> productos = productoRepository.findAll();

		productos.forEach((p)->{

			ProductoDTO dto = new ProductoDTO();			

			BeanUtils.copyProperties(p, dto); 				

			if(p.getCategoria()!=null && 
					p.getCategoria().getNombre()!=null) {
				
			}

			lista.add(dto);

		});

		return lista;
	}


	@Override
	public ProductoDTO obtenerProducto(Long idproducto) {

		ProductoDTO dto = new ProductoDTO();			

		Producto producto = productoRepository.findById(idproducto).orElse(null);

		if(producto!=null) {

			BeanUtils.copyProperties(producto, dto); 				

			if(producto.getCategoria()!=null && 
					producto.getCategoria().getNombre()!=null) {
				
			}			
		}
		return dto;
	}

	
	@Transactional(readOnly = false)	
	@Override
	public Long registrarProducto(ProductoDTO productoDTO) throws VentasException {  


		log.info("Ingresando a registrar producto");  	

		Long rpta = 0L;	 		
		
		Producto producto = null;	
		

		if(productoDTO.getIdproducto()!=null && productoDTO.getIdproducto()!=0L) {	
			
			//Actualizar
			
			producto  = productoRepository.findById(productoDTO.getIdproducto()).orElse(null);
			
			if(producto !=null) {				
				
				producto.setNombre(productoDTO.getNombre()); 
				producto.setPrecio(productoDTO.getPrecio());
				producto.setCategoria(categoriaRepository.findById(productoDTO.getIdcategoria()).orElse(null));
				
			    productoRepository.save(producto);
			    
				rpta = producto.getIdproducto();
			}			
			
		}else {
			//Nuevo
			
			producto = new Producto();		
			
			producto.setEstado(1);
			producto.setNombre(productoDTO.getNombre()); 
			producto.setPrecio(productoDTO.getPrecio());
			producto.setCategoria(categoriaRepository.findById(productoDTO.getIdcategoria()).orElse(null)); 
			
			productoRepository.save(producto);
			
			rpta = producto.getIdproducto();		
			
		}

		return rpta;
	}





}

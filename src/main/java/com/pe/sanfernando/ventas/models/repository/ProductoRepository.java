package com.pe.sanfernando.ventas.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.sanfernando.ventas.models.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {	
	

}

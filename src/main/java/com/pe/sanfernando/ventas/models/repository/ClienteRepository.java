package com.pe.sanfernando.ventas.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.sanfernando.ventas.models.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {	
	
	 public Cliente findByNumerodocumento(String numerodocumento);

}

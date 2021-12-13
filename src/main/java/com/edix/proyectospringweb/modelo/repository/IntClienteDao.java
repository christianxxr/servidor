package com.edix.proyectospringweb.modelo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.proyectospringweb.modelo.beans.Cliente;

@Repository
public interface IntClienteDao {

	List<Cliente> findAll();

	Cliente findById(String idCliente);
	
	int addCliente(Cliente cliente);

}

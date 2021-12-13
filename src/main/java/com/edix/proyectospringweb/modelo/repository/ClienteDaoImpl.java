package com.edix.proyectospringweb.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.proyectospringweb.modelo.beans.Cliente;

@Repository
public class ClienteDaoImpl implements IntClienteDao {

	List<Cliente> lista;

	public ClienteDaoImpl() {
		// TODO Auto-generated constructor stub
		lista = new ArrayList<Cliente>();
		cargarDatos();
	}

	private void cargarDatos() {
		lista.add(new Cliente("12345678A", "Madrid", 50000, "Ángel", 50));
		lista.add(new Cliente("23456789B", "Getafe", 10000, "Luis", 30));
		lista.add(new Cliente("34567891C", "Rivas-VaciaMadrid", 150000, "Sergio", 200));
		lista.add(new Cliente("45678912D", "Móstoles", 300000, "Iván", 3000));
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Cliente findById(String idCliente) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		cliente.setCif(idCliente);
		int pos = lista.indexOf(cliente);
		if (pos == -1)
			return null;
		else
			System.out.println(lista.get(pos));
			return lista.get(pos);
	}

	@Override
	public int addCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		if (!lista.contains(cliente)) {
			lista.add(cliente);
			return 1;
		}

		return 0;
	}

}

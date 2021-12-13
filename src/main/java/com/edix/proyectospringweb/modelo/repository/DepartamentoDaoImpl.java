package com.edix.proyectospringweb.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import com.edix.proyectospringweb.modelo.beans.Departamento;

public class DepartamentoDaoImpl implements IntDepartamentoDao {

	List<Departamento> lista;
	IntEmpleadosDao iemp;

	public DepartamentoDaoImpl() {
		// TODO Auto-generated constructor stub
		lista = new ArrayList<Departamento>();
		cargarDatos();
	}

	private void cargarDatos() {
		lista.add(new Departamento(1, "Madrid", "Informática"));
		lista.add(new Departamento(2, "Madrid", "Logística"));
		lista.add(new Departamento(3, "Getafe", "Tienda comercial"));
		lista.add(new Departamento(4, "Madrid", "Reparto"));
	}

	@Override
	public List<Departamento> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Departamento findById(int idDepartamento) {
		// TODO Auto-generated method stub
		Departamento dept = new Departamento();
		dept.setIdDepar(idDepartamento);
		int pos = lista.indexOf(dept);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}

	@Override
	public int altaDepartamento(Departamento departamento) {
		// TODO Auto-generated method stub
		return lista.add(departamento) ? 1 : 0;
	}

	@Override
	public int editarDepartamento(Departamento departamento) {
		// TODO Auto-generated method stub
		int pos = lista.indexOf(departamento);

		return lista.set(pos, departamento) != null ? 1 : 0;
	}

	@Override
	public int bajaDepartamento(Departamento departamento) {
		// TODO Auto-generated method stub
		return lista.remove(departamento) ? 1 : 0;
	}

}

package com.edix.proyectospringweb.modelo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.proyectospringweb.modelo.beans.Departamento;

@Repository
public interface IntDepartamentoDao {

	List<Departamento> findAll();

	Departamento findById(int idDepartamento);

	int altaDepartamento(Departamento departamento);

	int editarDepartamento(Departamento departamento);

	int bajaDepartamento(Departamento departamento);

}

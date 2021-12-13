package com.edix.proyectospringweb.modelo.repository;

import java.util.Date;
import java.util.List;

import com.edix.proyectospringweb.modelo.beans.Proyecto;

public interface IntProyectoDao {

	List<Proyecto> findAll();

	Proyecto findById(String idProyecto);

	int addProyecto(Proyecto proyecto);

	List<Proyecto> findByEstado(String estado);

	int modificarEstadoProyecto(String idEvento, String estado, double costeReal, Date fechaFinReal);

}

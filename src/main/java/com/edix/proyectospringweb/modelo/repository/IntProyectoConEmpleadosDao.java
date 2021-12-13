package com.edix.proyectospringweb.modelo.repository;

import java.util.List;

import com.edix.proyectospringweb.modelo.beans.ProyectoConEmpleado;

public interface IntProyectoConEmpleadosDao {

	List<ProyectoConEmpleado> findAll();

	List<ProyectoConEmpleado> listaEmpleadosAsignados();

	List<ProyectoConEmpleado> listaEmpleadosAsignadosAProyecto(String idProyecto);

	int insertarEmpleado(ProyectoConEmpleado proyectoConEmpleado);

}

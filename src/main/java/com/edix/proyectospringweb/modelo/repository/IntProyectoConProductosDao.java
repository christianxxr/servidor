package com.edix.proyectospringweb.modelo.repository;

import java.util.List;

import com.edix.proyectospringweb.modelo.beans.ProyectoConProducto;

public interface IntProyectoConProductosDao {
	List<ProyectoConProducto> findAll();

	public List<ProyectoConProducto> listaproductosAsignadosAProyecto(String idProyecto);
}

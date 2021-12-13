package com.edix.proyectospringweb.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.proyectospringweb.modelo.beans.ProyectoConProducto;

@Repository
public class ProyectoConProductosDaoImpl implements IntProyectoConProductosDao {
	private List<ProyectoConProducto> lista;

	public ProyectoConProductosDaoImpl() {
		lista = new ArrayList<ProyectoConProducto>();

		cargarDatos();
	}

	/**
	 * @return Devuelve la lista con los productos asignados en los proyectos
	 */
	@Override
	public List<ProyectoConProducto> findAll() {
		return lista;
	}

	@Override
	public List<ProyectoConProducto> listaproductosAsignadosAProyecto(String idProyecto) {
		List<ProyectoConProducto> aux = new ArrayList<ProyectoConProducto>();
		for (ProyectoConProducto ele : lista) {
			if (ele.getProyecto().getIdProyecto().equals(idProyecto))
				aux.add(ele);
		}
		return aux;
	}

	private void cargarDatos() {
		IntProductoDao iProdDao = new ProductoDaoImpl();
		IntProyectoDao iProyDao = new ProyectoDaoImpl();

		lista.add(new ProyectoConProducto(1, 10, 1300L, iProdDao.findById(1), iProyDao.findById("HJ0001")));
		lista.add(new ProyectoConProducto(2, 10, 1300L, iProdDao.findById(2), iProyDao.findById("HJ0001")));
		lista.add(new ProyectoConProducto(3, 10, 1300L, iProdDao.findById(3), iProyDao.findById("HJ0001")));
		lista.add(new ProyectoConProducto(4, 10, 91L, iProdDao.findById(1), iProyDao.findById("HJ0002")));
		lista.add(new ProyectoConProducto(5, 10, 195L, iProdDao.findById(4), iProyDao.findById("HJ0002")));
		lista.add(new ProyectoConProducto(6, 10, 91L, iProdDao.findById(5), iProyDao.findById("HJ0002")));
	}
}

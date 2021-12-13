package com.edix.proyectospringweb.modelo.repository;

import java.util.List;

import com.edix.proyectospringweb.modelo.beans.Producto;

public interface IntProductoDao {

	List<Producto> findAll();

	Producto findById(int idProducto);

	int addProducto(Producto producto);

	int editaProducto(Producto producto); // Edita un producto

	int bajaProducto(Producto producto); // Da de baja un producto

	int asignaIdProducto(); // Asigna de forma automática la id

}

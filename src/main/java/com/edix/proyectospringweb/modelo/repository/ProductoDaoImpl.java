package com.edix.proyectospringweb.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.proyectospringweb.modelo.beans.Producto;

@Repository
public class ProductoDaoImpl implements IntProductoDao {

	List<Producto> lista;

	public ProductoDaoImpl() {
		// TODO Auto-generated constructor stub
		lista = new ArrayList<Producto>();
		cargarProducto();
	}

	private void cargarProducto() {
		lista.add(new Producto(1, "licencia Programa Formación ", "licencia", 1000, 200));
		lista.add(new Producto(2, "Impresora Laser", "laser", 70, 1500));
		lista.add(new Producto(3, "Juego de rotuadores de colores", "rotuladores", 150, 500));
		lista.add(new Producto(4, "Cuaderno y boligrafo", "cuaderno", 0.75, 10000));
		lista.add(new Producto(5, "Flip Chart con hojas verticales", "rotafolio", 500, 250));
	}

	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Producto findById(int idProducto) {
		// TODO Auto-generated method stub
		Producto producto = new Producto();
		producto.setIdProducto(idProducto);
		int pos = lista.indexOf(producto);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}

	@Override
	public int addProducto(Producto producto) {
		// TODO Auto-generated method stub
		if (!lista.contains(producto)) {
			lista.add(producto);
			return 1;
		}

		return 0;
	}

	/**
	 * @param Producto Recibe el objeto producto a editar
	 * @return 1 si lo ha podido editar, 0 en caso contrario
	 */
	@Override
	public int editaProducto(Producto producto) {
		int pos = lista.indexOf(producto);

		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, producto) != null) ? 1 : 0;
	}

	/**
	 * @param Producto Recibe el objeto producto a eliminar
	 * @return 1 Si lo elimina, 0 Si no ha podido eliminarlo
	 */
	@Override
	public int bajaProducto(Producto producto) {

		return lista.remove(producto) ? 1 : 0;
	}

	@Override
	public int asignaIdProducto() {

		return lista.size() + 1;
	}

}

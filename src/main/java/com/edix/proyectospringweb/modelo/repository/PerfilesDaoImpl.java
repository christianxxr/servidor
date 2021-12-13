package com.edix.proyectospringweb.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.proyectospringweb.modelo.beans.Perfile;

@Repository
public class PerfilesDaoImpl implements IntPerfilesDao {

	List<Perfile> lista;

	public PerfilesDaoImpl() {
		// TODO Auto-generated constructor stub
		lista = new ArrayList<Perfile>();
		cargarDatos();
	}

	private void cargarDatos() {
		lista.add(new Perfile(1, "Control de gestión"));
		lista.add(new Perfile(2, "Jefe de proyecto"));
		lista.add(new Perfile(3, "Operativo"));
		lista.add(new Perfile(4, "Recursos humanos"));
	}

	@Override
	public List<Perfile> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Perfile findById(int idPerfiles) {
		// TODO Auto-generated method stub
		Perfile perfiles = new Perfile();
		perfiles.setIdPerfil(idPerfiles);
		int pos = lista.indexOf(perfiles);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}

	/**
	 * @param Recibe un objeto perfile para darlo de alta Si el alta es correcto
	 *               devuelve 1, sino devuelve 0
	 */
	@Override
	public int altaPerfil(Perfile perfile) {

		return (lista.contains(perfile)) ? 0 : (lista.add(perfile)) ? 1 : 0;
	}

	/**
	 * @param recibe el id del perfil que se quiere editar devuelve 1 si se ha
	 *               podido editar, 0 si no es el caso
	 */
	@Override
	public int editarPerfile(Perfile perfile) {
		int pos = lista.indexOf(perfile);

		if (pos == -1)
			return 0;
		else
			return lista.set(pos, perfile) != null ? 1 : 0;
	}

	/**
	 * @param recibe el id del pefil que se quiere eliminar devuelve 1 si lo
	 *               elimina, 0 si no se ha podido realizar.
	 */
	@Override
	public int eliminarPerfile(Perfile perfile) {
		return lista.remove(perfile) ? 1 : 0;
	}
}

package com.edix.proyectospringweb.modelo.repository;

import java.util.List;

import com.edix.proyectospringweb.modelo.beans.Perfile;

public interface IntPerfilesDao {

	List<Perfile> findAll();

	Perfile findById(int idPerfiles);

	int altaPerfil(Perfile perfile); // Da de alta un perfil

	int editarPerfile(Perfile perfile); // Edita un perfil

	int eliminarPerfile(Perfile perfile); // elimina un perfil

}

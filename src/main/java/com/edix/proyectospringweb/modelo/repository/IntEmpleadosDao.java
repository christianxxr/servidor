package com.edix.proyectospringweb.modelo.repository;

import java.util.List;

import com.edix.proyectospringweb.modelo.beans.Empleado;

public interface IntEmpleadosDao {

	List<Empleado> findAll();

	Empleado findById(int idEmpleado);

	Empleado empleadoCorrecto(int idEmpleado, String email, String password);

	int addEmpleado(Empleado empleado);

	int changePassword(int idEmpleado, String password);

	int changePerfile(int idEmpleado, int perfil);

	int editarEmpleado(int idEmpl); // Devuelve el empleado dado

	int borrarEmpleado(int idEmpl); // Borra el empleado del id dado

	int asignaId(); // Asigna de forma automática el último id

	List<Empleado> mostrarJefes(); //

	List<Empleado> operativosSinAsignarAProyectos();

	List<Empleado> findOperativos();

}

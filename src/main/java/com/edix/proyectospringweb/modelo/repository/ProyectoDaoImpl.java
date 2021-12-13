package com.edix.proyectospringweb.modelo.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.proyectospringweb.modelo.beans.Proyecto;

@Repository
public class ProyectoDaoImpl implements IntProyectoDao {

	List<Proyecto> lista;
	IntEmpleadosDao iemp;
	IntClienteDao icli;
	IntProyectoConEmpleadosDao iproyEmp;

	public ProyectoDaoImpl() {
		// TODO Auto-generated constructor stub
		lista = new ArrayList<Proyecto>();
		cargarDatos();
	}

	private void cargarDatos() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = "2021-09-30";
		String dateInString2 = "2022-09-30";
		Date fechaInicio = new Date();
		Date fechaFin = new Date();
		try {
			fechaInicio = sdf.parse(dateInString);
			fechaFin = sdf.parse(dateInString2);
		} catch (ParseException pe) {
			System.out.println("La excepción es " + pe);
		}

		IntClienteDao iCliente = new ClienteDaoImpl();
		IntEmpleadosDao iEmpl = new EmpleadosDaoImpl();

		lista.add(new Proyecto("HJ0001", "Licencias Corporativas ", "Activo", fechaInicio, fechaFin, 5000, 2500,
				iCliente.findById("12345678A"), iEmpl.findById(2111)));
		lista.add(new Proyecto("HJ0002", "Formacion Habilidades Dirección", "Activo", fechaInicio, fechaFin, 500000L,
				250000L, iCliente.findById("23456789B"), iEmpl.findById(2111)));
		lista.add(new Proyecto("HJ0003", "Consultoría de Procesos", "Activo", fechaInicio, fechaFin, 500000L, 250000L,
				iCliente.findById("34567891C"), iEmpl.findById(2112)));
		lista.add(new Proyecto("HJ0004", "Formación Jefes de Proyectos", "Activo", fechaInicio, fechaFin, 500000L,
				250000L, iCliente.findById("45678912D"), iEmpl.findById(2113)));
		lista.add(new Proyecto("HJ0005", "Formacion Talento", "Activo", fechaInicio, fechaFin, 500000L, 250000L,
				iCliente.findById("34567891C"), iEmpl.findById(2112)));
		lista.add(new Proyecto("HJ0006", "Consultoria de productos", "Activo", fechaInicio, fechaFin, 500000L, 250000L,
				iCliente.findById("34567891C"), iEmpl.findById(2114)));

	}

	@Override
	public List<Proyecto> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Proyecto findById(String idProyecto) {
		// TODO Auto-generated method stub
		Proyecto proy = new Proyecto();
		proy.setIdProyecto(idProyecto);
		int pos = lista.indexOf(proy);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}

	@Override
	public int addProyecto(Proyecto proyecto) {
		// TODO Auto-generated method stub
		if (!lista.contains(proyecto)) {
			lista.add(proyecto);
			return 1;
		}

		return 0;
	}

	@Override
	public List<Proyecto> findByEstado(String estado) {
		// TODO Auto-generated method stub
		List<Proyecto> aux = new ArrayList<Proyecto>();
		for (Proyecto ele : lista) {
			if (ele.getEstado().equals(estado))
				aux.add(ele);
		}
		return aux;
	}

	@Override
	public int modificarEstadoProyecto(String idProyecto, String estado, double costeReal, Date fechaFinReal) {
		// TODO Auto-generated method stub
		Proyecto proyecto = findById(idProyecto);
		proyecto.setEstado(estado);
		proyecto.setCosteReal(costeReal);
		proyecto.setFechaFinReal(fechaFinReal);
		return 1;
	}

}

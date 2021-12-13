package com.edix.proyectospringweb.modelo.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.proyectospringweb.modelo.beans.ProyectoConEmpleado;

@Repository
public class ProyectoConEmpleadoDaoImpl implements IntProyectoConEmpleadosDao {

	private static int numeroOrden;
	List<ProyectoConEmpleado> lista;
	IntEmpleadosDao iemp;
	IntProyectoDao iproy;

	static {
		numeroOrden = 0;
	}

	public ProyectoConEmpleadoDaoImpl() {
		// TODO Auto-generated constructor stub
		lista = new ArrayList<ProyectoConEmpleado>();
		cargarDatos();
	}

	@Override
	public List<ProyectoConEmpleado> listaEmpleadosAsignados() {
		List<ProyectoConEmpleado> listaEmpleadosAsignados = new ArrayList<ProyectoConEmpleado>();

		for (ProyectoConEmpleado pce : lista) {
			if (pce.getEmpleado() != null)
				if (!listaEmpleadosAsignados.contains(pce))
					listaEmpleadosAsignados.add(pce);
		}
		System.out.println("La listaEmpeladosAsignados es; " + listaEmpleadosAsignados);
		return listaEmpleadosAsignados;
	}

	private void cargarDatos() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ArrayFechas[] = { "2022-01-10", "2022-03-25", "2022-03-10", "2022-05-5", "2022-01-10", "2022-12-30",
				"2022-10-10", "2022-09-10", "2022-08-01", "2022-03-27", "2022-02-23" };
		Date[] fecha = { new Date(), new Date(), new Date(), new Date(), new Date(), new Date(), new Date(), new Date(),
				new Date(), new Date(), new Date() };

		for (int i = 0; i < 11; i++) {
			fecha[i] = new Date();
		}

		try {
			for (int i = 0; i < ArrayFechas.length; i++) {
				fecha[i] = sdf.parse(ArrayFechas[i]);
			}
		} catch (ParseException pe) {
			System.out.println("La excepción es: " + pe);
		}

		IntEmpleadosDao iEmp = new EmpleadosDaoImpl();
		IntProyectoDao iProy = new ProyectoDaoImpl();

		lista.add(new ProyectoConEmpleado(1, fecha[0], 20, iEmp.findById(1111), iProy.findById("HJ0001")));
		lista.add(new ProyectoConEmpleado(2, fecha[1], 20, iEmp.findById(3111), iProy.findById("HJ0001")));
		lista.add(new ProyectoConEmpleado(3, fecha[2], 20, iEmp.findById(2111), iProy.findById("HJ0001")));
		lista.add(new ProyectoConEmpleado(4, fecha[3], 20, iEmp.findById(2112), iProy.findById("HJ0002")));
		lista.add(new ProyectoConEmpleado(5, fecha[4], 20, iEmp.findById(2113), iProy.findById("HJ0002")));
		lista.add(new ProyectoConEmpleado(6, fecha[5], 20, iEmp.findById(2114), iProy.findById("HJ0002")));
		lista.add(new ProyectoConEmpleado(7, fecha[3], 20, iEmp.findById(3111), iProy.findById("HJ0004")));
		lista.add(new ProyectoConEmpleado(8, fecha[4], 20, iEmp.findById(3112), iProy.findById("HJ0004")));
		lista.add(new ProyectoConEmpleado(9, fecha[5], 20, iEmp.findById(4111), iProy.findById("HJ0005")));
		numeroOrden = 9;
	}

	@Override
	public List<ProyectoConEmpleado> listaEmpleadosAsignadosAProyecto(String idProyecto) {
		List<ProyectoConEmpleado> aux = new ArrayList<ProyectoConEmpleado>();
		for (ProyectoConEmpleado ele : lista) {
			if (ele.getProyecto().getIdProyecto().equals(idProyecto))
				aux.add(ele);
		}
		return aux;
	}

	@Override
	public int insertarEmpleado(ProyectoConEmpleado proyectoConEmpleado) {
		proyectoConEmpleado.setNumeroOrden(++numeroOrden);
		return (lista.add(proyectoConEmpleado) ? 1 : 0);
	}

	@Override
	public List<ProyectoConEmpleado> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

}

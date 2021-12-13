package com.edix.proyectospringweb.modelo.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.proyectospringweb.modelo.beans.Empleado;
import com.edix.proyectospringweb.modelo.beans.Perfile;
import com.edix.proyectospringweb.modelo.beans.ProyectoConEmpleado;

@Repository
public class EmpleadosDaoImpl implements IntEmpleadosDao {

	List<Empleado> lista;
	IntPerfilesDao iper;
	IntDepartamentoDao idept;

	public EmpleadosDaoImpl() {
		// TODO Auto-generated constructor stub
		iper = new PerfilesDaoImpl();
		idept = new DepartamentoDaoImpl();
		lista = new ArrayList<Empleado>();
		cargarDatos();
	}

	private void cargarDatos() {
		try {
			lista.add(new Empleado(1111, "juan@proyecto.com", new SimpleDateFormat("yyyy/MM/dd").parse("1983/01/01"),
					new GregorianCalendar(1986, 8, 2).getTime(), "Juan", 2300, idept.findById(1), iper.findById(1),
					"1234"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			lista.add(new Empleado(2111, "luis@proyecto.com", new SimpleDateFormat("yyyy/MM/dd").parse("2000/03/01"),
					new GregorianCalendar(1976, 12, 25).getTime(), "Luis", 3000, idept.findById(1), iper.findById(2),
					"1234"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			lista.add(new Empleado(2112, "alberto@proyecto.com", new SimpleDateFormat("yyyy/MM/dd").parse("2000/03/01"),
					new GregorianCalendar(1976, 12, 25).getTime(), "Alberto", 3000, idept.findById(2), iper.findById(2),
					"1234"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			lista.add(new Empleado(2113, "ines@proyecto.com", new SimpleDateFormat("yyyy/MM/dd").parse("2000/03/01"),
					new GregorianCalendar(1976, 12, 25).getTime(), "Ines", 3000, idept.findById(2), iper.findById(2),
					"1234"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			lista.add(new Empleado(2114, "ana@proyecto.com", new SimpleDateFormat("yyyy/MM/dd").parse("2002/05/01"),
					new GregorianCalendar(1983, 6, 1).getTime(), "Ana", 3000, idept.findById(2), iper.findById(2),
					"1234"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lista.add(new Empleado(3111, "christian@proyecto.com", new GregorianCalendar(2021, 11, 27).getTime(),
				new GregorianCalendar(2000, 6, 14).getTime(), "Christian", 1400, idept.findById(1), iper.findById(3),
				"1234"));
		try {
			lista.add(new Empleado(3112, "aitor@proyecto.com", new SimpleDateFormat("yyyy/MM/dd").parse("2021/11/29"),
					new GregorianCalendar(1999, 4, 2).getTime(), "Aitor", 1400, idept.findById(3), iper.findById(3),
					"1234"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			lista.add(new Empleado(4111, "bianca@proyecto.com", new SimpleDateFormat("yyyy/MM/dd").parse("2000/01/15"),
					new GregorianCalendar(1993, 7, 11).getTime(), "Bianca", 2300, idept.findById(4), iper.findById(4),
					"1234"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Empleado findById(int idEmpleado) {
		// TODO Auto-generated method stub
		Empleado empleado = new Empleado();
		empleado.setIdEmpl(idEmpleado);
		int pos = lista.indexOf(empleado);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}

	@Override
	public Empleado empleadoCorrecto(int idEmpleado, String email, String password) {
		// TODO Auto-generated method stub
		for (Empleado emp : lista) {
			if (emp.getIdEmpl() == idEmpleado && emp.getCorreo().equals(email) && emp.getPassword().equals(password)) {
				return emp;
			}
		}
		return null;
	}

	@Override
	public int addEmpleado(Empleado empleado) {
		// TODO Auto-generated method stub
		if (!lista.contains(empleado)) {
			lista.add(empleado);
			return 1;
		}

		return 0;
	}

	@Override
	public int changePassword(int idEmpleado, String password) {
		// TODO Auto-generated method stub
		Empleado empleado = findById(idEmpleado);
		empleado.setPassword(password);
		return 1;
	}

	@Override
	public int changePerfile(int idEmpleado, int perfil) {
		// TODO Auto-generated method stub
		//Perfile aux = iper.findById(idEmpleado);
		Perfile aux = iper.findById(perfil);
		Empleado empleado = findById(idEmpleado);
		empleado.setPerfile(aux);
		return 1;
	}

	@Override
	public int editarEmpleado(int idEmpl) {
		Empleado aux = new Empleado();
		aux.setIdEmpl(idEmpl);
		int pos = lista.indexOf(aux);

		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, aux) != null) ? 1 : 0;
	}

	/**
	 * @param Recibe el id del empleado Elmina de la lista el Empleado
	 */
	@Override
	public int borrarEmpleado(int idEmpl) {
		Empleado aux = new Empleado();
		aux.setIdEmpl(idEmpl);
		int pos = lista.indexOf(aux);

		if (pos == -1)
			return 0;
		else
			return (lista.remove(pos) != null) ? 1 : 0;
	}

	/**
	 * @return Devuelve el id que se asigna automáticamente a un nuevo empleado
	 */
	@Override
	public int asignaId() {

		return lista.size() + 1;
	}

	@Override
	public List<Empleado> mostrarJefes() {
		List<Empleado> jefes = new ArrayList<Empleado>();

		for (Empleado e : lista) {
			if (e.getPerfile().getIdPerfil() == 2)
				jefes.add(e);
		}
		return jefes;
	}

	@Override
	public List<Empleado> operativosSinAsignarAProyectos() {
		IntProyectoConEmpleadosDao pcedao = new ProyectoConEmpleadoDaoImpl();
		List<Empleado> operativos = this.findOperativos();
		List<Empleado> sinAsignar = new ArrayList<Empleado>();

		boolean existe = false;

		for (Empleado empl : operativos) {
			existe = false;
			for (ProyectoConEmpleado pce : pcedao.listaEmpleadosAsignados()) {
				if (pce.getEmpleado().getIdEmpl() == empl.getIdEmpl()) {
					existe = true;
					break;
				}
			}
			if (!existe)
				sinAsignar.add(empl);
		}

		return sinAsignar;
	}

	@Override
	public List<Empleado> findOperativos() {
		List<Empleado> aux = new ArrayList<Empleado>();
		for (Empleado ele : lista) {
			if (ele.getPerfile().getIdPerfil() == 3) {
				aux.add(ele);
			}
		}
		return aux;
	}
}

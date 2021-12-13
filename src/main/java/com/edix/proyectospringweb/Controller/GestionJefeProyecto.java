package com.edix.proyectospringweb.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edix.proyectospringweb.modelo.beans.Proyecto;
import com.edix.proyectospringweb.modelo.repository.IntEmpleadosDao;
import com.edix.proyectospringweb.modelo.repository.IntProyectoConEmpleadosDao;
import com.edix.proyectospringweb.modelo.repository.IntProyectoConProductosDao;
import com.edix.proyectospringweb.modelo.repository.IntProyectoDao;

@Controller
@RequestMapping("/jefe")
public class GestionJefeProyecto {

	@Autowired
	IntProyectoDao iproy;
	@Autowired
	IntProyectoConEmpleadosDao conEmpleadosDao;
	@Autowired
	IntProyectoConProductosDao conProductosDao;
	@Autowired
	IntEmpleadosDao iemp;

	/*
	 * Nos muestra un jsp con los proyectos activos
	 */

	@GetMapping("/proyectos")
	public String proyectos(Model model) {
		model.addAttribute("listaProyectos", iproy.findByEstado("Activo"));
		return "indexJefe";
	}

	/*
	 * Nos muestra los detalles del proyecto seleccionado
	 */

	@GetMapping("/verDetalle/{id}")
	public String verDetalle(Model model, @PathVariable("id") String idProyecto) {
		Proyecto proyecto = iproy.findById(idProyecto);
		proyecto.setProyectoConEmpleados(conEmpleadosDao.listaEmpleadosAsignadosAProyecto(idProyecto));
		proyecto.setProyectoConProductos(conProductosDao.listaproductosAsignadosAProyecto(idProyecto));
		model.addAttribute("listaProyectos", proyecto);
		return "editarProyecto";
	}

	@GetMapping("/asignarEmpleado/{id}")
	public String asignarEmpl(Model model, @PathVariable("id") String idProyecto) {
		Proyecto proyecto = iproy.findById(idProyecto);
		model.addAttribute("listaProyectos", proyecto);
		model.addAttribute("listaEmpleados", iemp.findAll());
		return "asigEmpProy";
	}

	/*
	 * Cerramos la sesion y volvemos al login
	 */

	@GetMapping("/cerrarSesionJefe")
	public String cerrar(HttpSession session) {
		session.removeAttribute("usuario");
		session.invalidate();
		return "login";
	}

}

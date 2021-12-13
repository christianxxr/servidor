package com.edix.proyectospringweb.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edix.proyectospringweb.modelo.repository.IntEmpleadosDao;

@Controller
@RequestMapping("/empleados")
public class GestionEmpleados {

	@Autowired
	IntEmpleadosDao iemp;

	/*
	 * Mostramos el jsp de los empleados
	 */

	@GetMapping("/")
	public String inicioEmpleados(Model model) {
		return "indexEmpleados";
	}

	/*
	 * Cerramos sesion y volvemos al login
	 */

	@GetMapping("/cerrarSesionEmpleado")
	public String cerrarSesion(HttpSession session) {
		session.removeAttribute("usuario");
		session.invalidate();
		return "login";
	}

}

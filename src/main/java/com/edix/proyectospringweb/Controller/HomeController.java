package com.edix.proyectospringweb.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.proyectospringweb.modelo.beans.Empleado;
import com.edix.proyectospringweb.modelo.beans.Perfile;
import com.edix.proyectospringweb.modelo.beans.Proyecto;
import com.edix.proyectospringweb.modelo.repository.IntEmpleadosDao;
import com.edix.proyectospringweb.modelo.repository.IntPerfilesDao;

@Controller
public class HomeController {

	@Autowired
	IntEmpleadosDao iemp;
	@Autowired
	IntPerfilesDao iper;

	/*
	 * Con este método, mostramos al usuario la primera pantalla de aplicación, el
	 * login para iniciar sesion
	 */

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	/*
	 * En este método, es donde comprobamos los datos introducimos. Se comprueba que
	 * los datos sean correctos y si se cumple esa condición, según el perfil al que
	 * pertenezca, se le muestra una distinta pantalla
	 */

	@PostMapping("/login")
	public String login(Model model, Empleado empleado, Perfile perfil, Proyecto proyecto, RedirectAttributes rattr,
			HttpSession session) {
		Empleado aux = (iemp.empleadoCorrecto(empleado.getIdEmpl(), empleado.getCorreo(), empleado.getPassword()));
		if (aux != null && aux.getPerfile().getIdPerfil() == 1) {
			session.setAttribute("usuario", aux);
			return "redirect:/gestion/opciones";

		} else if (aux != null && aux.getPerfile().getIdPerfil() == 2) {
			session.setAttribute("usuario", aux);
			return "redirect:/jefe/proyectos";
		} else if (aux != null && aux.getPerfile().getIdPerfil() == 3) {
			session.setAttribute("usuario", aux);
			return "redirect:/empleados/";
		} else if (aux != null && aux.getPerfile().getIdPerfil() == 4) {
			session.setAttribute("usuario", aux);
			return "redirect:/RRHH/rrhh";
		}

		else {
			model.addAttribute("mensaje", "Usuario y/o contraseña incorrecta");
			return "login";
		}
	}

}

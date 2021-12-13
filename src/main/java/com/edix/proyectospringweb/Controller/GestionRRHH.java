package com.edix.proyectospringweb.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.proyectospringweb.modelo.beans.Empleado;
import com.edix.proyectospringweb.modelo.beans.Perfile;
import com.edix.proyectospringweb.modelo.repository.IntEmpleadosDao;
import com.edix.proyectospringweb.modelo.repository.IntPerfilesDao;

@Controller
@RequestMapping("/RRHH")
public class GestionRRHH {

	@Autowired
	IntEmpleadosDao iemp;
	@Autowired
	IntPerfilesDao iper;

	/*
	 * Método que nos permite trabajar con fechas, ya que Spring boot por si solo no
	 * es capaz.
	 */

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

	/*
	 * Nos muestra un jsp con todos empleados
	 */

	@GetMapping("/rrhh")
	public String inicioRRHH(Model model) {
		model.addAttribute("listaEmpleados", iemp.findAll());
		return "indexRRHH";
	}

	/*
	 * Nos muestra un jsp para dar de alta un empleado
	 */

	@GetMapping("/altaEmpleado")
	public String altaEmpleado(Model model) {
		model.addAttribute("listaPerfiles", iper.findAll());
		return "altaEmpleados";
	}

	/*
	 * Recogemos los datos del jsp y los guardamos en el objecto empleados para dar
	 * de alta
	 */

	@PostMapping("/altaEmpleado")
	public String alta(Model model, Empleado empleado, RedirectAttributes rattr) {
		//Perfile aux = iper.findById(empleado.getPerfile().getIdPerfil());
		/*empleado.setIdEmpl(empleado.getIdEmpl());
		empleado.setNombre(empleado.getNombre());
		empleado.setCorreo(empleado.getCorreo());
		empleado.setFechaIngreso(empleado.getFechaIngreso());
		empleado.setFechaNacimiento(empleado.getFechaNacimiento());
		empleado.setPerfile(aux);
		empleado.setPassword(empleado.getPassword());*/

		int reg = iemp.addEmpleado(empleado);

		if (reg == 1) {
			rattr.addFlashAttribute("mensaje", "Empleado dado de alta correctamente");
		} else
			rattr.addFlashAttribute("mensaje", "No se ha podido completar el alta");

		return "redirect:/RRHH/rrhh";
	}

	/*
	 * Nos muestra un jsp con el id del empleado para poder cambiarle la contraseña
	 */

	@GetMapping("/cambiarPassword/{id}")
	public String cambiar(Model model, @PathVariable("id") int idEmpl) {
		model.addAttribute("listaEmpleados", iemp.findById(idEmpl));
		return "cambiarPassword";
	}

	/*
	 * Para cambiar la contraseña, recogemos la nueva contraseña y el id del
	 * empleado, y si ha sido correcto, se cambia y nos muestra un mensaje.
	 */

	@PostMapping("/cambiarPassword")
	public String cambiar(Model model, Empleado empleado, RedirectAttributes rattr) {
		int reg = iemp.changePassword(empleado.getIdEmpl(), empleado.getPassword());

		if (reg == 1)
			rattr.addFlashAttribute("mensaje", "Contraseña cambiada");
		else
			rattr.addFlashAttribute("mensaje", "No se ha podido cambiar la contraseña");

		return "redirect:/RRHH/rrhh";
	}

	@GetMapping("/cambiarPuesto/{id}")
	public String cambiarPuesto(Model model, @PathVariable("id") int idEmpl) {
		model.addAttribute("listaEmpleados", iemp.findById(idEmpl));
		model.addAttribute("listaPerfiles", iper.findAll());
		return "cambiarPuesto";
	}

	@PostMapping("/cambiarPuesto")
	public String cambiarPuesto(Model model, Empleado empleado, RedirectAttributes rattr) {
		int reg = iemp.changePerfile(empleado.getIdEmpl(), empleado.getPerfile().getIdPerfil());

		if (reg == 1)
			rattr.addFlashAttribute("mensaje", "Puesto cambiado");
		else
			rattr.addFlashAttribute("mensaje", "No se ha podido cambiar el puesto");

		return "redirect:/RRHH/rrhh";
	}

	@GetMapping("/darBaja/{id}")
	public String eliminar(Model model, @PathVariable("id") int id, RedirectAttributes rattr) {
		int reg = iemp.borrarEmpleado(id);
		if (reg == 1)
			rattr.addFlashAttribute("mensaje", "Empleado dado de baja");
		else
			rattr.addFlashAttribute("mensaje", "No se ha podido dar de baja");

		return "redirect:/RRHH/rrhh";
	}

	/*
	 * @PostMapping("/darBaja") public String eliminar(Model model, Empleado
	 * empleado) {
	 * 
	 * }
	 */

	/*
	 * Cerramos la sesion y volvemos al login
	 */

	@GetMapping("/cerrarSesionRRHH")
	public String cerrar(HttpSession session) {
		session.removeAttribute("usuario");
		session.invalidate();
		return "login";
	}

}

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.proyectospringweb.modelo.beans.Cliente;
import com.edix.proyectospringweb.modelo.beans.Empleado;
import com.edix.proyectospringweb.modelo.beans.Producto;
import com.edix.proyectospringweb.modelo.beans.Proyecto;
import com.edix.proyectospringweb.modelo.repository.IntClienteDao;
import com.edix.proyectospringweb.modelo.repository.IntEmpleadosDao;
import com.edix.proyectospringweb.modelo.repository.IntProductoDao;
import com.edix.proyectospringweb.modelo.repository.IntProyectoDao;

@Controller
@RequestMapping("/gestion")
public class ControlGestion {

	@Autowired
	IntClienteDao icli;
	@Autowired
	IntEmpleadosDao iemp;
	@Autowired
	IntProyectoDao iproy;
	@Autowired
	IntProductoDao iprod;

	/*
	 * Es la primera pantalla donde va a parar si ha entrado un perfil con control
	 * de gestión
	 */

	@GetMapping("/opciones")
	public String opciones(Model model) {
		model.addAttribute("listaProyectos", iproy.findAll());
		model.addAttribute("listaClientes", icli.findAll());
		model.addAttribute("listaProductos", iprod.findAll());
		return "index";
	}

	/*
	 * Mostramos el jsp de alta de proyecto y recuperamos las listas para poder
	 * acceder a ellas en el jsp
	 */

	@GetMapping("/altaProyecto")
	public String altaProyecto(Model model) {
		model.addAttribute("listaProyectos", iproy.findAll());
		model.addAttribute("listaClientes", icli.findAll());
		model.addAttribute("listaEmpleados", iemp.findAll());
		return "altaProyecto";
	}

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
	 * Recuperamos los datos que hemos introducido en el jsp y los guardamos en el
	 * objeto proyecto. Si se ha podido dar el alta correctamente el proyecto,
	 * mandamos un mensaje flash, que solo dura ese instante. Si no es así, mandamos
	 * igualmente el mensaje pero diciendo que no se ha completado el alta
	 */

	@PostMapping("/altaProyecto")
	public String altaProyecto(Model model, Proyecto proyecto, RedirectAttributes rattr) {
		Cliente auxCliente = icli.findById(proyecto.getCliente().getCif());
		Empleado auxEmp = iemp.findById(proyecto.getJefeProyecto().getIdEmpl());

		proyecto.setCliente(auxCliente);
		proyecto.setJefeProyecto(auxEmp);
		proyecto.setEstado("ACTIVO");
		proyecto.setIdProyecto(proyecto.getIdProyecto());
		proyecto.setDescripcion(proyecto.getDescripcion());
		proyecto.setFechaInicio(proyecto.getFechaInicio());
		proyecto.setFechaFinPrevisto(proyecto.getFechaFinPrevisto());
		proyecto.setCostesPrevisto(proyecto.getCostesPrevisto());
		proyecto.setVentaPrevisto(proyecto.getVentaPrevisto());

		System.out.println(proyecto);

		int reg = iproy.addProyecto(proyecto);

		System.out.println(reg);

		if (reg == 1) {
			rattr.addFlashAttribute("mensaje", "proyecto creado");
		} else
			rattr.addFlashAttribute("mensaje", "proyecto no creado");

		return "redirect:/gestion/opciones";
	}

	/*
	 * Mostramos el jsp de alta de proyecto y recuperamos las lista para poder
	 * acceder a ellas en el jsp. De esta forma, vamos a poder seleccionar mediante
	 * un select option el id del proyecto que vamos a terminar
	 */

	@GetMapping("/terminarProyecto")
	public String terminarProyecto(Model model) {
		model.addAttribute("listaProyectos", iproy.findAll());
		return "terminarProyecto";
	}

	/*
	 * Cogemos los datos necesarios para poder dar por terminado el proyecto y con
	 * el método de la interface, lo modificamos pasandole el id, poniendo el estado
	 * en TERMINADO y asignándole el coste real y la fecha de fin.
	 */

	@PostMapping("/terminarProyecto")
	public String terminarProyecto(Model model, Proyecto proyecto, RedirectAttributes rattr) {

		int reg = iproy.modificarEstadoProyecto(proyecto.getIdProyecto(), "TERMINADO", proyecto.getCosteReal(),
				proyecto.getFechaFinReal());

		if (reg == 1)
			rattr.addFlashAttribute("mensaje", "proyecto terminado");
		else
			rattr.addFlashAttribute("mensaje", "error al terminar proyecto");

		return "redirect:/gestion/opciones";
	}

	/*
	 * Nos muestra el jsp para dar de alta un cliente
	 */

	@GetMapping("/altaCliente")
	public String altaCliente(Model model) {
		return "altaCliente";
	}

	/*
	 * Recogemos los datos y mandamos un mensaje según lo que haya sucedido
	 */

	@PostMapping("/altaCliente")
	public String altaCliente(Model model, Cliente cliente, RedirectAttributes rattr) {
		cliente.setCif(cliente.getCif());
		cliente.setDomicilio(cliente.getDomicilio());
		cliente.setFacturacionAnual(cliente.getFacturacionAnual());
		cliente.setNombre(cliente.getNombre());
		cliente.setNumeroEmpleados(cliente.getNumeroEmpleados());

		int reg = icli.addCliente(cliente);

		if (reg == 1)
			rattr.addFlashAttribute("mensaje", "Cliente dado de alta");
		else
			rattr.addFlashAttribute("mensaje", "Cliente no dado de alta");
		return "redirect:/gestion/opciones";

	}

	/*
	 * Nos muestra el jsp para dar de alta un cliente
	 */

	@GetMapping("/altaProducto")
	public String altaProducto(Model model) {
		return "altaProducto";
	}

	/*
	 * Recogemos los datos y mandamos un mensaje según lo que haya sucedido
	 */

	@PostMapping("/altaProducto")
	public String altaProducto(Model model, Producto producto, RedirectAttributes rattr) {
		producto.setIdProducto(producto.getIdProducto());
		producto.setDescripcionBreve(producto.getDescripcionBreve());
		producto.setPrecioUnitario(producto.getPrecioUnitario());
		producto.setStock(producto.getStock());

		int reg = iprod.addProducto(producto);

		if (reg == 1)
			rattr.addFlashAttribute("mensaje", "Producto dado de alta");
		else
			rattr.addFlashAttribute("mensaje", "Producto no dado de alta");

		return "redirect:/gestion/opciones";
	}

	/*
	 * Cerramos la sesión y volvemos al login.
	 */

	@GetMapping("/cerrarSesion")
	public String cerrarSesion(HttpSession session) {
		session.removeAttribute("usuario");
		session.invalidate();
		return "login";
	}

}

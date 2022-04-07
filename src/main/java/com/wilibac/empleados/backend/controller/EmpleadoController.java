package com.wilibac.empleados.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wilibac.empleados.backend.model.Empleado;
import com.wilibac.empleados.backend.service.IEmpleadoService;

@Controller
@RequestMapping("/")
public class EmpleadoController {

	@Autowired
	private IEmpleadoService service;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", service.buscar());
		return "index";

	}

	@PostMapping("/guardar")
	public String save(Empleado empleado, Model model) {

		service.guardar(empleado);
		return "redirect:/";
	}

	@GetMapping("/guardar/{id}")
	public String showSave(@PathVariable("id") String id, Model model) {

		if (id != null && !"0".equals(id)) {
			model.addAttribute("empleado", service.buscarPorId(id));
		} else {
			model.addAttribute("empleado", new Empleado());
		}

		return "guardar";

	}

	@GetMapping("/eliminar/{id}")
	public String delete(@PathVariable("id") String id, Model model) {
		service.eliminar(id);
		return "redirect:/";
	}
}



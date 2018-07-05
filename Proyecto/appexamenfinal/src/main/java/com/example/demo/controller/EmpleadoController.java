package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Area;
import com.example.demo.entity.Empleado;
import com.example.demo.entity.Pais;
import com.example.demo.service.IAreaServicio;
import com.example.demo.service.IEmpleadoServicio;
import com.example.demo.service.IPaisServicio;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

	@Autowired 
	private IAreaServicio areaServicio;
	
	@Autowired
	private IPaisServicio paisServicio;
	
	@Autowired
	private IEmpleadoServicio empleadoServicio;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("empleados",empleadoServicio.findAll());
		return "empleado_list";
	}
	
	@GetMapping("/agregar")
	public String empleadoAdd(Model model) {
		model.addAttribute("pais",paisServicio.findAll());
		model.addAttribute("area",areaServicio.findAll());
		model.addAttribute("empleado", new Empleado());
		return "empleado";
	}
	
	@PostMapping("/agregar")
	public String empleadoUpdate(Model model,@Valid Empleado empleado,
			@RequestParam(name = "area", required = false) Long areaID,
			@RequestParam(name = "pais", required = false) Long paisID) {
		Area areaaux = areaServicio.findById(areaID);
		Pais paisaux = paisServicio.findById(paisID);
		empleado.setArea(areaaux);
		empleado.setPais(paisaux);
		empleadoServicio.save(empleado);
		return "redirect:/empleado/listar";
	}
	
	@GetMapping("/eliminar/{empleadoID}")
	public String eliminar(Model model,@PathVariable(value = "empleadoID") Long empleadoID) {
		Empleado empleadoaux = empleadoServicio.findById(empleadoID);
		if(empleadoaux != null) {
			empleadoServicio.deleteById(empleadoID);
			return "redirect:/empleado/listar";
		}
		return "redirect:/empleado/listar";
	}
}

package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.service.protocol.IParaderoService;
import com.example.demo.models.service.protocol.IRutaParaderoService;
import com.example.demo.models.service.protocol.IRutaService;
import com.example.demo.models.service.viewmodel.RutaParaderoViewModel;

@Controller
@RequestMapping("/rutas")
public class RutaController {
	@Autowired
	public IRutaService rutaService;
	
	@Autowired
	public IRutaParaderoService rutaParaderoService;
	
	@Autowired
	public IParaderoService paraderoService;

	@GetMapping
	public String listar(Model model) {
		model.addAllAttributes(rutaService.Map());
		model.addAttribute("rutas", rutaService.findAll());
		return "rutas.html";
	}

	@GetMapping({ "/add", "/edit/{rutaID}" })
	public String rutaAddEdit(Model model, @PathVariable(required = false, name = "rutaID") String rutaID) {
		if (null != rutaID) {
			model.addAttribute("title", rutaService.Map().get("editTitle"));
			model.addAttribute("submitValue", rutaService.Map().get("edit"));
			model.addAttribute("rutaParaderoMatch", rutaParaderoService.findRutaParadero(rutaID));
		} else {
			model.addAttribute("title", rutaService.Map().get("addTitle"));
			model.addAttribute("submitValue", rutaService.Map().get("add"));
			model.addAttribute("rutaParaderoMatch", rutaParaderoService.findRutaParadero(""));
		}
		return "rutaAddEdit";
	}

	@PostMapping("/add")
	public String rutaUpdate(Model model, RutaParaderoViewModel rutaParaderoMatch) {
		rutaParaderoService.save(rutaParaderoMatch);
		model.addAllAttributes(rutaService.Map());
		model.addAttribute("rutas", rutaService.findAll());
		return "rutas";
	}
}

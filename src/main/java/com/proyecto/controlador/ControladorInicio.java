package com.proyecto.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.model.Persona;
import com.proyecto.service.PersonaServiceImp;

@Controller
@RequestMapping("/")
public class ControladorInicio {

	@Autowired
	private PersonaServiceImp personaServiceImpl;
	
	@GetMapping("/home")
	public String saludar(Model model) {
		var personas = personaServiceImpl.listarPersonas();
		model.addAttribute("personas", personas);
		return "index";
	}
	
	
	@GetMapping("/agregar")
	public String agregar(Persona personapo) {
		return "modificar";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid Persona persona, Errors errores) {
		if(errores.hasErrors()) {
			return"modificar";
		}
		personaServiceImpl.guardar(persona);
		return "redirect:/home";
	}
	
	@GetMapping("/editar/{idPersona}")
	public String editar(Persona persona, Model model) {
		persona =  personaServiceImpl.encontrarPersona(persona);
		model.addAttribute("persona", persona);
		return "modificar";
	}
	
	@GetMapping("/eliminar")
	public String eliminar(Persona persona) {
		personaServiceImpl.eliminar(persona);
		return "redirect:/home";
	}
	
	
	
	
}

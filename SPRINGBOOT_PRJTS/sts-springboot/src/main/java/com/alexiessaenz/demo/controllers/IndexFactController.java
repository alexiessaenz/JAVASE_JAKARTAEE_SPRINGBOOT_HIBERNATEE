package com.alexiessaenz.demo.controllers;

import com.alexiessaenz.demo.models.Usuario;
import com.alexiessaenz.demo.services.IServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexFactController {
	@Autowired
	@Qualifier("miServicioComplejo")
	private IServicio servicio;
	
	@GetMapping({"index", "/","home"})
	public String index(Model model ) {
		model.addAttribute("titulo","Spring Framework");
		return "index";
	}
	
	@RequestMapping({"/perfil"})
	public String perfil(Model model ) {

		model.addAttribute("objeto", servicio.operacion());
		return "perfil";
	}
	
	@RequestMapping({"/listar"})
	public String listar(Model model ) {
		model.addAttribute("titulo", textoListar);
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(Model model ) {
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Andres","Guzman","andres@email.com"),				
				new Usuario("Pablo","Escobar","pablo@email.com"),				
				new Usuario("Tormenta","Guzman","andres@email.com")				
				);
		model.addAttribute("titulo", textoListar);
		return usuarios;
	}
}

package com.alexiessaenz.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexiessaenz.demo.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	@Value("Hola Spring Framework con Model desde properties")
	private String textoIndex;
	
	@Value("Perfil del usuario: ")
	private String textoPerfil;
	
	
	@Value("Listado de usuarios desde texto.properties")
	private String textoListar;
	
	
	@GetMapping({"index", "/","home"})
	public String index(Model model ) {
		model.addAttribute("titulo","Spring Framework");
		return "index";
	}
	
	@RequestMapping({"/perfil"})
	public String perfil(Model model ) {
		Usuario u = new Usuario();
		u.setNombre("Andres");
		u.setApellido("Guzman");
		u.setEmail("andres@email.com");
		model.addAttribute("usuario",u);
		model.addAttribute("titulo",textoPerfil.concat(u.getNombre()));
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

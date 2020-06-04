package com.archy.soft.controller;

import java.util.stream.Stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.archy.soft.model.Usuario;
import com.archy.soft.repo.UsuarioRepo;


@Controller
public class MyController {
	
	private static final Log LOGGER = LogFactory.getLog(MyController.class);
	
	@Autowired
	UsuarioRepo usuarioRepo;
	
	@GetMapping("/")
	public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "index";
	}
	
	@GetMapping("/usuarios")
	public String usuarios(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		
		Stream.of(new Usuario("Noe","111 8th Av., NYC",51),
				new Usuario("Edith", "636 Avenue of the Americas, NYC",30),
				new Usuario("Jose","White House",24),
				new Usuario("Bernal", "Pentagon",22),
				new Usuario("Alex", "San Mateo Atenco",22),
				new Usuario("Juan Jose","Ixtlahuaca",57),
				new Usuario("Alfredo", "Lerma de Villada",56)
				)
				.forEach(usuarioRepo::save);

		LOGGER.info("Number of houses is " + usuarioRepo.count());
		usuarioRepo.findAll().forEach((house) -> LOGGER.info(house.getDireccion()));

		return "index";
	}
	

}

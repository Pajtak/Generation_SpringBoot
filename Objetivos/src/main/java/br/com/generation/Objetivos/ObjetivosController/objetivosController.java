package br.com.generation.Objetivos.ObjetivosController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Objetivos")
public class objetivosController {
	
	@GetMapping
	public String Objetivos() {
		return "Meus objetivos para essa semana são:"
				+ "\n[1] Conseguir aprender a utilizar o Spring Boot."
				+ "\n[2] Conseguir criar uma tabela de dados utilizando o Eclipse."
				+ "\n[3] Começar o meu projeto individual de aplicativo para um consultório.";
	}
}

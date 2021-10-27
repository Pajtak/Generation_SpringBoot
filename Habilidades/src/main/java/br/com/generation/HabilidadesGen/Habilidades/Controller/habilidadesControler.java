package br.com.generation.HabilidadesGen.Habilidades.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/HabilidadesGen")
public class habilidadesControler {
	
	@GetMapping
	public String HabilidadesGen() {
		return "As habilidades que desenvolvi hoje foram: \n[1]Persistência \n[2]Atenção ao Detalhe";
	}

}

package com.example.MinhaLojaDeGames.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MinhaLojaDeGames.Model.FuncionarioLoginModel;
import com.example.MinhaLojaDeGames.Model.FuncionarioModel;
import com.example.MinhaLojaDeGames.Repository.FuncionarioRepository;
import com.example.MinhaLojaDeGames.Service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FuncionarioController {

	@Autowired
	private FuncionarioService FuncionarioService;
	
	@Autowired
	private FuncionarioRepository FuncionarioRepository;
	
	@GetMapping("/all")
	public ResponseEntity <List<FuncionarioModel>> getAll(){
		
		return ResponseEntity.ok(FuncionarioRepository.findAll());
		
	}
	
	@PostMapping("/logar")
	public ResponseEntity<FuncionarioLoginModel> loginFuncionario(@RequestBody Optional <FuncionarioLoginModel> FuncionarioLogin){
		
		return FuncionarioService.autenticarFuncionario(FuncionarioLogin)
			.map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
			.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<FuncionarioModel> postFuncionario(@Valid @RequestBody FuncionarioModel Funcionario){
		
		return FuncionarioService.cadastrarFuncionario(Funcionario)
			.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
			.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<FuncionarioModel> putFuncionario(@Valid @RequestBody FuncionarioModel Funcionario){		
		return FuncionarioService.atualizarFuncionario(Funcionario)
			.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
			.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}

}
package com.example.MinhaLojaDeGames.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.MinhaLojaDeGames.Model.CategoriaModel;
import com.example.MinhaLojaDeGames.Repository.CategoriaRepository;

@Valid
@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id_categoria}")
	public ResponseEntity<CategoriaModel> GetById(@PathVariable long id_categoria) {
		return repository.findById(id_categoria).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/Titulo/{Titulo}")
	public ResponseEntity<List<CategoriaModel>> GetByTitulo(@PathVariable String Titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(Titulo));
	}
	@GetMapping("/Genero/{Genero}")
	public ResponseEntity<List<CategoriaModel>> GetByGenero(@PathVariable String genero) {
		return ResponseEntity.ok(repository.findAllByGeneroContainingIgnoreCase(genero));
	}	
	@GetMapping("/Plataforma/{Plataforma}")
	public ResponseEntity<List<CategoriaModel>> GetByPlataforma(@PathVariable String plataforma) {
		return ResponseEntity.ok(repository.findAllByPlataformaContainingIgnoreCase(plataforma));
	}	
	
	@PostMapping
	public ResponseEntity<CategoriaModel> post (@RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	@PutMapping
	public ResponseEntity<CategoriaModel> put (@RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@DeleteMapping("/{id_categoria}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
}

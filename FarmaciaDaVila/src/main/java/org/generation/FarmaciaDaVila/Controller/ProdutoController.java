package org.generation.FarmaciaDaVila.Controller;

import java.math.BigDecimal;
import java.util.List;

import org.generation.FarmaciaDaVila.Model.ProdutoModel;
import org.generation.FarmaciaDaVila.Repository.ProdutoRepository;
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

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity <List<ProdutoModel>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> getById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ProdutoModel>> getByNome(String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));		
	}
	@GetMapping("/precoMaior/{precoMaior}")
	public ResponseEntity<List<ProdutoModel>> getByPrecoMaior(BigDecimal preco){
		return ResponseEntity.ok(repository.findByPrecoGreaterThanOrderByPrecoAsc(preco));		
	}
	@GetMapping("/precoMenor/{precoMenor}")
	public ResponseEntity<List<ProdutoModel>> getByPrecoMenor(BigDecimal preco){
		return ResponseEntity.ok(repository.findByPrecoLessThanOrderByPrecoAsc(preco));
	}
	@PostMapping
	public ResponseEntity<ProdutoModel> post(@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	@PutMapping
	public ResponseEntity<ProdutoModel> put(@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	@DeleteMapping
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}



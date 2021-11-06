package com.example.MinhaLojaDeGames.Controller;

import java.math.BigDecimal;
import java.util.List;

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

import com.example.MinhaLojaDeGames.Model.ProdutoModel;
import com.example.MinhaLojaDeGames.Repository.ProdutoRepository;



@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id_produto}")
	public ResponseEntity<ProdutoModel> GetById(@PathVariable long id_produto) {
		return repository.findById(id_produto).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/Titulo/{Titulo}")
	public ResponseEntity<List<ProdutoModel>> GetByTitulo(@PathVariable String Titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(Titulo));
	}
	@GetMapping("/MaiorPreço/{MaiorPreço}")
	public ResponseEntity<List<ProdutoModel>> GetByPreco(@PathVariable BigDecimal preco) {
		return ResponseEntity.ok(repository.findByPrecoGreaterThanOrderByPreco(preco));
	}	
	@GetMapping("/MenorPreço/{MenorPreço}")
	public ResponseEntity<List<ProdutoModel>> GetByPreco1(@PathVariable BigDecimal preco) {
		return ResponseEntity.ok(repository.findByPrecoLessThanOrderByPrecoDesc(preco));
	}
	@GetMapping("/Preço/{Preço}")
	public ResponseEntity<List<ProdutoModel>> GetByPreco2(@PathVariable BigDecimal preco) {
		return ResponseEntity.ok(repository.findAllByPreco(preco));
	}
	@GetMapping("/Quantidade/{Quantidade}")
	public ResponseEntity<List<ProdutoModel>> GetByQuantidade(@PathVariable int quantidade) {
		return ResponseEntity.ok(repository.findAllByQuantidade(quantidade));
	}
	@PostMapping
	public ResponseEntity<ProdutoModel> post (@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	@PutMapping
	public ResponseEntity<ProdutoModel> put (@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@DeleteMapping("/{id_produto}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}

}

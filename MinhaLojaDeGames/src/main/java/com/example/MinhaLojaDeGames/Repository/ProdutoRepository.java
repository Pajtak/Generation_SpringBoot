package com.example.MinhaLojaDeGames.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MinhaLojaDeGames.Model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
	
	
	public List<ProdutoModel> findAllByTituloContainingIgnoreCase (String titulo);
	public List<ProdutoModel> findByPrecoGreaterThanOrderByPreco (BigDecimal preco);
	public List<ProdutoModel> findByPrecoLessThanOrderByPrecoDesc (BigDecimal preco);
	public List<ProdutoModel> findAllByPreco (BigDecimal preco);
	public List<ProdutoModel> findAllByQuantidade (Integer quantidade);
}

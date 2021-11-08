package org.generation.FarmaciaDaVila.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.generation.FarmaciaDaVila.Model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
	
		public List<ProdutoModel> findAllByNomeContainingIgnoreCase(String nome);
		public List<ProdutoModel> findByPrecoGreaterThanOrderByPrecoAsc(BigDecimal preco);
		public List<ProdutoModel> findByPrecoLessThanOrderByPrecoAsc(BigDecimal preco);
}

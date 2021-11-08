package org.generation.FarmaciaDaVila.Repository;

import java.util.List;

import org.generation.FarmaciaDaVila.Model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
	
		public List<CategoriaModel> findAllByTarjaContainingIgnoreCase(String tarja);
}

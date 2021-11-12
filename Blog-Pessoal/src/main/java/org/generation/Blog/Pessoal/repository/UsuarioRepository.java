package org.generation.Blog.Pessoal.repository;

import java.util.Optional;

import org.generation.Blog.Pessoal.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

	public Optional<UsuarioModel> findByUsuario(String Usuario);
}

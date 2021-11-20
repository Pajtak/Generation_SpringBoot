package com.example.MinhaLojaDeGames.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MinhaLojaDeGames.Model.FuncionarioModel;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {

	public Optional<FuncionarioModel> findByFuncionario(String funcionario);

	public List<FuncionarioModel> findByNomeContainingIgnoreCase(String nome);
}

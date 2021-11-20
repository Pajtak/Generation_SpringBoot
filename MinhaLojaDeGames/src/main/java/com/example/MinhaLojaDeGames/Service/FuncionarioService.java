package com.example.MinhaLojaDeGames.Service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.MinhaLojaDeGames.Model.FuncionarioLoginModel;
import com.example.MinhaLojaDeGames.Model.FuncionarioModel;
import com.example.MinhaLojaDeGames.Repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository FuncionarioRepository;

	public Optional<FuncionarioModel> cadastrarFuncionario(FuncionarioModel Funcionario) {

		if (FuncionarioRepository.findByFuncionario(Funcionario.getLogin()).isPresent())
			return Optional.empty();

		Funcionario.setSenha(criptografarSenha(Funcionario.getSenha()));

		return Optional.of(FuncionarioRepository.save(Funcionario));

	}

	public Optional<FuncionarioModel> atualizarFuncionario(FuncionarioModel Funcionario) {

		if (FuncionarioRepository.findById(Funcionario.getId()).isPresent()) {

			Optional<FuncionarioModel> buscaFuncionario = FuncionarioRepository
					.findByFuncionario(Funcionario.getLogin());

			if (buscaFuncionario.isPresent()) {
				if (buscaFuncionario.get().getId() != Funcionario.getId())
					return Optional.empty();
			}

			Funcionario.setSenha(criptografarSenha(Funcionario.getSenha()));

			return Optional.of(FuncionarioRepository.save(Funcionario));
		}

		return Optional.empty();
	}

	public Optional<FuncionarioLoginModel> autenticarFuncionario(Optional<FuncionarioLoginModel> FuncionarioLogin) {

		Optional<FuncionarioModel> Funcionario = FuncionarioRepository
				.findByFuncionario(FuncionarioLogin.get().getLogin());

		if (Funcionario.isPresent()) {
			if (compararSenhas(FuncionarioLogin.get().getSenha(), Funcionario.get().getSenha())) {

				String token = gerarBasicToken(FuncionarioLogin.get().getLogin(), FuncionarioLogin.get().getSenha());
				FuncionarioLogin.get().setId(Funcionario.get().getId());
				FuncionarioLogin.get().setNome(Funcionario.get().getNome());
				FuncionarioLogin.get().setSenha(Funcionario.get().getSenha());
				FuncionarioLogin.get().setToken(token);

				return FuncionarioLogin;

			}
		}

		return Optional.empty();

	}

	private String criptografarSenha(String senha) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		return encoder.encode(senha);

	}

	private boolean compararSenhas(String senhaDigitada, String senhaBanco) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		return encoder.matches(senhaDigitada, senhaBanco);

	}

	private String gerarBasicToken(String email, String password) {

		String tokenBase = email + ":" + password;
		byte[] tokenBase64 = Base64.encodeBase64(tokenBase.getBytes(Charset.forName("US-ASCII")));
		return "Basic " + new String(tokenBase64);

	}

}
package com.example.MinhaLojaDeGames.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.MinhaLojaDeGames.Model.FuncionarioModel;
import com.example.MinhaLojaDeGames.Repository.FuncionarioRepository;

@Service
public class FuncDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private FuncionarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String funcionarioName) throws UsernameNotFoundException{
		Optional<FuncionarioModel> user = userRepository.findByFuncionario(funcionarioName);
		user.orElseThrow(() -> new UsernameNotFoundException(funcionarioName + "not found."));
		
		return user.map(FuncDetailsImpl::new).get();
	}

}
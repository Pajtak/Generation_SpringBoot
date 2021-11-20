package com.example.MinhaLojaDeGames.Security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.MinhaLojaDeGames.Model.FuncionarioModel;

public class FuncDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String funcionarioName;

	private String password;
	
	private List<GrantedAuthority> authorities;

	public FuncDetailsImpl(FuncionarioModel funcionario) {
		this.funcionarioName = funcionario.getLogin();
		this.password = funcionario.getSenha();
	}

	public FuncDetailsImpl() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return funcionarioName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
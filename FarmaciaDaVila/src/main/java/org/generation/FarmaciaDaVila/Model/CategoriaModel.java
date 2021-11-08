package org.generation.FarmaciaDaVila.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
@Valid
public class CategoriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
	@Size(max = 20)
	private String tarja;

	
	private boolean receita;


	private Boolean produtos_gerais = true;
	
	@NotNull
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")	
	private List<ProdutoModel> produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTarja() {
		return tarja;
	}

	public void setTarja(String tarja) {
		this.tarja = tarja;
	}

	public boolean isReceita() {
		return receita;
	}

	public void setReceita(boolean receita) {
		this.receita = receita;
	}

	public Boolean getProdutos_gerais() {
		return produtos_gerais;
	}

	public void setProdutos_gerais(Boolean produtos_gerais) {
		this.produtos_gerais = produtos_gerais;
	}

	public List<ProdutoModel> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoModel> produto) {
		this.produto = produto;
	}


}

	
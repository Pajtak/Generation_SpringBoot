package com.example.MinhaLojaDeGames.Model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
@Valid
public class ProdutoModel {

	public ProdutoModel() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_produto;

	@NotBlank
	private String titulo;
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@NotNull
	@Positive(message = "O preço deve ser maior do que 0")
	private BigDecimal preco;

	@NotNull
	@Range(min = 0)
	private Integer quantidade;

	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private CategoriaModel categoria;

	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private FuncionarioModel funcionario;

	public long getId_produto() {
		return id_produto;
	}

	public void setId_produto(long id_produto) {
		this.id_produto = id_produto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public CategoriaModel getFk_categoria() {
		return categoria;
	}

	public void setFk_categoria(CategoriaModel fk_categoria) {
		this.categoria = fk_categoria;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

	public FuncionarioModel getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioModel funcionario) {
		this.funcionario = funcionario;
	}

}

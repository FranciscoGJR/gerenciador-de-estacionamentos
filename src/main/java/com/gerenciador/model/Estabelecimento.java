package com.gerenciador.model;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Estabelecimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "identificador")
	@NotNull
	Integer identificador;

	@Column(name = "nome", length = 32, nullable = false)
	@NotNull
	String nome;

	@Column(name = "cnpj", length = 16, nullable = false)
	@NotNull
	String cnpj;

	@Column(name = "endereco", length = 32, nullable = false)
	@NotNull
	String endereco;

	@Column(name = "telefone", length = 16, nullable = false)
	@NotNull
	String telefone;

	@Column(name = "quantidade_vagas_motos", nullable = false)
	@NotNull
	Integer quantidadeVagasMotos;

	@Column(name = "quantidade_vagas_carros")
	@NotNull
	Integer quantidadeVagasCarros;

	public Estabelecimento() {

	}

	public Estabelecimento(@NotNull Integer identificador, @NotNull String nome, @NotNull String cnpj,
			@NotNull String endereco, @NotNull String telefone, @NotNull Integer quantidadeVagasMotos,
			@NotNull Integer quantidadeVagasCarros) {
		this.identificador = identificador;
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
		this.quantidadeVagasMotos = quantidadeVagasMotos;
		this.quantidadeVagasCarros = quantidadeVagasCarros;
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getQuantidadeVagasCarros() {
		return quantidadeVagasCarros;
	}

	public void setQuantidadeVagasCarros(Integer quantidadeVagasCarros) {
		this.quantidadeVagasCarros = quantidadeVagasCarros;
	}

}

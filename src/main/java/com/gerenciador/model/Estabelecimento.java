package com.gerenciador.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ESTABELECIMENTO")
public class Estabelecimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ESTABELECIMENTO")
	@NotNull
	Integer idEstabelecimento;

	@Column(name = "NOME", length = 32, nullable = false)
	@NotNull
	String nome;

	@Column(name = "CNPJ", length = 16, nullable = false)
	@NotNull
	String cnpj;

	@Column(name = "ENDERECO", length = 32, nullable = false)
	@NotNull
	String endereco;

	@Column(name = "TELEFONE", length = 16, nullable = false)
	@NotNull
	String telefone;
	
	@OneToMany(mappedBy = "estabelecimentos")
	private List<Estacionamento> estacionamentos;
	
	public Estabelecimento() {
	}

	public Integer getEstabelecimentoIdentificador() {
		return idEstabelecimento;
	}

	public void setEstabelecimentoIdentificador(Integer estabelecimentoIdentificador) {
		this.idEstabelecimento = estabelecimentoIdentificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}

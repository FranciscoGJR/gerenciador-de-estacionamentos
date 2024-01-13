package com.gerenciador.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @JsonManagedReference
	@OneToMany(mappedBy = "estabelecimentos")
	private List<Estacionamento> estacionamentos;

	public Estabelecimento() {
	}

	public Estabelecimento(@NotNull Integer idEstabelecimento, @NotNull String nome, @NotNull String cnpj,
			@NotNull String endereco, @NotNull String telefone) {
		this.idEstabelecimento = idEstabelecimento;
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Integer getIdEstabelecimento() {
		return idEstabelecimento;
	}

	public void setIdEstabelecimento(Integer idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
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

	public List<Estacionamento> getEstacionamentos() {
		return estacionamentos;
	}

	public void setEstacionamentos(List<Estacionamento> estacionamentos) {
		this.estacionamentos = estacionamentos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

package com.gerenciador.model.dto;

import java.io.Serializable;

public class EstabelecimentoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	
	Integer identificador;

	String nome;

	String cnpj;

	String endereco;

	String telefone;

	public EstabelecimentoDTO() {
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
	
}

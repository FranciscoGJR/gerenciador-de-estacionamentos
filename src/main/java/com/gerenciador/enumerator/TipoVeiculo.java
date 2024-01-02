package com.gerenciador.enumerator;

public enum TipoVeiculo {
	MOTO("Moto"),
	CARRO("Carro");

	private String descricao;
	
	TipoVeiculo(String descricao) {
	this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}

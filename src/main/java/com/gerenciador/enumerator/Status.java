package com.gerenciador.enumerator;

public enum Status {
	NAO_CONCLUIDO("NaoConcluido"),
	PAGO("Pago"),
	CONCLUIDO("Concluido"),
	ARQUIVADO("Arquivado");
	
	private String descricao;
	
	Status(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}

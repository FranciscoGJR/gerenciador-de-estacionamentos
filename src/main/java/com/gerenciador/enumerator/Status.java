package com.gerenciador.enumerator;

public enum Status {
	ENTRADA_REGISTRADA_E_NAO_PAGA("EntradaRegistradaNaoPaga"),
	PAGO_E_ENTRADA_NAO_REGISTRADA("PagoEEntradaNaoRegistrada"),					
	SAIDA_REGISTRADA("SaidaRegistrada"),			
	ARQUIVADO("Arquivado");			
	
	private String descricao;
	
	Status(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}

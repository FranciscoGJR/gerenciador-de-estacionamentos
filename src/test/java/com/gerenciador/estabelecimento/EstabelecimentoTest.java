package com.gerenciador.estabelecimento;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import model.Estabelecimento;

@TestInstance(Lifecycle.PER_CLASS)
class EstabelecimentoTest {

	private Estabelecimento estabelecimentoPadrao;
	
	@BeforeAll
	void definirEstabelecimento() {
		estabelecimentoPadrao = new Estabelecimento("Loja A", "Av. Brasil", 20, 100);
	}
	
	@Test
	void testGetNome() {
		Estabelecimento estabelecimento = new Estabelecimento("Loja A", "Av. Brasil", 20, 100);
		String nome = estabelecimento.getNome();
		Assertions.assertEquals("Loja A", nome);
		
	}

}

package com.gerenciador.estabelecimento;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.gerenciador.model.Estabelecimento;

@TestInstance(Lifecycle.PER_CLASS)
class EstabelecimentoTest {

	private Estabelecimento estabelecimentoPadrao;

	@BeforeAll
	void definirEstabelecimento() {
		estabelecimentoPadrao = new Estabelecimento(1, "Loja A", "XX.XXX.XXX/0001-XX", "Av. Brasil", "+55(00)0000-0000",
				10, 20);
	}

	@Test
	void testGetNome() {
		estabelecimentoPadrao.setNome("Loja A");
		String nome = estabelecimentoPadrao.getNome();
		Assertions.assertEquals("Loja A", nome);
	}

}

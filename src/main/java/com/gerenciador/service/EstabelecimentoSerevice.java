package com.gerenciador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gerenciador.model.Estabelecimento;
import com.gerenciador.repository.EstabelecimentoRepository;

public class EstabelecimentoSerevice {
	
	@Autowired
	EstabelecimentoRepository estabelecimentoRepository;
	
	public List<Estabelecimento> getEstabelecimento() {
		return null;
	}

	public Estabelecimento save() {
		return null;
	}

	public Estabelecimento findById() {
		return null;
	}

	public List<Estabelecimento> findByNome() {
		return null;
	}

	public void update() {
		return;
	}

	public void delete() {
		return;
	}

}

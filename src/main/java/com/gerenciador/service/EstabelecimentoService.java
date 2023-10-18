package com.gerenciador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.model.Estabelecimento;
import com.gerenciador.repository.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {

	@Autowired
	EstabelecimentoRepository estabelecimentoRepository;

	public Estabelecimento save(Estabelecimento estabelecimento) {
		return estabelecimentoRepository.save(estabelecimento);
	}

	public List<Estabelecimento> getEstabelecimento() {
		return estabelecimentoRepository.findAll();
	}

	public Estabelecimento findById(Integer id) {
		Optional<Estabelecimento> estabelecimento = estabelecimentoRepository.findById(id);
		return estabelecimento.orElse(null);
	}

	public Estabelecimento update(Estabelecimento estabelecimento, Integer id) {
		estabelecimento.setIdentificador(id);
		return estabelecimentoRepository.save(estabelecimento);
	}

	public void delete(Integer id) {
		estabelecimentoRepository.deleteById(id);
	}

}

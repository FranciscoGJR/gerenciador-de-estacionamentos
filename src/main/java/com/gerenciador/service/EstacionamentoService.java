package com.gerenciador.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.model.Estacionamento;
import com.gerenciador.repository.EstacionamentoRepository;

@Service
public class EstacionamentoService {

	@Autowired
	EstacionamentoRepository estacionamentoRepository;
	
	public Estacionamento findById(Integer id) {
		Optional<Estacionamento> estacionamento = estacionamentoRepository.findById(id); 
		return estacionamento.orElse(null);
	}
}

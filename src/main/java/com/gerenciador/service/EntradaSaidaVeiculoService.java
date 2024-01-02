package com.gerenciador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.model.Estacionamento;
import com.gerenciador.model.Veiculo;

@Service
public class EntradaSaidaVeiculoService {

	@Autowired
	EstacionamentoService estacionamentoService;
	
	@Autowired
	VeiculoService veiculoService;
	
	public void registrarEntradaDeVeiculo(Integer idEstacionamento, Integer idVeiculo) {
		Estacionamento estacionamento = estacionamentoService.findById(idEstacionamento);
		Veiculo veiculo = veiculoService.findById(idVeiculo);
	}
	
}

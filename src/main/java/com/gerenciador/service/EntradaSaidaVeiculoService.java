package com.gerenciador.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.model.EntradaSaidaVeiculo;
import com.gerenciador.model.Estacionamento;
import com.gerenciador.model.Veiculo;
import com.gerenciador.repository.EntradaSaidaVeiculoRepository;

@Service
public class EntradaSaidaVeiculoService {

	@Autowired
	EstacionamentoService estacionamentoService;

	@Autowired
	EntradaSaidaVeiculoRepository entradaSaidaVeiculoRepository;
	@Autowired
	VeiculoService veiculoService;

	public EntradaSaidaVeiculo save(EntradaSaidaVeiculo entradaSaidaVeiculo) {
		return entradaSaidaVeiculoRepository.save(entradaSaidaVeiculo);
	}
	
	public EntradaSaidaVeiculo findById(Integer id) {
		Optional<EntradaSaidaVeiculo> entradaSaidaVeiculo = entradaSaidaVeiculoRepository.findById(id);
		return entradaSaidaVeiculo.orElse(null);
	}

	public EntradaSaidaVeiculo registrarEntradaDeVeiculo(Integer idEstacionamento, Integer idVeiculo) {
		Estacionamento estacionamento = estacionamentoService.findById(idEstacionamento);
		Veiculo veiculo = veiculoService.findById(idVeiculo);

		EntradaSaidaVeiculo entradaSaidaVeiculo = new EntradaSaidaVeiculo(veiculo, estacionamento);

		return this.save(entradaSaidaVeiculo);
	}

}

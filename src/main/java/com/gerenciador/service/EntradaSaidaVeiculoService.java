package com.gerenciador.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.exception.EstacionamentoSemVagaVisponívelException;
import com.gerenciador.exception.VeiculoJaEstacionadoException;
import com.gerenciador.model.EntradaSaidaVeiculo;
import com.gerenciador.model.Estacionamento;
import com.gerenciador.model.Veiculo;
import com.gerenciador.repository.EntradaSaidaVeiculoRepository;

@Service
public class EntradaSaidaVeiculoService {

	@Autowired
	private EstacionamentoService estacionamentoService;

	@Autowired
	private EntradaSaidaVeiculoRepository entradaSaidaVeiculoRepository;
	
	@Autowired
	private VeiculoService veiculoService;

	public EntradaSaidaVeiculo save(EntradaSaidaVeiculo entradaSaidaVeiculo) {
		return entradaSaidaVeiculoRepository.save(entradaSaidaVeiculo);
	}
	
	public EntradaSaidaVeiculo findById(Integer id) {
		Optional<EntradaSaidaVeiculo> entradaSaidaVeiculo = entradaSaidaVeiculoRepository.findById(id);
		return entradaSaidaVeiculo.orElse(null);
	}
	
	public boolean veiculoJaEstacionado(Integer idVeiculo, Integer idEstacionamento) {
		if(entradaSaidaVeiculoRepository.veiculoJaEstacionado(idEstacionamento, idVeiculo) == null) {
			return false;
		}
		return true;
	}

	public EntradaSaidaVeiculo registrarEntradaDeVeiculo(Integer idEstacionamento, Integer idVeiculo) throws Exception {
		Estacionamento estacionamento = estacionamentoService.findById(idEstacionamento);
		Veiculo veiculo = veiculoService.findById(idVeiculo);
		
		if(estacionamentoService.quantidadeVagasDisponiveis(idEstacionamento, veiculo.getTipoVeiculo()) == 0) {
			throw new EstacionamentoSemVagaVisponívelException();
		}
		
		if(veiculoJaEstacionado(idVeiculo, idEstacionamento)) {
			throw new VeiculoJaEstacionadoException();
		}
		
		EntradaSaidaVeiculo entradaSaidaVeiculo = new EntradaSaidaVeiculo(veiculo, estacionamento);

		return save(entradaSaidaVeiculo);
	}

}

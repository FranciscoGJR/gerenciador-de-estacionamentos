package com.gerenciador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.model.Veiculo;
import com.gerenciador.repository.VeiculoRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepository;

	public List<Veiculo> getVeiculo() {
		return null;
	}

	public Veiculo save(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	public Veiculo findById(Integer id) {
		Optional<Veiculo> veiculo = veiculoRepository.findById(id);
		return veiculo.orElse(null);
	}

	public Veiculo update(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	public void delete() {
		return;
	}

}

package com.gerenciador.service;

import java.util.List;

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

	public Veiculo save() {
		return null;
	}

	public Veiculo findById() {
		return null;
	}

	public List<Veiculo> findByNome() {
		return null;
	}

	public void update() {
		return;
	}

	public void delete() {
		return;
	}

}

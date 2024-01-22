package com.gerenciador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciador.model.EntradaSaidaVeiculo;
import com.gerenciador.model.Estabelecimento;
import com.gerenciador.service.EntradaSaidaVeiculoService;
import com.gerenciador.service.EstabelecimentoService;

@RestController
@RequestMapping("/estabelecimento")
public class EstabeleciementoController {

	@Autowired
	private EstabelecimentoService estabelecimentoService;

	@Autowired
	private EntradaSaidaVeiculoService entradaSaidaVeiculoService;

	@PutMapping("/entrada/{idEstacionamento}/{idVeiculo}")
	public EntradaSaidaVeiculo entradaDeVeiculo(@PathVariable("idEstacionamento") Integer idEstacionamento,
			@PathVariable("idVeiculo") Integer idVeiculo) throws Exception {
		EntradaSaidaVeiculo entradaSaidaVeiculo = entradaSaidaVeiculoService.registrarEntradaDeVeiculo(idEstacionamento,
				idVeiculo);
		return entradaSaidaVeiculo;
	}

	@PutMapping("/saida/{idEntradaVeiculo}")
	public EntradaSaidaVeiculo saidaDeVeiculo(@PathVariable("idEntradaVeiculo") Integer idEntradaVeiculo) throws Exception {
		EntradaSaidaVeiculo entradaVeiulo = entradaSaidaVeiculoService.registrarSaidaDeVeiculo(idEntradaVeiculo);
		return entradaVeiulo;
	}

	@GetMapping
	public ResponseEntity<List<Estabelecimento>> getEstabelecimento() {
		List<Estabelecimento> lista = estabelecimentoService.getEstabelecimento();

		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Estabelecimento> getEstabelecimentoById(@PathVariable("id") Integer id) {
		Estabelecimento estabelecimento = estabelecimentoService.findById(id);

		return ResponseEntity.ok().body(estabelecimento);
	}
}

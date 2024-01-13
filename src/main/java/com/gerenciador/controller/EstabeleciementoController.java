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

	@PutMapping("/entrada/{idEstabeleciemento}/{idVeiculo}")
	public EntradaSaidaVeiculo entradaDeVeiculo(@PathVariable("idEstabeleciemento") Integer idEstabeleciemento,
			@PathVariable("idVeiculo") Integer idVeiculo) throws Exception {
		EntradaSaidaVeiculo entradaSaidaVeiculo = entradaSaidaVeiculoService.registrarEntradaDeVeiculo(idEstabeleciemento, idVeiculo);
		return entradaSaidaVeiculo;
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

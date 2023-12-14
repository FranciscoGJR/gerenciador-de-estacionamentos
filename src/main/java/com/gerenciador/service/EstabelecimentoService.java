package com.gerenciador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.model.Estabelecimento;
import com.gerenciador.model.Veiculo;
import com.gerenciador.repository.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {

	@Autowired
	EstabelecimentoRepository estabelecimentoRepository;

	@Autowired
	VeiculoService veiculoService;

	public Estabelecimento save(Estabelecimento estabelecimento) {
		return estabelecimentoRepository.save(estabelecimento);
	}

	public List<Estabelecimento> getEstabelecimento() {
		return estabelecimentoRepository.findAll();
	}

	public Estabelecimento findById(Integer id) {
		Estabelecimento estabelecimento = estabelecimentoRepository.findById(id).orElseThrow();
		return estabelecimento;
	}

	public Estabelecimento update(Estabelecimento estabelecimento, Integer id) {
		estabelecimento.setIdentificador(id);
		return estabelecimentoRepository.save(estabelecimento);
	}

	public void delete(Integer id) {
		estabelecimentoRepository.deleteById(id);
	}

	public Veiculo registrarEntradaDeVeiculo(Integer idEstabelecimento, Integer idVeiculo) {

		Estabelecimento estabelecimento = findById(idEstabelecimento);
		Veiculo veiculo = veiculoService.findById(idVeiculo);

		if (veiculo.getEstabelecimentoAtual() == estabelecimento) {
			// TO-DO: lancar excecao veiculo ja estacionado no estabelecimento atual
		}

		if (!temVagaDisponivel(estabelecimento, veiculo)) {
			// TO-DO: lancar excecao nao tem vaga dispobivel no estacionamento
		}

		atualizarEstacionamento(estabelecimento, veiculo);

		veiculo.setEstabelecimentoAtual(estabelecimento);

		return veiculo;

	}

	private void atualizarEstacionamento(Estabelecimento estabelecimento, Veiculo veiculo) {
		if (veiculo.getTipo().equals("CARRO")) {
			estabelecimento.adicionarCarroEstacionado(veiculo);
		}

		if (veiculo.getTipo().equals("MOTO")) {
			estabelecimento.adicionarMotoEstacionada(veiculo);
		}

	}

	private boolean temVagaDisponivel(Estabelecimento estabelecimento, Veiculo veiculo) {
		if (veiculo.getTipo().equals("CARRO")) {
			Integer quantidadeCarrosEstacionados = estabelecimento.getCarrosEstacionados().size();
			Integer quantidadeMaximaCarros = estabelecimento.getQuantidadeVagasCarros();

			if (quantidadeCarrosEstacionados == quantidadeMaximaCarros) {
				return false;
			}
			return true;
		}

		if (veiculo.getTipo().equals("MOTO")) {
			Integer quantidadeMotosEstacionadas = estabelecimento.getMotosEstacionadas().size();
			Integer quantidadeMaximaMotos = estabelecimento.getQuantidadeVagasMotos();

			if (quantidadeMotosEstacionadas == quantidadeMaximaMotos) {
				return false;
			}
			return true;
		}

		return false;
	}

}

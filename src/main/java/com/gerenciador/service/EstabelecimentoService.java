package com.gerenciador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.model.Estabelecimento;
import com.gerenciador.model.Veiculo;
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

	public void registrarEntradaDeVeiculo(Estabelecimento estabelecimento, Veiculo veiculo) {

		// TO-DO: verificar se o veiculo esta estacionado

		if (temVagaDisponivel(estabelecimento, veiculo)) {

			// TO-DO: atualizar Estabelecimento.carrosEstacionados ou
			// TO-DO: atualizar Veiculo.estabelecimentoAtual
		}

	}

	private boolean temVagaDisponivel(Estabelecimento estabelecimento, Veiculo veiculo) {

		if (veiculo.getTipo().equals("CARRO")) {
			Integer quantidadeCarrosEstacionados = estabelecimento.getCarrosEstacionados().size();
			Integer quantidadeMaximaCarros = estabelecimento.getQuantidadeVagasCarros();

			if (quantidadeCarrosEstacionados == quantidadeMaximaCarros)
				return false;
			return true;
		}

		if (veiculo.getTipo().equals("MOTO")) {
			Integer quantidadeMotosEstacionadas = estabelecimento.getMotosEstacionadas().size();
			Integer quantidadeMaximaMotos = estabelecimento.getQuantidadeVagasMotos();

			if (quantidadeMotosEstacionadas == quantidadeMaximaMotos)
				return false;
			return true;
		}

		return false;
	}

}

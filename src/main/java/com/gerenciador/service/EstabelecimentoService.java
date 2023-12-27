package com.gerenciador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.exception.EstacionamentoSemVagaVisponívelException;
import com.gerenciador.exception.VeiculoJaEstacionadoException;
import com.gerenciador.model.Estabelecimento;
import com.gerenciador.model.Veiculo;
import com.gerenciador.repository.EstabelecimentoRepository;
import com.gerenciador.repository.VeiculoRepository;

@Service
public class EstabelecimentoService {

	@Autowired
	EstabelecimentoRepository estabelecimentoRepository;

	@Autowired
	VeiculoService veiculoService;

	@Autowired
	VeiculoRepository veiculoRepository;

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

	public Veiculo registrarEntradaDeVeiculo(Integer idEstabelecimento, Integer idVeiculo) throws Exception {
		Estabelecimento estabelecimento = findById(idEstabelecimento);
		Veiculo veiculo = veiculoRepository.findById(idVeiculo).orElse(null);

		if (veiculo.getEstabelecimentoAtual() == estabelecimento) {
			throw new VeiculoJaEstacionadoException();
		}

		if (veiculo.getEstabelecimentoAtual() != null) {
			throw new VeiculoJaEstacionadoException();
		}

		if (!temVagaDisponivel(estabelecimento, veiculo)) {
			throw new EstacionamentoSemVagaVisponívelException();
		}

		veiculo.setEstabelecimentoAtual(estabelecimento);
		atualizarVeiculosEstacionados(estabelecimento, veiculo);

		update(estabelecimento, idEstabelecimento);
		veiculoService.update(veiculo, idVeiculo);

		return veiculo;

	}

	private void atualizarVeiculosEstacionados(Estabelecimento estabelecimento, Veiculo veiculo) {
		if (veiculo.getTipo().equals("CARRO")) {
			estabelecimento.addCarrosEstacionados(veiculo);

		}

		if (veiculo.getTipo().equals("MOTO")) {
			estabelecimento.addMotosEstacionadas(veiculo);
		}

	}

	public boolean temVagaDisponivel(Estabelecimento estabelecimento, Veiculo veiculo) {
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

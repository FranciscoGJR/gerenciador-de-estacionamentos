package com.gerenciador.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gerenciador.enumerator.TipoVeiculo;
import com.gerenciador.model.EntradaSaidaVeiculo;
import com.gerenciador.model.Estabelecimento;
import com.gerenciador.model.Estacionamento;
import com.gerenciador.model.Veiculo;
import com.gerenciador.repository.EstabelecimentoRepository;
import com.gerenciador.repository.EstacionamentoRepository;
import com.gerenciador.repository.VeiculoRepository;
import com.gerenciador.service.EntradaSaidaVeiculoService;

@Component
public class DataInitializer implements CommandLineRunner {

	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;

	@Autowired
	private EstacionamentoRepository estacionamentoRepository;

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private EntradaSaidaVeiculoService entradaSaidaVeiculoService;

	private Estabelecimento estabelecimento1 = new Estabelecimento(1, "Nome 0", "CNPJ 0", "Endereco 0", "Telefone 0");
	private Estabelecimento estabelecimento2 = new Estabelecimento(2, "Nome 1", "CNPJ 1", "Endereco 1", "Telefone 1");

	private Estacionamento estacionamento1 = new Estacionamento(1, 10, 30, 40, 0, estabelecimento1);
	private Estacionamento estacionamento2 = new Estacionamento(2, 5, 25, 30, 0, estabelecimento1);
	private Estacionamento estacionamento3 = new Estacionamento(3, 5, 25, 30, 0, estabelecimento2);

	private Veiculo veiculo1 = new Veiculo(1, "Marca 1", "Cor 1", "Placa 1", TipoVeiculo.CARRO);
	private Veiculo veiculo2 = new Veiculo(2, "Marca 2", "Cor 2", "Placa 2", TipoVeiculo.CARRO);
	private Veiculo veiculo3 = new Veiculo(3, "Marca 3", "Cor 3", "Placa 3", TipoVeiculo.MOTO);
	private Veiculo veiculo4 = new Veiculo(4, "Marca 4", "Cor 4", "Placa 4", TipoVeiculo.MOTO);

	private List<Estacionamento> listaEstacionamentos1 = new ArrayList<>();
	private List<Estacionamento> listaEstacionamentos2 = new ArrayList<>();

	private EntradaSaidaVeiculo entradaSaidaVeiculo1 = new EntradaSaidaVeiculo();

	@Override
	public void run(String... args) throws Exception {

		estabelecimentoRepository.saveAll(Arrays.asList(estabelecimento1, estabelecimento2));
		estacionamentoRepository.saveAll(Arrays.asList(estacionamento1, estacionamento2, estacionamento3));
		veiculoRepository.saveAll(Arrays.asList(veiculo1, veiculo2, veiculo3, veiculo4));

		listaEstacionamentos1 = Arrays.asList(estacionamento1, estacionamento2);
		listaEstacionamentos2 = Arrays.asList(estacionamento3);

		estabelecimento1.setEstacionamentos(listaEstacionamentos1);
		estabelecimento2.setEstacionamentos(listaEstacionamentos2);

		estacionamento1.setEstabelecimentos(estabelecimento1);
		estacionamento2.setEstabelecimentos(estabelecimento1);
		estacionamento3.setEstabelecimentos(estabelecimento2);

		estabelecimentoRepository.saveAll(Arrays.asList(estabelecimento1, estabelecimento2));
		estacionamentoRepository.saveAll(Arrays.asList(estacionamento1, estacionamento2, estacionamento3));
		veiculoRepository.saveAll(Arrays.asList(veiculo1, veiculo2, veiculo3, veiculo4));

		Integer idEstacionamento1 = estacionamento1.getIdEstacionamento();
		Integer idVeiculo1 = veiculo1.getIdVeiculo();
		entradaSaidaVeiculo1 = entradaSaidaVeiculoService.registrarEntradaDeVeiculo(idEstacionamento1, idVeiculo1);
	}

	public EntradaSaidaVeiculo getEntradaSaidaVeiculo() {
		return entradaSaidaVeiculo1;
	}

	public void setEntradaSaidaVeiculo(EntradaSaidaVeiculo entradaSaidaVeiculo1) {
		this.entradaSaidaVeiculo1 = entradaSaidaVeiculo1;
	}

}

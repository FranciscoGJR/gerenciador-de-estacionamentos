package com.gerenciador.config;

import java.util.ArrayList;
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

	@Override
	public void run(String... args) throws Exception {
		Estabelecimento estabelecimento1 = new Estabelecimento(1, "Nome 0", "CNPJ 0", "Endereco 0", "Telefone 0");
		Estabelecimento estabelecimento2 = new Estabelecimento(2, "Nome 1", "CNPJ 1", "Endereco 1", "Telefone 1");

		Estacionamento estacionamento1 = new Estacionamento(1, 10, 30, 40, 0, estabelecimento1);
		Estacionamento estacionamento2 = new Estacionamento(2, 5, 25, 30, 0, estabelecimento1);
		Estacionamento estacionamento3 = new Estacionamento(3, 5, 25, 30, 0, estabelecimento2);

		Veiculo veiculo1 = new Veiculo(1, "Marca 1", "Cor 1", "Placa 1", TipoVeiculo.CARRO);
		Veiculo veiculo2 = new Veiculo(2, "Marca 2", "Cor 2", "Placa 2", TipoVeiculo.CARRO);
		Veiculo veiculo3 = new Veiculo(3, "Marca 3", "Cor 3", "Placa 3", TipoVeiculo.MOTO);
		Veiculo veiculo4 = new Veiculo(4, "Marca 4", "Cor 4", "Placa 4", TipoVeiculo.MOTO);

		estabelecimentoRepository.save(estabelecimento1);
		estabelecimentoRepository.save(estabelecimento2);

		estacionamentoRepository.save(estacionamento1);
		estacionamentoRepository.save(estacionamento2);
		estacionamentoRepository.save(estacionamento3);

		veiculoRepository.save(veiculo1);
		veiculoRepository.save(veiculo2);
		veiculoRepository.save(veiculo3);
		veiculoRepository.save(veiculo4);

		List<Estacionamento> listaEstacionamentos1 = new ArrayList<>();
		List<Estacionamento> listaEstacionamentos2 = new ArrayList<>();
		listaEstacionamentos1.add(estacionamento1);
		listaEstacionamentos1.add(estacionamento2);
		listaEstacionamentos2.add(estacionamento3);
		estabelecimento1.setEstacionamentos(listaEstacionamentos1);
		estabelecimento2.setEstacionamentos(listaEstacionamentos2);

		estacionamento1.setEstabelecimentos(estabelecimento1);
		estacionamento2.setEstabelecimentos(estabelecimento1);
		estacionamento3.setEstabelecimentos(estabelecimento2);

		estabelecimentoRepository.save(estabelecimento1);
		estabelecimentoRepository.save(estabelecimento2);

		estacionamentoRepository.save(estacionamento1);
		estacionamentoRepository.save(estacionamento2);
		estacionamentoRepository.save(estacionamento3);

		veiculoRepository.save(veiculo1);
		veiculoRepository.save(veiculo2);
		veiculoRepository.save(veiculo3);
		veiculoRepository.save(veiculo4);
		
		EntradaSaidaVeiculo entradaSaidaVeiculo1 = entradaSaidaVeiculoService.registrarEntradaDeVeiculo(estacionamento1.getIdEstacionamento(), veiculo1.getIdVeiculo()); 
	}

}

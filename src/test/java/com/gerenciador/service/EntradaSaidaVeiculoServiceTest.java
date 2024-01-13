package com.gerenciador.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gerenciador.enumerator.TipoVeiculo;
import com.gerenciador.model.EntradaSaidaVeiculo;
import com.gerenciador.model.Estabelecimento;
import com.gerenciador.model.Estacionamento;
import com.gerenciador.model.Veiculo;
import com.gerenciador.repository.EntradaSaidaVeiculoRepository;

@ExtendWith(MockitoExtension.class)
public class EntradaSaidaVeiculoServiceTest {

	@InjectMocks
	private EntradaSaidaVeiculoService entradaSaidaVeiculoService;
	
	@Mock
	private EntradaSaidaVeiculoRepository entradaSaidaVeiculoRepository;

	@Mock
	private VeiculoService veiculoService;
	
	@Mock
	private EstacionamentoService estacionamentoService;
	
	private Estacionamento estacionamento1;
	private Estabelecimento estabelecimento1;
	private Veiculo veiculo1;
	private EntradaSaidaVeiculo entradaSaidaVeiculo;
	
	@BeforeEach
	public void setUp() {
		estabelecimento1 = new Estabelecimento(1, "OORIGEM: TESTE", "CNPJ 0", "Endereco 0", "Telefone 0");
		estacionamento1 = new Estacionamento(1, 10, 30, estabelecimento1);
		veiculo1 = new Veiculo(1, "Marca 1", "Cor 1", "Placa 1", TipoVeiculo.CARRO);
		entradaSaidaVeiculo = new EntradaSaidaVeiculo(veiculo1, estacionamento1);
	}
	
	@Test
	public void testRegistrarEntradaDeVeiculo() throws Exception{
		Integer idEstacionamento = estacionamento1.getIdEstacionamento();
		Integer idVeiculo = veiculo1.getIdVeiculo();
		
		when(estacionamentoService.findById(idEstacionamento )).thenReturn(estacionamento1);
		when(estacionamentoService.quantidadeVagasDisponiveis(idEstacionamento, veiculo1.getTipoVeiculo())).thenReturn(10);
		when(veiculoService.findById(idVeiculo)).thenReturn(veiculo1);
		when(entradaSaidaVeiculoRepository.veiculoJaEstacionado(idVeiculo, idEstacionamento)).thenReturn(null);
		when(entradaSaidaVeiculoRepository.save(any())).thenReturn(entradaSaidaVeiculo);
		
		entradaSaidaVeiculo = entradaSaidaVeiculoService.registrarEntradaDeVeiculo(estacionamento1.getIdEstacionamento(), veiculo1.getIdVeiculo());

		assertTrue(entradaSaidaVeiculo.getEstacionamento() == estacionamento1);
		assertTrue(entradaSaidaVeiculo.getVeiculo() == veiculo1);
	}
}
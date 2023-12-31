package comgerenciador.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gerenciador.model.Estabelecimento;
import com.gerenciador.model.Veiculo;
import com.gerenciador.repository.EstabelecimentoRepository;
import com.gerenciador.repository.VeiculoRepository;
import com.gerenciador.service.EstabelecimentoService;
import com.gerenciador.service.VeiculoService;

@ExtendWith(MockitoExtension.class)
public class EstabelecimentoServiceTest {

	@InjectMocks
	EstabelecimentoService estabelecimentoService;

	@Mock
	VeiculoService veiculoService;

	@Mock
	EstabelecimentoRepository estabelecimentoRepository;

	@Mock
	VeiculoRepository veiculoRepository;

	Estabelecimento estabelecimento;

	Optional<Estabelecimento> optionalEstabelecimento;

	Veiculo veiculo;

	Optional<Veiculo> optionalVeiculo;

//	@BeforeEach
//	public void setUp() {
//		estabelecimento = new Estabelecimento(1, "Nome", "cnpj", "Endereco", "Telefone", 10, 20);
//		optionalEstabelecimento = Optional.ofNullable(estabelecimento);
//		veiculo = new Veiculo(1, "Marca", "Cor", "Placa", "CARRO", null);
//		optionalVeiculo = Optional.ofNullable(veiculo);
//	}
//
//	@Test
//	public void testRegistrarEntradaDeVeiculo() throws Exception {
//
//		when(estabelecimentoRepository.findById(estabelecimento.getIdentificador())).thenReturn(optionalEstabelecimento);
//		when(veiculoRepository.findById(veiculo.getIdentificador())).thenReturn(optionalVeiculo);
//		
//		Veiculo veiculoAdicionado = estabelecimentoService.registrarEntradaDeVeiculo(estabelecimento.getIdentificador(),
//				veiculo.getIdentificador());
//
//		assertTrue(veiculoAdicionado.getEstabelecimentoAtual() == estabelecimento);
//	}

}

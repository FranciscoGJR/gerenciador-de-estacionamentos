package comgerenciador.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gerenciador.model.Estabelecimento;
import com.gerenciador.model.Veiculo;
import com.gerenciador.repository.EstabelecimentoRepository;
import com.gerenciador.service.EstabelecimentoService;

@ExtendWith(MockitoExtension.class)
public class EstabelecimentoServiceTest {

	@InjectMocks
	EstabelecimentoService estabelecimentoService;

	@Mock
	private EstabelecimentoRepository estabelecimentoRepository;

	@Test
	@DisplayName("Deve testar temVagaDisponivel em um cenario com vagas disponiveis para carros")
	void testeTemVagaDisponivelCarrosComVagasDisponiveis() {
		Estabelecimento mockEstabelecimento = mock(Estabelecimento.class);
		Veiculo mockCarro = mock(Veiculo.class);

		when(mockCarro.getTipo()).thenReturn("CARRO");
		when(mockEstabelecimento.getCarrosEstacionados()).thenReturn(new ArrayList<>());
		when(mockEstabelecimento.getQuantidadeVagasCarros()).thenReturn(5);

		assertTrue(estabelecimentoService.temVagaDisponivel(mockEstabelecimento, mockCarro));
	}

	@Test
	@DisplayName("Deve testar temVagaDisponivel em um cenario sem vagas disponiveis para carros")
	public void testeTemVagaDisponivelCarrosSemVagasDisponiveis() {
		Estabelecimento mockEstabelecimento = mock(Estabelecimento.class);
		Veiculo mockCarro = mock(Veiculo.class);

		when(mockCarro.getTipo()).thenReturn("CARRO");
		when(mockEstabelecimento.getCarrosEstacionados()).thenReturn(Arrays.asList(new Veiculo(), new Veiculo()));
		when(mockEstabelecimento.getQuantidadeVagasCarros()).thenReturn(2);

		assertFalse(estabelecimentoService.temVagaDisponivel(mockEstabelecimento, mockCarro));
	}

	@Test
	@DisplayName("Deve testar temVagaDisponivel em um cenario com vagas disponiveis para motos")
	public void testTemVagaDisponivelMotosComVagasDisponiveis() {
		Estabelecimento mockEstabelecimento = mock(Estabelecimento.class);
		Veiculo mockMoto = mock(Veiculo.class);

		when(mockMoto.getTipo()).thenReturn("MOTO");
		when(mockEstabelecimento.getMotosEstacionadas()).thenReturn(new ArrayList<>());
		when(mockEstabelecimento.getQuantidadeVagasMotos()).thenReturn(3);

		assertTrue(estabelecimentoService.temVagaDisponivel(mockEstabelecimento, mockMoto));
	}
	
	@Test
	@DisplayName("Deve testar temVagaDisponivel em um cenario sem vagas disponiveis para motos")
	public void testTemVagaDisponivelMotosSemVagasDisponiveis() {
	    Estabelecimento mockEstabelecimento = mock(Estabelecimento.class);
	    Veiculo mockMoto = mock(Veiculo.class);

	    when(mockMoto.getTipo()).thenReturn("MOTO");
	    when(mockEstabelecimento.getMotosEstacionadas()).thenReturn(Arrays.asList(new Veiculo()));
	    when(mockEstabelecimento.getQuantidadeVagasMotos()).thenReturn(1);

	    assertFalse(estabelecimentoService.temVagaDisponivel(mockEstabelecimento, mockMoto));
	}


}

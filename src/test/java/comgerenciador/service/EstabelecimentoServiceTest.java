package comgerenciador.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gerenciador.model.Estabelecimento;
import com.gerenciador.repository.EstabelecimentoRepository;
import com.gerenciador.service.EstabelecimentoSerevice;

@ExtendWith(MockitoExtension.class)
public class EstabelecimentoServiceTest {
	
	@Mock
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@InjectMocks
	EstabelecimentoSerevice estabelecimentoService;
	
	@Test
	@DisplayName("Salvar quando ja existir um estabelecimento com esse cnpj")
	void salvarQuandoJaExisteUmEstabelecimentoCadastrado() {
		
		Estabelecimento estabelecimento = new Estabelecimento(1, "Loja A", "111", "Av. Brasil", "111", 20, 100);
		
		Mockito.when(estabelecimentoRepository.existsById(estabelecimento.getIdentificador())).thenReturn(true);
		
	}

}

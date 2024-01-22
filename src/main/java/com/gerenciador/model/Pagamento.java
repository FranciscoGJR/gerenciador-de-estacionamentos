package com.gerenciador.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAGAMENTO")
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PAGAMENTO")
	private Integer idPagamento;
	
	@Column(name = "MOMENTO_PAGAMENTO")
	private LocalDate momentoPagamento = null;
	
	@Column(name = "VALOR")
	private BigDecimal valor;
	
	@OneToOne(mappedBy = "pagamento")
	private EntradaSaidaVeiculo entradaSaidaVeiculo;

}

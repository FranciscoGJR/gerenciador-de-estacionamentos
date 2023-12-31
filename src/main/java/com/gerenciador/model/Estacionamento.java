package com.gerenciador.model;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ESTACIONAMENTO")
public class Estacionamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ESTACIONAMENTO")
	@NotNull
	private Integer idEstacionamento;

	@Column(name = "QUANTIDADE_VAGAS_MOTOS", nullable = false)
	@NotNull
	Integer quantidadeVagasMotos;

	@Column(name = "QUANTIDADE_VAGAS_CARROS", nullable = false)
	@NotNull
	Integer quantidadeVagasCarros;

	@Column(name = "QUANT_TOTAL_VAGAS", nullable = false)
	@NotNull
	private Integer quantTotalVagas;

	@Column(name = "QUANT_VAGAS_OCUPADAS")
	private Integer quantVagasOcupadas;

	@ManyToOne()
	@JoinColumn(name = "ID_ESTABELECIMENTO", nullable = false)
	private Estabelecimento estabelecimentos;

	public Estacionamento() {
	}

	public Estacionamento(@NotNull Integer idEstacionamento, @NotNull Integer quantidadeVagasMotos,
			@NotNull Integer quantidadeVagasCarros, @NotNull Integer quantTotalVagas, Integer quantVagasOcupadas,
			Estabelecimento estabelecimentos) {
		super();
		this.idEstacionamento = idEstacionamento;
		this.quantidadeVagasMotos = quantidadeVagasMotos;
		this.quantidadeVagasCarros = quantidadeVagasCarros;
		this.quantTotalVagas = quantTotalVagas;
		this.quantVagasOcupadas = quantVagasOcupadas;
		this.estabelecimentos = estabelecimentos;
	}

	public Integer getIdEstacionamento() {
		return idEstacionamento;
	}

	public void setIdEstacionamento(Integer idEstacionamento) {
		this.idEstacionamento = idEstacionamento;
	}

	public Integer getQuantidadeVagasMotos() {
		return quantidadeVagasMotos;
	}

	public void setQuantidadeVagasMotos(Integer quantidadeVagasMotos) {
		this.quantidadeVagasMotos = quantidadeVagasMotos;
	}

	public Integer getQuantidadeVagasCarros() {
		return quantidadeVagasCarros;
	}

	public void setQuantidadeVagasCarros(Integer quantidadeVagasCarros) {
		this.quantidadeVagasCarros = quantidadeVagasCarros;
	}

	public Integer getQuantTotalVagas() {
		return quantTotalVagas;
	}

	public void setQuantTotalVagas(Integer quantTotalVagas) {
		this.quantTotalVagas = quantTotalVagas;
	}

	public Integer getQuantVagasOcupadas() {
		return quantVagasOcupadas;
	}

	public void setQuantVagasOcupadas(Integer quantVagasOcupadas) {
		this.quantVagasOcupadas = quantVagasOcupadas;
	}

	public Estabelecimento getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(Estabelecimento estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}

}

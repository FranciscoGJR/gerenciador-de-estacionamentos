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

	@Column(name = "QUANT_TOTAL_VAGAS_MOTOS", nullable = false)
	@NotNull
	private Integer quantTotalVagasMotos;

	@Column(name = "QUANT_TOTAL_VAGAS_CARROS", nullable = false)
	@NotNull
	private Integer quantTotalVagasCarros;
	
	@Column(name = "QUANT_VAGAS_MOTOS_OCUPADAS", nullable = false)
	@NotNull
	private Integer quantVagasMotosOcupadas = 0;
	
	@Column(name = "QUANT_VAGAS_CARROS_OCUPADAS", nullable = false)
	@NotNull
	private Integer quantVagasCarrosOcupadas = 0;

	@ManyToOne()
	@JoinColumn(name = "ID_ESTABELECIMENTO", nullable = false)
	private Estabelecimento estabelecimentos;

	public Estacionamento() {
	}
	
	public Estacionamento(@NotNull Integer idEstacionamento, @NotNull Integer quantTotalVagasMotos,
			@NotNull Integer quantTotalVagasCarros, Estabelecimento estabelecimentos) {
		super();
		this.idEstacionamento = idEstacionamento;
		this.quantTotalVagasMotos = quantTotalVagasMotos;
		this.quantTotalVagasCarros = quantTotalVagasCarros;
		this.estabelecimentos = estabelecimentos;
	}

	public Integer getQuantTotalVagasMotos() {
		return quantTotalVagasMotos;
	}

	public void setQuantTotalVagasMotos(Integer quantTotalVagasMotos) {
		this.quantTotalVagasMotos = quantTotalVagasMotos;
	}

	public Integer getQuantTotalVagasCarros() {
		return quantTotalVagasCarros;
	}

	public void setQuantTotalVagasCarros(Integer quantTotalVagasCarros) {
		this.quantTotalVagasCarros = quantTotalVagasCarros;
	}

	public Integer getQuantVagasMotosOcupadas() {
		return quantVagasMotosOcupadas;
	}

	public void setQuantVagasMotosOcupadas(Integer quantVagasMotosOcupadas) {
		this.quantVagasMotosOcupadas = quantVagasMotosOcupadas;
	}

	public Integer getQuantVagasCarrosOcupadas() {
		return quantVagasCarrosOcupadas;
	}

	public void setQuantVagasCarrosOcupadas(Integer quantVagasCarrosOcupadas) {
		this.quantVagasCarrosOcupadas = quantVagasCarrosOcupadas;
	}

	public Integer getIdEstacionamento() {
		return idEstacionamento;
	}

	public void setIdEstacionamento(Integer idEstacionamento) {
		this.idEstacionamento = idEstacionamento;
	}

	public Estabelecimento getEstabelecimentos() {
		return estabelecimentos;
	}

	public void setEstabelecimentos(Estabelecimento estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}

}

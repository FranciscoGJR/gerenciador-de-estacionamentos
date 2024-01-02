package com.gerenciador.model;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENTRADA_SAIDA_VEICULO")
public class  EntradaSaidaVeiculo{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ENTRADA_SAIDA_VEICULO")
	@NotNull
	private Integer idEntradaSaidaVeiculo;

	@Column(name = "MOMENTO_ENTRADA", nullable = false)
	@NotNull
	private LocalDate momentoEntrada = LocalDate.now();

	@Column(name = "MOMENTO_SAIDA")
	private LocalDate momentoSaida = LocalDate.MIN;

	@OneToOne()
	@JoinColumn(name = "ID_VEICULO")
	private Veiculo veiculo;

	@OneToOne()
	@JoinColumn(name = "ID_ESTACIONAMENTO")
	private Estacionamento estacionamento;

	public EntradaSaidaVeiculo() {
	}

	public EntradaSaidaVeiculo(@NotNull Integer idEntradaSaidaVeiculo, @NotNull LocalDate momentoEntrada,
			Veiculo veiculo, Estacionamento estacionamento) {
		this.idEntradaSaidaVeiculo = idEntradaSaidaVeiculo;
		this.momentoEntrada = momentoEntrada;
		this.veiculo = veiculo;
		this.estacionamento = estacionamento;
	}
	
	public EntradaSaidaVeiculo( Veiculo veiculo, Estacionamento estacionamento) {
		this.veiculo = veiculo;
		this.estacionamento = estacionamento;
	}

	public Integer getIdEntradaSaidaVeiculo() {
		return idEntradaSaidaVeiculo;
	}

	public void setIdEntradaSaidaVeiculo(Integer idEntradaSaidaVeiculo) {
		this.idEntradaSaidaVeiculo = idEntradaSaidaVeiculo;
	}

	public LocalDate getMomentoEntrada() {
		return momentoEntrada;
	}

	public void setMomentoEntrada(LocalDate momentoEntrada) {
		this.momentoEntrada = momentoEntrada;
	}

	public LocalDate getMomentoSaida() {
		return momentoSaida;
	}

	public void setMomentoSaida(LocalDate momentoSaida) {
		this.momentoSaida = momentoSaida;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Estacionamento getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}

}

package com.gerenciador.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.gerenciador.enumerator.TipoVeiculo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "VEICULO")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_VEICULO")
	@NotNull
	private Integer idVeiculo;

	@Column(name = "MARCA_DO_VEICULO", length = 32, nullable = false)
	@NotNull
	private String marca;

	@Column(name = "COR_DO_VEICULO", length = 16, nullable = false)
	@NotNull
	private String cor;

	@Column(name = "PLACA_DO_VEICULO", length = 16, nullable = false)
	@NotNull
	private String placa;

	@Column(name = "TIPO_DO_VEICULO", nullable = false)
	@NotNull
	private TipoVeiculo tipoVeiculo;

	@ManyToMany
	@JoinTable(name = "ESTACIONAMENTO_VEICULO", joinColumns = {
			@JoinColumn(name = "ID_VEICULO") }, inverseJoinColumns = {
					@JoinColumn(name = "ID_ESTACIONAMENTO") })
	private List<Estacionamento> estacionamentosDoVeiculo;

	public Veiculo() {
	}

	public Integer getVeiculoIdentificador() {
		return idVeiculo;
	}

	public void setVeiculoIdentificador(Integer veiculoIdentificador) {
		this.idVeiculo = veiculoIdentificador;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public TipoVeiculo getTipo() {
		return tipoVeiculo;
	}

	public void setTipo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

}

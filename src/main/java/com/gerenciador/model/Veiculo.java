package com.gerenciador.model;

import javax.validation.constraints.NotNull;

import com.gerenciador.enumerator.TipoVeiculo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	public Veiculo() {
	}

	public Veiculo(@NotNull Integer idVeiculo, @NotNull String marca, @NotNull String cor, @NotNull String placa,
			@NotNull TipoVeiculo tipoVeiculo) {
		this.idVeiculo = idVeiculo;
		this.marca = marca;
		this.cor = cor;
		this.placa = placa;
		this.tipoVeiculo = tipoVeiculo;
	}

	public Integer getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
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

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	
	
}

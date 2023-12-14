package com.gerenciador.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Veiculo")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "veiculo_identificador")
	@NotNull
	Integer veiculoIdentificador;

	@Column(name = "marca_do_veiculo", length = 32, nullable = false)
	@NotNull
	String marca;

	@Column(name = "cor_do_veiculo", length = 16, nullable = false)
	@NotNull
	String cor;

	@Column(name = "placa_do_veiculo", length = 16, nullable = false)
	@NotNull
	String placa;

	@Column(name = "tipo_do_veiculo", nullable = false)
	@NotNull
	String tipo;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "estabelecimentoIdentificador")
	private Estabelecimento estabelecimentoAtual;
	
	public Veiculo() {
	}

	public Veiculo(String marca, String cor, String placa, String tipo) {
		this.marca = marca;
		this.cor = cor;
		this.placa = placa;
		this.tipo = tipo;
	}

	public Integer getIdentificador() {
		return veiculoIdentificador;
	}

	public void setIdentificador(Integer identificador) {
		this.veiculoIdentificador = identificador;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Estabelecimento getEstabelecimentoAtual() {
		return estabelecimentoAtual;
	}

	public void setEstabelecimentoAtual(Estabelecimento estabelecimentoAtual) {
		this.estabelecimentoAtual = estabelecimentoAtual;
	}

}

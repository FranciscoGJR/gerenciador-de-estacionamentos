package com.gerenciador.model;

import java.util.List;

import javax.validation.constraints.NotNull;

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
@Table(name = "Veiculo")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VEICULO_IDENTIFICADOR")
	@NotNull
	private Integer veiculoIdentificador;

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
	private String tipo;

	@ManyToMany
	@JoinTable(
			name = "ESTABELECIMENTO_VEICULO",
			joinColumns = { @JoinColumn( name = "VEICULO_IDENTIFICADOR")},
			inverseJoinColumns = {@JoinColumn( name = "ESTABELECIMENTO_IDENTIFICADOR")})
	private List<Estabelecimento> estacionamentos;


}
		

package com.gerenciador.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Estabelecimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ESTABELECIMENTO_IDENTIFICADOR")
	@NotNull
	Integer estabelecimentoIdentificador;

	@Column(name = "NOME", length = 32, nullable = false)
	@NotNull
	String nome;

	@Column(name = "CNPJ", length = 16, nullable = false)
	@NotNull
	String cnpj;

	@Column(name = "ENDERECO", length = 32, nullable = false)
	@NotNull
	String endereco;

	@Column(name = "TELEFONE", length = 16, nullable = false)
	@NotNull
	String telefone;

	@Column(name = "QUANTIDADE_VAGAS_MOTOS", nullable = false)
	@NotNull
	Integer quantidadeVagasMotos;

	@Column(name = "QUANTIDADE_VAGAS_MOTOS", nullable = false)
	@NotNull
	Integer quantidadeVagasCarros;
	
	@ManyToMany(mappedBy = "estacionamentos")
	private List<Veiculo> veiculosEstacionados;


}

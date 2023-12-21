package com.gerenciador.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Estabelecimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "estabelecimento_identificador")
	@NotNull
	Integer estabelecimentoIdentificador;

	@Column(name = "nome", length = 32, nullable = false)
	@NotNull
	String nome;

	@Column(name = "cnpj", length = 16, nullable = false)
	@NotNull
	String cnpj;

	@Column(name = "endereco", length = 32, nullable = false)
	@NotNull
	String endereco;

	@Column(name = "telefone", length = 16, nullable = false)
	@NotNull
	String telefone;

	@Column(name = "quantidade_vagas_motos", nullable = false)
	@NotNull
	Integer quantidadeVagasMotos;

	@Column(name = "quantidade_vagas_carros", nullable = false)
	@NotNull
	Integer quantidadeVagasCarros;

	@JsonManagedReference
	@OneToMany(mappedBy = "estabelecimentoAtual")
	public List<Veiculo> carrosEstacionados;

	@JsonManagedReference
	@OneToMany(mappedBy = "estabelecimentoAtual")
	public List<Veiculo> motosEstacionadas;

	public Estabelecimento() {

	}

	public Estabelecimento(@NotNull Integer estabelecimentoIdentificador, @NotNull String nome, @NotNull String cnpj,
			@NotNull String endereco, @NotNull String telefone, @NotNull Integer quantidadeVagasMotos,
			@NotNull Integer quantidadeVagasCarros) {
		super();
		this.estabelecimentoIdentificador = estabelecimentoIdentificador;
		this.nome = nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.telefone = telefone;
		this.quantidadeVagasMotos = quantidadeVagasMotos;
		this.quantidadeVagasCarros = quantidadeVagasCarros;
		this.carrosEstacionados = new ArrayList<>();
		this.motosEstacionadas = new ArrayList<>();
	}

	public boolean adicionarCarroEstacionado(Veiculo novoVeiculo) {
		return carrosEstacionados.add(novoVeiculo);
	}

	public boolean adicionarMotoEstacionada(Veiculo novoVeiculo) {
		return motosEstacionadas.add(novoVeiculo);
	}

	public Integer getIdentificador() {
		return estabelecimentoIdentificador;
	}

	public void setIdentificador(Integer identificador) {
		this.estabelecimentoIdentificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getQuantidadeVagasCarros() {
		return quantidadeVagasCarros;
	}

	public void setQuantidadeVagasCarros(Integer quantidadeVagasCarros) {
		this.quantidadeVagasCarros = quantidadeVagasCarros;
	}

	public List<Veiculo> getCarrosEstacionados() {
		return carrosEstacionados;
	}

	public void setCarrosEstacionados(List<Veiculo> carrosEstacionados) {
		this.carrosEstacionados = carrosEstacionados;
	}

	public List<Veiculo> getMotosEstacionadas() {
		return motosEstacionadas;
	}

	public void setMotosEstacionadas(List<Veiculo> motosEstacionadas) {
		this.motosEstacionadas = motosEstacionadas;
	}

	public Integer getQuantidadeVagasMotos() {
		return quantidadeVagasMotos;
	}

}

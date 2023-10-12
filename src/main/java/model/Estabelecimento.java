package model;

public class Estabelecimento {
	
	String nome;
	
	String endereco;
	
	Integer quantidadeVagasMotos;
	
	Integer quantidadeVagasCarros;

	public Estabelecimento(String nome, String endereco, Integer quantidadeVagasMotos, Integer quantidadeVagasCarros) {
		this.nome = nome;
		this.endereco = endereco;
		this.quantidadeVagasMotos = quantidadeVagasMotos;
		this.quantidadeVagasCarros = quantidadeVagasCarros;
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
	
}

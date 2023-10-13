package model;

public class Veiculo {

	Integer identificador;

	String marca;

	String Cor;

	String placa;

	TipoVeiculo tipo;

	public Veiculo(String marca, String cor, String placa, TipoVeiculo tipo) {
		this.marca = marca;
		Cor = cor;
		this.placa = placa;
		this.tipo = tipo;
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return Cor;
	}

	public void setCor(String cor) {
		Cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public TipoVeiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}

}

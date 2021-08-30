package br.com.logusinfo.carsimulator.model;

import br.com.logusinfo.carsimulator.enums.Combustivel;

public class Bomba {
	
	private Combustivel combustivel;
	private int totalAbastecido;
	private int velocidadeBomba;
	private int totalVeiculos;
	private boolean abastecendo;
	private Veiculo veiculo;
	private int tempoAbastecimento;
	private int totalTempoAbastecimento;
	
	public Bomba(Combustivel combustivel, int velocidade) {
		this.combustivel = combustivel;
		this.velocidadeBomba = velocidade;
		this.abastecendo = false;
		this.veiculo = null;
		this.tempoAbastecimento = 0;
		this.totalAbastecido = 0;
		this.totalVeiculos = 0;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}
	
	public int getVelocidade() {
		return velocidadeBomba;
	}
	
	public String abasteceCarro(Veiculo veiculo) {
		this.abastecendo = true;
		setVeiculo(veiculo);
		int capacidade = this.veiculo.getModelo().getCapacidadeTanque();
		tempoAbastecimento += capacidade/velocidadeBomba;
		totalTempoAbastecimento += tempoAbastecimento;
		totalAbastecido += capacidade;
		totalVeiculos++;
		return 	 " Veículo modelo " 
				+ veiculo.getModelo().getModelo() 
				+ ", placa "
				+ veiculo.getPlaca()
				+ " foi abastecido com "
				+ capacidade 
				+ " litros de "
				+ this.combustivel;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public void terminaAbastecimento() {
		this.veiculo = null;
		this.abastecendo = false;
	}
	
	public int getTempoAbastecimento() {
		return tempoAbastecimento;
	}
	
	public boolean isAbastecendo() {
		return abastecendo;
	}
	
	public int getTotalAbastecido() {
		return this.totalAbastecido;
	}

	@Override
	public String toString() {
		return "Bomba [combustivel=" + combustivel + "]";
	}

	public int getTotalVeiculos() {
		return this.totalVeiculos;
	}

	public int getTotalTempoAbastecimento() {
		return this.totalTempoAbastecimento;
	}
}

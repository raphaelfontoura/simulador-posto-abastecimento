package br.com.logusinfo.carsimulator.service;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import br.com.logusinfo.carsimulator.enums.Combustivel;
import br.com.logusinfo.carsimulator.model.Bomba;
import br.com.logusinfo.carsimulator.model.Veiculo;

public class PostoCombustivel {

	private Queue<Veiculo> veiculos;
	private Bomba[] bombas;
	private int size;
	private int totalSeconds = 0;

	public PostoCombustivel(List<Veiculo> veiculos, Bomba... bombas) {
		this.veiculos = new ArrayDeque<>(veiculos);
		this.size = veiculos.size();
		this.bombas = bombas;
		
	}

	public void gerenciaFilaVeiculos() {
		for (int i = 0; i < size; i++) {
			abasteceVeiculo();
		}

	}
	
	public void finalizarAtendimento() {
		System.out.println("Resumo da Simulação");
		System.out.println("=======");

		for (Bomba bomba : bombas) {
			System.out.printf("Total abastecido na bomba (%s): %d litros \n", bomba.getCombustivel(), bomba.getTotalAbastecido());
			System.out.println("\tTotal de veículos: " + bomba.getTotalVeiculos());
			System.out.println("\tTotal de tempo: " + bomba.getTotalTempoAbastecimento());

			System.out.println();
		}
		System.out.println("Tempo total de funcionamento (segundos): " + this.totalSeconds);
	}



	private void abasteceVeiculo() {
		for (Bomba bomba:
			 bombas) {
			if (! bomba.isAbastecendo()) {
				Veiculo veiculo = proximoVeiculo(bomba.getCombustivel());
				if (veiculo != null){
					String relatorioBomba = bomba.abasteceCarro(veiculo);
					if (this.totalSeconds < bomba.getTotalTempoAbastecimento()) {
						this.totalSeconds = bomba.getTotalTempoAbastecimento();
					}
					System.out.println("["+segundosEmFormatoHora(totalSeconds)+"]"+relatorioBomba);

					size --;
					break;
				}
			} else {
				bomba.terminaAbastecimento();
			}
		}
	}

	private Veiculo proximoVeiculo(Combustivel combustivel) {
		Veiculo veiculo = veiculos.peek();
		assert veiculo != null;
		if (veiculo.getModelo().aceitaCombustivel(combustivel)) return veiculos.poll();
		return null;
	}
	
	public int getSize() {
		return size;
	}

	private String segundosEmFormatoHora(int total) {
		int minutos = total / 60;
		int segundos = total % 60;
		return String.format("%02d:%02d",minutos,segundos);
	}

}

package br.com.logusinfo.carsimulator.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.logusinfo.carsimulator.model.ModeloVeiculo;
import br.com.logusinfo.carsimulator.util.ReadCSVFile;

public class ModeloVeiculoCSVRepository {
	
	private static final List<ModeloVeiculo> modelos = new ArrayList<>();
	
	public ModeloVeiculoCSVRepository() {
		String[] dados = ReadCSVFile.getValues("modelos.csv");
		
		Double etanol = dados[1].isEmpty() ? null : convert(dados[1]);
		Double gasolina = dados[2].isEmpty() ? null : convert(dados[2]);

		ModeloVeiculo modelo = new ModeloVeiculo(
				dados[0], 
				etanol, 
				gasolina, 
				Integer.parseInt(dados[3]));
		modelos.add(modelo);
	}
	
	public List<ModeloVeiculo> getModelos(){
		return modelos;
	}
	
	public ModeloVeiculo findModelo(String modelo) {
		return modelos.stream()
				.filter(m -> m.getModelo().equals(modelo))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Modelo não econtrado"));
	}
	
	private double convert(String input) {
	    input = input.replace(',', '.');
	    return Double.valueOf(input);
	}


}

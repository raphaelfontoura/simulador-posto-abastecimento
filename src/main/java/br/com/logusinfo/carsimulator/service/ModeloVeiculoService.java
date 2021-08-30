package br.com.logusinfo.carsimulator.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.management.InstanceNotFoundException;

import br.com.logusinfo.carsimulator.model.ModeloVeiculo;

public class ModeloVeiculoService {
	
	List<ModeloVeiculo> modelosVeiculos =  new ArrayList<ModeloVeiculo>();
	
	public ModeloVeiculoService() throws FileNotFoundException {
		try (Scanner scanner = new Scanner(new File("resources","modelos.csv"))){
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String[] values = scanner.nextLine().split(";");
				Double etanol = values[1].isEmpty() ? null : convert(values[1]);
				Double gasolina = values[2].isEmpty() ? null : convert(values[2]);

				ModeloVeiculo modelo = new ModeloVeiculo(
						values[0], 
						etanol, 
						gasolina, 
						Integer.parseInt(values[3]));
				modelosVeiculos.add(modelo);
			}
		}
	}
	
	public ModeloVeiculo findModelo (String modelo) throws FileNotFoundException, InstanceNotFoundException {
		
		ModeloVeiculo result = modelosVeiculos.stream()
				.filter(m -> m.getModelo().equalsIgnoreCase(modelo))
				.findFirst().get();
		return result;
	}
	
	public List<ModeloVeiculo> getModelos() {
		return this.modelosVeiculos;
	}
	
	private double convert(String input) {
	    input = input.replace(',', '.');
	    return Double.valueOf(input);
	}

}

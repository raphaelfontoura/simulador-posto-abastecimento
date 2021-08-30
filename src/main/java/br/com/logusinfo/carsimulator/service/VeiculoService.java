package br.com.logusinfo.carsimulator.service;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.management.InstanceNotFoundException;

import br.com.logusinfo.carsimulator.model.*;

public class VeiculoService {
	
	List<Veiculo> veiculos = new ArrayList<>();
	ModeloVeiculoService modeloService;
	
	public VeiculoService(ModeloVeiculoService modeloService) throws FileNotFoundException, InstanceNotFoundException {
		this.modeloService = modeloService;
		try(Scanner scanner = new Scanner(new File("resources","veiculos.csv"))) {
			
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String[] values = scanner.nextLine().split(";");
				ModeloVeiculo modelo = this.modeloService.findModelo(values[0]);
				veiculos.add(new Veiculo(modelo, values[1]));
			}
		}
	}
	
	public List<Veiculo> getVeiculos(){
		return veiculos;	
	}

}

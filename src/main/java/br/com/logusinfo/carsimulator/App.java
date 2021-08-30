package br.com.logusinfo.carsimulator;

import java.io.FileNotFoundException;
import java.util.List;

import javax.management.InstanceNotFoundException;

import br.com.logusinfo.carsimulator.enums.Combustivel;
import br.com.logusinfo.carsimulator.model.Bomba;
import br.com.logusinfo.carsimulator.model.ModeloVeiculo;
import br.com.logusinfo.carsimulator.model.Veiculo;
import br.com.logusinfo.carsimulator.service.ModeloVeiculoService;
import br.com.logusinfo.carsimulator.service.PostoCombustivel;
import br.com.logusinfo.carsimulator.service.VeiculoService;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, InstanceNotFoundException, InterruptedException
    {
        ModeloVeiculoService modeloService = new ModeloVeiculoService();
        List<ModeloVeiculo> modelos = modeloService.getModelos();
        
        VeiculoService veiculoService = new VeiculoService(modeloService);
        List<Veiculo> veiculos = veiculoService.getVeiculos();
        System.out.println(veiculos);
        System.out.println(veiculos.size());
        int totalLitros = veiculos.stream()
                .map(v -> v.getModelo().getCapacidadeTanque())
                .reduce( 0 , (subtotal, value) -> subtotal += value);
        System.out.println(totalLitros);
        
        Bomba bomba1 = new Bomba(Combustivel.ETANOL, 12);
        Bomba bomba2 = new Bomba(Combustivel.GASOLINA, 10);
        
        PostoCombustivel posto = new PostoCombustivel(veiculos, bomba1, bomba2);
        
        
        while (posto.getSize() > 0) {
        	posto.gerenciaFilaVeiculos();
        	
        }
        posto.finalizarAtendimento();
        
    }
}

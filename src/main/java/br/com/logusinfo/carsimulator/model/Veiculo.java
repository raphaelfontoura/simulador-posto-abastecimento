package br.com.logusinfo.carsimulator.model;

public class Veiculo {
	
	private String placa;
    private ModeloVeiculo modelo;

    public Veiculo(ModeloVeiculo modelo, String placa) {
        this.placa = placa;
        this.modelo = modelo;
    }
    
    public ModeloVeiculo getModelo() {
    	return modelo;
    }

	@Override
	public String toString() {
		return "Veiculo [modelo=" + modelo.getModelo() + ", placa=" + placa + "]";
	}

	public String getPlaca() {
		return placa;
	}
    
    
}

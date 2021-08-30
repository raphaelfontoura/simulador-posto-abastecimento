package br.com.logusinfo.carsimulator.model;

import java.util.List;

import br.com.logusinfo.carsimulator.enums.Combustivel;

public class ModeloVeiculo {

    private String modelo;
    private Double etanolConsumo;
    private Double gasolinaConsumo;
    private int capacidadeTanque;

    public ModeloVeiculo(String modelo, Double etanolConsumo, Double gasolinaConsumo, int capacidadeTanque) {
        this.modelo = modelo;
        this.etanolConsumo = etanolConsumo;
        this.gasolinaConsumo = gasolinaConsumo;
        this.capacidadeTanque = capacidadeTanque;
    }
    
    public boolean aceitaCombustivel(Combustivel tipo) {
        boolean aceita = false;
    	if (etanolConsumo != null && Combustivel.ETANOL == tipo) {
            aceita = true;
        }
    	if (gasolinaConsumo != null && Combustivel.GASOLINA == tipo) {
            aceita = true;
        }
    	return aceita;
    }

    public String getModelo() {
    	return this.modelo;
    }
    
    public boolean isFlex() {
    	return etanolConsumo != null && gasolinaConsumo != null;
    }
    
    public int getCapacidadeTanque() {
    	return capacidadeTanque;
    }
    
    
    
	public Double getEtanolConsumo() {
		return etanolConsumo;
	}


	public Double getGasolinaConsumo() {
		return gasolinaConsumo;
	}


	@Override
	public String toString() {
		return "ModeloVeiculo [modelo=" + modelo + ", etanolConsumo=" + etanolConsumo + ", gasolinaConsumo="
				+ gasolinaConsumo + ", capacidadeTanque=" + capacidadeTanque + "]";
	}
    
}

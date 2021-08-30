package br.com.logusinfo.carsimulator.enums;

public enum Combustivel {
	ETANOL(2.27),
	GASOLINA(2.90);
	
	public final double price;
	
	Combustivel(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}

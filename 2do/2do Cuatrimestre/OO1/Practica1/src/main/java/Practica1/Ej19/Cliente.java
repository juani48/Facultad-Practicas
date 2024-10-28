package Practica1.Ej19;

import java.util.ArrayList;
import java.util.List;

import Practica1.Ej14a.IDateLapse;

public abstract class Cliente {

	@SuppressWarnings("unused")
	private String direccion;
	private List<IEnvio> envios;
	
	public Cliente(String direccion) {
		this.direccion = direccion;
		this.envios = new ArrayList<>();
	}
	
	public List<IEnvio> getEnvios(){
		return this.envios;
	}
	
	public void egregarEnvio(IEnvio envio) {
		this.getEnvios().add(envio);
	}
	
	public double montoPagara(IDateLapse periodo) {
		return this.getEnvios().stream()
				.mapToDouble(x -> x.montoPagar(periodo))
				.sum();
		
	}
}

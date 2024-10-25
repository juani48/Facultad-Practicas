package Practica1.Ej19;

import Practica1.Ej14a.IDateLapse;

public class PersonaFisica extends Cliente{

	private String nombre;
	private int dni;
	
	public PersonaFisica(String direccion, String nombre, int dni) {
		super(direccion);
		this.nombre = nombre;
		this.dni = dni;
	}
	
	@Override
	public double montoPagara(IDateLapse periodo) {
		double aux = super.montoPagara(periodo);
		return aux - (aux * 0.1);
	}
		
}

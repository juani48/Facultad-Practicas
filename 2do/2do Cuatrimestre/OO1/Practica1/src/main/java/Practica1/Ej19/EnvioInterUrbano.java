package Practica1.Ej19;
import java.time.LocalDate;

import Practica1.Ej14a.DateLapse1;
import Practica1.Ej14a.IDateLapse;

public class EnvioInterUrbano extends Envio {

	private double distancia;
	
	public EnvioInterUrbano(
			LocalDate fecha, 
			String origen, 
			String destino, 
			double gramos, 
			double distancia) 
	{
		super(fecha, origen, destino, gramos);
		this.distancia = distancia;
		
	}
	
	public double getDistancia() {
		return this.distancia;
	}
	
	@Override
	public double montoPagar(IDateLapse periodo){
		if(!periodo.includesDate(
				new DateLapse1(this.getFechaDespacho(), this.getFechaDespacho())
		))
		{
			return 0;
		}
		if(this.getDistancia() < 100) {
			return this.getGramos() * 20;
		}
		else if(this.getDistancia() >= 100 && this.getDistancia() <= 500) {
			return this.getGramos() * 25;
		}
		else {
			return this.getGramos() * 30;
		}
	}
	
}


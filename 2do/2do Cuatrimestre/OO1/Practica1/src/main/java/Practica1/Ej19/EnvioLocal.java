package Practica1.Ej19;
import java.time.LocalDate;

import Practica1.Ej14a.DateLapse1;
import Practica1.Ej14a.IDateLapse;

public class EnvioLocal extends Envio{

	private boolean rapida;
	
	public EnvioLocal(
			LocalDate fecha, 
			String origen, 
			String destino, 
			double gramos, 
			boolean rapido) 
	{
		super(fecha,origen, destino, gramos);
		this.rapida = rapido;
	}
	
	public boolean isRapdia() {
		return this.rapida;
	}
	
	@Override
	public double montoPagar(IDateLapse periodo) {
		if(!periodo.includesDate(
				new DateLapse1(this.getFechaDespacho(), this.getFechaDespacho())
		))
		{
			return 0;
		}
		double aux = 1000;
		if(this.isRapdia()) {
			aux += 500;
		}
		return aux;
	}

}

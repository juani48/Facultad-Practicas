package Practica1.Ej19;
import java.time.LocalDate;

import Practica1.Ej14a.DateLapse1;
import Practica1.Ej14a.IDateLapse;

public class EnvioInternacional extends Envio{

	public EnvioInternacional(LocalDate fecha, String origen, String destino, double gramos) {
		super(fecha, origen, destino, gramos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double montoPagar(IDateLapse periodo) {
		if(!periodo.includesDate(
				new DateLapse1(this.getFechaDespacho(), this.getFechaDespacho())
		))
		{
			return 0;
		}
		double aux = 5000;
		if(this.getGramos() / 1000 == 1) {
			return aux + this.getGramos() * 10;
		}
		else if(this.getGramos() / 1000 > 1) {
			return aux + this.getGramos() * 12;
		}else {
			return aux;
		}
	}
	
}

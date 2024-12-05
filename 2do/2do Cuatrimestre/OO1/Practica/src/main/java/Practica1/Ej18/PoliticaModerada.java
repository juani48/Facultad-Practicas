package Practica1.Ej18;

import Practica1.Ej14a.IDateLapse;
import Practica1.Ej17.Reserva;

public class PoliticaModerada implements IPolitica{

	@Override
	//reembolsa el monto total si la cancelación se hace hasta una semana antes 
	//y 50% si se hace hasta 2 días antes.
	public double reembolso(Reserva reserva) {
		IDateLapse aux = reserva.getPeriodo();
		if(reserva.getPeriodo().getFrom().isBefore(aux.getFrom().plusWeeks(1))) {
			return reserva.getPrecioNoche(reserva.getPeriodo());
		}
		else if(reserva.getPeriodo().getFrom().isBefore(aux.getFrom().plusDays(2))) {
			return reserva.getPrecioNoche(reserva.getPeriodo()) * 0.5;
		}
		else {
			return 0;
		}
	}
	

}

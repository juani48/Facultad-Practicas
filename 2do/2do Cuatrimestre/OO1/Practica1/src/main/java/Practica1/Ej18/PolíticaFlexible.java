package Practica1.Ej18;

import Practica1.Ej14a.IDateLapse;

import java.time.LocalDate;

import Practica1.Ej14a.DateLapse1;
import Practica1.Ej17.Reserva;

public class PolíticaFlexible implements IPolitica {

	@Override
	//reembolsa el monto total sin importar la fecha de cancelación 
	//(que de todas maneras debe ser anterior a la fecha de inicio de la reserva). 
	public double reembolso(Reserva reserva) {
		return reserva.getPrecioNoche(reserva.getPeriodo());
	}

}

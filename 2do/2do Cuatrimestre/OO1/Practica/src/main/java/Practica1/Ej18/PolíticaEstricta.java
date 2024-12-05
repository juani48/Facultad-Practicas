package Practica1.Ej18;

import Practica1.Ej17.Reserva;

public class PolíticaEstricta  implements IPolitica{

	@Override
	//no reembolsará nada (0, cero) sin importar la fecha tentativa de cancelación. 
	public double reembolso(Reserva reserva) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}

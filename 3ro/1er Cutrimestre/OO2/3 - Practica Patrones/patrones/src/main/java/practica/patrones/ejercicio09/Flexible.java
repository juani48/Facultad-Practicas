package practica.patrones.ejercicio09;

import java.time.LocalDate;

public class Flexible implements RefundStrategy{

	@Override
	public double amountReimbursed(LocalDate reservationDate, double cost) { 
		if(reservationDate.isAfter(LocalDate.now())) {
			return cost;
		}
		return 0;
	}
	
}

package practica.patrones.ejercicio09;

import java.time.LocalDate;

public class Strict implements RefundStrategy {

	@Override
	public double amountReimbursed(LocalDate reservationDate, double cost) { 
		return 0;
	}
	
}

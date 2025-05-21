package practica.patrones.ejercicio09;

import java.time.LocalDate;

public interface RefundStrategy {
	
	public double amountReimbursed(LocalDate reservationDate, double cost);
}

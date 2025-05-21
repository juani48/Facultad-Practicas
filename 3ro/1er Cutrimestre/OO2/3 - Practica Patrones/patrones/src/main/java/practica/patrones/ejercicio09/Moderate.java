package practica.patrones.ejercicio09;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Moderate implements RefundStrategy{

	@Override
	public double amountReimbursed(LocalDate reservationDate, double cost) { 
		if(reservationDate.isAfter(LocalDate.now())) {
			long days = ChronoUnit.DAYS.between(LocalDate.now(), reservationDate);
			if(days >= 7) {
				return cost;
			}
			else if(days >= 2) {
				return cost * 0.5;
			}
		}
		return 0;
	}
	
}

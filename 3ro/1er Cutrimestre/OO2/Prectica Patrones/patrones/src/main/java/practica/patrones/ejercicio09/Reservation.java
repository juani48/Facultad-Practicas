package practica.patrones.ejercicio09;

import java.time.LocalDate;

public class Reservation {

	private int mountOfDays;
	private LocalDate date;
	private Car car;
	private User user;
	private RefundStrategy refundStrategy;
	
	public Reservation(int mountOfDays, LocalDate date, Car car, User user, RefundStrategy refundStrategy) {
		this.mountOfDays = mountOfDays; this.date = date; this.car = car; this.user = user; this.refundStrategy = refundStrategy; 
	}
	
	public int getMountOfDays() { return mountOfDays; }
	public LocalDate getDate() { return date; }
	public Car getCar() { return car; }
	public User getUser() { return user; }
	public RefundStrategy getRefundStrategy() { return this.refundStrategy; }
	public void setRefundStrategy(RefundStrategy refundStrategy) { this.refundStrategy = refundStrategy; }


	public double cost() {
		return this.getCar().getCostPerDay() * this.getMountOfDays();
	}
	
	public double amountReimbursed() {
		return this.getRefundStrategy().amountReimbursed(this.getDate(), this.cost());
	}
	
}

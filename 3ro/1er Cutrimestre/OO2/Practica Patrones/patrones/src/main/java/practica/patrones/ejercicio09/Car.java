package practica.patrones.ejercicio09;

public class Car {

	private double costPerDay;
	private int numberOfPlaces;
	private String mark;
	
	
	public Car(double costPerDay, int numberOfPlaces, String mark) {
		this.costPerDay = costPerDay; this.numberOfPlaces = numberOfPlaces; this.mark = mark;
	}

	public double getCostPerDay() {
		return costPerDay;
	}
	
}

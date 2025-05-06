package practica.patrones.ejercicio13;

public abstract class SandwichComponent {

	private String name;
	private double cost;
	
	public SandwichComponent(String name, double cost) {
		this.name = name; this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public double getCost() {
		return cost;
	}
	
	public abstract double cost();
}

package practica.patrones.ejercicio13;

public class Component {

	private String name;
	private double cost;
	
	public Component(String name, double cost) {
		this.cost = cost; this.name = name;
	}
	
	public double cost() { return cost;}
}

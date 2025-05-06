package practica.patrones.ejercicio13;

public class Bread extends Decorator {

	public Bread(String name, double cost, SandwichComponent component) {
		super(name, cost, component);
	}

	@Override
	protected double decoratorCost() {
		return this.getCost();
	}
}

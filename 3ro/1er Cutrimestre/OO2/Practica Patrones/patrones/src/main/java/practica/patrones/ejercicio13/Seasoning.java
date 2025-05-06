package practica.patrones.ejercicio13;

public class Seasoning extends Decorator{

	public Seasoning(String name, double cost, SandwichComponent component) {
		super(name, cost, component);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double decoratorCost() {
		return this.getCost();
	}

}

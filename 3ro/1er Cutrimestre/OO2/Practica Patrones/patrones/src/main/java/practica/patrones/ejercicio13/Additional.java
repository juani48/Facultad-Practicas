package practica.patrones.ejercicio13;

public class Additional extends Decorator{

	public Additional(String name, double cost, SandwichComponent component) {
		super(name, cost, component);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double decoratorCost() {
		// TODO Auto-generated method stub
		return this.getCost();
	}

}

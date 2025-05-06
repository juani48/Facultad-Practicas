package practica.patrones.ejercicio13;

public abstract class Decorator extends SandwichComponent{

	private SandwichComponent component;
	
	public Decorator(String name, double cost, SandwichComponent component) {
		super(name, cost);
		this.component = component;
	}

	public SandwichComponent getComponent() {
		return component;
	}

	public double cost() {
		return this.getComponent().cost() + this.decoratorCost();
	}
	
	protected abstract double decoratorCost();
	
}

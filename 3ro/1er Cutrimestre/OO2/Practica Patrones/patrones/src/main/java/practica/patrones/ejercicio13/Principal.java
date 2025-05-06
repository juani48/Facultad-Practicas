package practica.patrones.ejercicio13;

public class Principal extends SandwichComponent {

	public Principal(String name, double cost) {
		super(name, cost);
	}

	@Override
	public double cost() {
		return this.cost();
	}
	
	
	
}

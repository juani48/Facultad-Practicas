package practica.patrones.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {

	private List<Component> components;
	
	
	public Sandwich() {
		this.components = new ArrayList<>();
	}
	
	public List<Component> getComponents() {
		return components;
	}

	public void addComponent(Component component) {
		this.getComponents().add(component);
	}
	
	public double cost() {
		return this.getComponents().stream().mapToDouble(x -> x.cost()).sum();
	}
	
}

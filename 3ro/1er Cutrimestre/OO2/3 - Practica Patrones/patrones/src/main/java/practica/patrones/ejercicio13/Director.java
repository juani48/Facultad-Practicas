package practica.patrones.ejercicio13;

public class Director {

	private Builder builder;
	
	public Director(Builder builder) {
		this.builder = builder;
	}

	public Builder getBuilder() {
		return builder;
	}
	
	public Sandwich build() {
		return this.getBuilder().build();
	}
	
}

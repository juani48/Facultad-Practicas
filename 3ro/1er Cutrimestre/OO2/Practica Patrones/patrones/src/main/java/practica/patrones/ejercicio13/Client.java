package practica.patrones.ejercicio13;

public class Client {

	public Client() {}
	
	public Sandwich buildClasico() {
		Director director = new Director(new BuilderClasico());
		return director.build();
	}
	
}

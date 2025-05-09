package practica.patrones.ejercicio13;

public class BuilderVegano extends Builder{

	@Override
	protected Component buildPrincipal() {
		return new Component("milanesa de girgolas", 500);
	}

	@Override
	protected Component buildBread() {
		return new Component("integral", 100);
	}

	@Override
	protected Component buildSeasoning() {
		return new Component("salsa criolla", 20);
	}

	@Override
	protected Component buildAdditional() {
		return new Component("N/A", 0);
	}

}

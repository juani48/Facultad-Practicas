package practica.patrones.ejercicio13;

public class BuilderVegetariano extends Builder{

	@Override
	protected Component buildPrincipal() {
		return new Component("provoleta grillada", 200);
	}

	@Override
	protected Component buildBread() {
		return new Component("pan con semillas", 120);
	}

	@Override
	protected Component buildSeasoning() {
		return new Component("N/A", 0);
	}

	@Override
	protected Component buildAdditional() {
		return new Component("berenjenas al escabeche", 100);
	}

}

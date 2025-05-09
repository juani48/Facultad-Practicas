package practica.patrones.ejercicio13;

public class BuilderSinTACC extends Builder{

	@Override
	protected Component buildPrincipal() {
		return new Component("carne de pollo", 250);
	}

	@Override
	protected Component buildBread() {
		return new Component("chipa", 150);
	}

	@Override
	protected Component buildSeasoning() {
		return new Component("salsa tártara", 18);
	}

	@Override
	protected Component buildAdditional() {
		return new Component("verduras grilladas", 200);
	}

}

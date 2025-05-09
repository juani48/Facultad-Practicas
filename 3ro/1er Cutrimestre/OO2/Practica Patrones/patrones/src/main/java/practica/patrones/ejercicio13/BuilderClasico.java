package practica.patrones.ejercicio13;

public class BuilderClasico extends Builder {

	@Override
	protected Component buildPrincipal() {
		return new Component("carne de ternera", 300);
	}

	@Override
	protected Component buildBread() {
		return new Component("brioche", 100);
	}

	@Override
	protected Component buildSeasoning() {
		return new Component("mayonesa", 20);
	}

	@Override
	protected Component buildAdditional() {
		return new Component("tomate", 80);
	}

}

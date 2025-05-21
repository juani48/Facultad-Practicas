package practica.patrones.ejercicio13;

public abstract class Builder {

	public Builder() {}
	
	public Sandwich build() {
		Sandwich aux = new Sandwich();
		aux.addComponent(this.buildPrincipal());
		aux.addComponent(this.buildBread());
		aux.addComponent(this.buildSeasoning());
		aux.addComponent(this.buildAdditional());
		return aux;
	}
	
	protected abstract Component buildPrincipal();
	protected abstract Component buildBread();
	protected abstract Component buildSeasoning();
	protected abstract Component buildAdditional();
	
}

package practica.patrones.ejercicio02;

public abstract class Empleado {
	
	private boolean casado;
	private int hijos;
	
	public Empleado(boolean casado, int hijos) {
		this.casado = casado;
		this.hijos = hijos;
	}
	
	public boolean getCasado() { return this.casado; }
	public int getHijos() { return this.hijos; }
	
	protected double sueldo() {
		return (this.basico() * 0.87) + (this.adicional() * 0.95);
	}
	
	protected double basico() { return 20_000; }
	
	protected double adicional() {
		double adicional = this.getHijos() * 2_000;
		if(this.getCasado()) {
			adicional += 5_000;
		}
		return adicional;
	}

	//clase intermedia con las variables de temporario y planta
}

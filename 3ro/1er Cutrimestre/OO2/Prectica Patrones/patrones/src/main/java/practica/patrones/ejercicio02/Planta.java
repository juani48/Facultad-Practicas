package practica.patrones.ejercicio02;

public class Planta extends Empleado{

	private int antiguedad;
	
	public Planta(boolean casado, int hijos, int antiguedad) {
		super(casado, hijos);
		this.antiguedad = antiguedad;
	}
	
	public int getAntiguedad() { return this.antiguedad; }
	
	@Override
	protected double basico() {
		return super.basico() + 30_000;
	}

	@Override
	protected double adicional() {
		return super.adicional() + (this.getAntiguedad() * 2_000);
	}

}

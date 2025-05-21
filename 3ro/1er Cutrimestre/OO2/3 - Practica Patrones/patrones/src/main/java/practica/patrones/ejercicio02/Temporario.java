package practica.patrones.ejercicio02;

public class Temporario extends Empleado{

	private int horas;
	
	public Temporario(boolean casado, int hijos, int horas) {
		super(casado, hijos);
		this.horas = horas;
	}
	
	public int getHoras() { return this.horas; }
	
	
	@Override
	protected double basico() {
		return super.basico() + (this.getHoras() * 300);
	}

}

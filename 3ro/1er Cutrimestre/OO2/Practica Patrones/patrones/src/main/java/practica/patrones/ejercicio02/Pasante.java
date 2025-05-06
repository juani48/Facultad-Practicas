package practica.patrones.ejercicio02;

public class Pasante extends Empleado{

	private int examenes;
	
	public Pasante(int examenes) {
		super(false, 0);
		this.examenes = examenes;
	}
	
	public int getExamenes() { return this.examenes; }

	@Override
	protected double adicional() {
		return this.getExamenes() * 2_000;
	}

}

package Practica1.Ej05;

public class Cuadrado implements Figura2D {

	private double lado;
	
	public void setLado(double lado) {
		this.lado = lado;
	}
	
	public double getLado() {
		return this.lado;
	}
	
	public double getPerimetro() {
		return this.getLado() * 4;
	}
	
	public double getArea() {
		return this.getLado() * this.getLado();
	}
	
}

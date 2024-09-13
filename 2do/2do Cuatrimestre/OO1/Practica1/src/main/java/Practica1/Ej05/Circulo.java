package Practica1.Ej05;

public class Circulo implements Figura2D {

	private double radio;

	public double getRadio() {
		return this.radio;
	}
	
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getDiametro() {
		return this.getRadio() * 2;
	}
	
	public void setDiametro(double diametro) {
		this.setRadio(diametro / 2);
	}
	
	public double getPerimetro() {
		return Math.PI * this.getDiametro();
	}
	
	public double getArea() {
		return Math.PI * (this.getRadio() * this.getRadio());
	}
	
}

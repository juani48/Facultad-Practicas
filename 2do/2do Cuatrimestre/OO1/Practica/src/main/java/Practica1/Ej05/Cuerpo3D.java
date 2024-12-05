package Practica1.Ej05;

public class Cuerpo3D {

	private double altura;
	
	private Figura2D caraBasal;
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getAltura() {
		return this.altura;
	}
	
	public void setCaraBasal(Figura2D figura2D) {
		this.caraBasal = figura2D;
	}
	
	public Figura2D getCaraBasal() {
		return this.caraBasal;
	}
	
	//área-cara-basal * altura
	
	public double getVolumen() {
		return this.getCaraBasal().getArea() * this.getAltura();
	}
	
	// 2* área-cara-basal + perímetro-cara-basal * altura-del-cuerpo

	public double getSuperficieExterior() {
		return (this.getCaraBasal().getArea() *2) + this.getCaraBasal().getPerimetro() * this.getAltura();
	}
	
	
}

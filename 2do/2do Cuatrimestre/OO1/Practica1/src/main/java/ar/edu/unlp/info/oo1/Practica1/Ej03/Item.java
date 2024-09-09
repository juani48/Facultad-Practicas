package ar.edu.unlp.info.oo1.Practica1.Ej03;

public class Item {

	private String detalle;
	private int cantidad;
	private double costoUnitario;
	
	public Item(String detalle, int cantidad, double costoUnitario) {
		this.detalle = detalle;
		this.cantidad = cantidad;
		this.costoUnitario = costoUnitario;
	}

	private int getCantidad() {
		return cantidad;
	}

	public double getCostoUnitario() {
		return costoUnitario;
	}
	
	public String getDetalle() {
		return this.detalle;
	}

	public double costo() {
		return this.getCostoUnitario() * this.getCantidad();
	}
	
}

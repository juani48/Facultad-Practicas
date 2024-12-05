package Practica1.Ej04;

import java.time.LocalDate;
import java.util.List;

public class TicketMejorado {

	private LocalDate fecha;
	private List<Producto> productos;
	private double pesoTotal;
	private double precioTotal;
	
	public TicketMejorado( double pesoTotal, double precioTotal, List<Producto> productos) {
		this.pesoTotal = pesoTotal;
		this.precioTotal = precioTotal;
		this.productos = productos;
		this.fecha = LocalDate.now();
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public List<Producto> getProductos(){
		return this.productos;
	}
	
	public int getCantidadDeProductos() {
		return this.getProductos().size();
	}
	
	public double getPrecioTotal() {
		return this.precioTotal;
	}

	public double getPesoTotal() {
		return this.pesoTotal;
	}
	
	public double impuesto() {
		return this.getPrecioTotal() * 0.21;
	}
}

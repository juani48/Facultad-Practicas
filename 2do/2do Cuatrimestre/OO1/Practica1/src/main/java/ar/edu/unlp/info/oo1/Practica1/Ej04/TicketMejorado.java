package ar.edu.unlp.info.oo1.Practica1.Ej04;

import java.time.LocalDate;
import java.util.List;

public class TicketMejorado {

	private LocalDate fecha;
	private List<Producto> productos;
	
	public TicketMejorado(List<Producto> productos) {
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
		double aux = 0;
		for(Producto x : this.getProductos()) {
			aux += x.getPrecio();
		}
		return aux;
	}

	public double getPesoTotal() {
		double aux = 0;
		for(Producto x : this.getProductos()) {
			aux += x.getPeso();
		}
		return aux;
	}
	
	public double impuesto() {
		return this.getPrecioTotal() * 0.21;
	}
}

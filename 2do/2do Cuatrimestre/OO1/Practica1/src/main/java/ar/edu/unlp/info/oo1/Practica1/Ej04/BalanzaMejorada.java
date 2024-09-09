package ar.edu.unlp.info.oo1.Practica1.Ej04;

import java.util.ArrayList;
import java.util.List;

public class BalanzaMejorada {

	private List<Producto> productos;
	
	public BalanzaMejorada() {
		this.productos = new ArrayList<Producto>();
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
	
	public void ponerEnCero() {
		this.productos = new ArrayList<Producto>();
	}
	
	public void agregarProducto(Producto producto) {
		this.getProductos().add(producto);
	}
	
	public TicketMejorado emitirTicket() {
		return new TicketMejorado(this.getProductos());
	}
	
}

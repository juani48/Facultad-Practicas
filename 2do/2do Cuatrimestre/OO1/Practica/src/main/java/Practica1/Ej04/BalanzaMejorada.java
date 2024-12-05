package Practica1.Ej04;

import java.util.ArrayList;
import java.util.List;

public class BalanzaMejorada {

	private List<Producto> productos;
	
	public BalanzaMejorada() {
		this.ponerEnCero();
	}
	
	public List<Producto> getProductos(){
		return this.productos;
	}
	
	public int getCantidadDeProductos() {
		return this.getProductos().size();
	}
	
	public double getPrecioTotal() {
		return this.getProductos().stream().mapToDouble(x -> x.getPrecio()).sum();
	}

	
	public double getPesoTotal() {
		return this.getProductos().stream().mapToDouble(x -> x.getPeso()).sum();
	}
	
	public void ponerEnCero() {
		this.productos = new ArrayList<Producto>();
	}
	
	public void agregarProducto(Producto producto) {
		this.getProductos().add(producto);
	}
	
	public TicketMejorado emitirTicket() {
		return new TicketMejorado(this.getPesoTotal(), this.getPrecioTotal(),this.getProductos());
	}
	
}

package Practica1.Ej02;

public class Balanza {

	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	
	public void setCantidadDeProductos(int cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}
	
	public int getCantidadDeProductos() {
		return this.cantidadDeProductos;
	}
	
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public double getPrecioTotal() {
		return this.precioTotal;
	}
	
	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	
	public double getPesoTotal() {
		return this.pesoTotal;
	}
	
	public void ponerEnCero() {
		this.setCantidadDeProductos(0);
		this.setPesoTotal(0);
		this.setPrecioTotal(0);
	}
	
	public void agregarProducto(Producto producto) {
		this.setCantidadDeProductos(this.getCantidadDeProductos() + 1);
		this.setPesoTotal(this.getPesoTotal() + producto.getPeso());
		this.setPrecioTotal(this.getPrecioTotal() + producto.getPrecio());
	}
	
	public Ticket emitirTicket() {
		return new Ticket(this.getCantidadDeProductos(), this.getPesoTotal(), this.getPrecioTotal());
	}
	
}

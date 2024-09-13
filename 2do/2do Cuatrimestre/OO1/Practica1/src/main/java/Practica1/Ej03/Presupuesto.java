package Practica1.Ej03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presupuesto {

	private LocalDate fecha;
	private String cliente;
	private List<Item> items;
	
	public Presupuesto(String cliente) {
		this.cliente = cliente;
		this.items = new ArrayList<Item>();
		this.fecha = LocalDate.now();
	}
	
	public List<Item> getItems(){
		return this.items;
	}
	
	public String getCliente() {
		return this.cliente;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}
	
	public void agregarItem(Item item) {
		this.items.add(item);
	}
	
	public double calcularTotal() {
		double aux = 0;
		for(Item x : this.getItems()) {
			aux += x.costo();
		}
		return aux;
	}
	
}

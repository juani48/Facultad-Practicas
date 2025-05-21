package ar.edu.unlp.info.oo2.facturacion_llamadas2;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	public List<Llamada> llamadas = new ArrayList<Llamada>();
	private TipoCliente tipo;
	private String nombre;
	private String numeroTelefono;
	private String data;
	
	public Cliente(TipoCliente tipo, String nombre, String numero, String data) {
		this.tipo = tipo; this.nombre = nombre; this.numeroTelefono = numero; this.data = data;
	}
	
	public List<Llamada> getLlamadas(){ return this.llamadas; }
	public String getNumeroTelefono() { return this.numeroTelefono; }
	public TipoCliente getTipo() { return this.tipo; }
	
	public void agregarLlamada(Llamada llamada) {
		this.getLlamadas().add(llamada);
	}
	
	public double calcularMontoTotalLlamadas() {
		return this.getLlamadas().stream().mapToDouble(x -> x.calcularMonto() - this.getTipo().descuento(x.calcularMonto())).sum();
	}
}

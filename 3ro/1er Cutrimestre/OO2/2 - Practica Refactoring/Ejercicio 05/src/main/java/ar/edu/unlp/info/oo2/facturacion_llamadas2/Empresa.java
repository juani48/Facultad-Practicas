package ar.edu.unlp.info.oo2.facturacion_llamadas2;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private GestorNumerosDisponibles guia = new GestorNumerosDisponibles();

	public int cantidadDeUsuarios() { return clientes.size(); }
	public boolean existeUsuario(Cliente persona) { return clientes.contains(persona); }
	public GestorNumerosDisponibles getGestorNumeros() { return this.guia; }
	public List<Cliente> getClientes(){ return this.clientes; }
	
	public String obtenerNumeroLibre() { return guia.obtenerNumeroLibre(); }
	public boolean agregarNumeroTelefono(String str) { return this.getGestorNumeros().agregarNumeroTelefono(str); }
	
	public Cliente registrarUsuario(String data, String nombre, TipoCliente tipo) {
		Cliente var = new Cliente(tipo, nombre, this.obtenerNumeroLibre(), data);
		this.getClientes().add(var);
		return var;
	}

	public Llamada registrarLlamada(Cliente origen, Cliente destino, TipoLlamada tipo, int duracion) {
		Llamada llamada = new Llamada(tipo, origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion); 
		origen.agregarLlamada(llamada);
		return llamada;
	}

	public double calcularMontoTotalLlamadas(Cliente cliente) {
		return cliente.calcularMontoTotalLlamadas();
	}

}

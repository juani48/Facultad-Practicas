package ar.edu.unlp.info.oo2.facturacion_llamadas2;

import java.util.SortedSet;
import java.util.TreeSet;

public class GestorNumerosDisponibles {

	private SortedSet<String> lineas = new TreeSet<String>();
	private GeneradorNumero tipoGenerador = new Ultimo();

	public SortedSet<String> getLineas() { return lineas; }
	public void cambiarTipoGenerador(GeneradorNumero valor) { this.tipoGenerador = valor; }
	public GeneradorNumero getTipoGenerador() { return this.tipoGenerador; }
	
	public boolean agregarNumeroTelefono(String str) {
		if (!this.getLineas().contains(str)) {
			this.getLineas().add(str);
			return true;
		}
		return false;
	}

	public String obtenerNumeroLibre() {
		return this.getTipoGenerador().obtenerNumeroLibre(this.getLineas());
	}
}

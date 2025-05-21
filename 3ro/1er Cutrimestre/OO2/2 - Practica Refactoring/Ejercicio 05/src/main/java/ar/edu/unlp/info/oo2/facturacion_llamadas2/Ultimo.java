package ar.edu.unlp.info.oo2.facturacion_llamadas2;

import java.util.SortedSet;

public class Ultimo implements GeneradorNumero{

	@Override
	public String obtenerNumeroLibre(SortedSet<String> lineas) {
		String linea = lineas.last();
		lineas.remove(linea);
		return linea;
	}
}

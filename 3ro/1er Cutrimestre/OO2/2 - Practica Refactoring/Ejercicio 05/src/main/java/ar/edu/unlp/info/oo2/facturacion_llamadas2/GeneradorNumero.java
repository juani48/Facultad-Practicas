package ar.edu.unlp.info.oo2.facturacion_llamadas2;

import java.util.SortedSet;

public interface GeneradorNumero {
	public String obtenerNumeroLibre(SortedSet<String> lineas);
}

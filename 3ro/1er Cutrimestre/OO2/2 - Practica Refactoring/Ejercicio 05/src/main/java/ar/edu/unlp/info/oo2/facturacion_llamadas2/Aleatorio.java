package ar.edu.unlp.info.oo2.facturacion_llamadas2;

import java.util.ArrayList;
import java.util.Random;
import java.util.SortedSet;
import java.util.random.RandomGenerator;


public class Aleatorio implements GeneradorNumero{

	@Override
	public String obtenerNumeroLibre(SortedSet<String> lineas) {
		String linea = new ArrayList<String>(lineas).get( new Random().nextInt(lineas.size()));
		lineas.remove(linea);
		return linea;
	}
}

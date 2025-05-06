package practica.patrones.ejercicio05;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Release extends Criterion{

	@Override
	protected Stream<Movie> sorted(Stream<Movie> list) {
		return list.sorted((x, y) -> x.getRelease().compareTo(y.getRelease()));
	} 
}

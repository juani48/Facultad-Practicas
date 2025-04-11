package practica.patrones.ejercicio05;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Similarity extends Criterion {

	@Override
	protected Stream<Movie> sorted(Stream<Movie> list) {
		return list.map(x -> x.getSimilar())
				.flatMap(List::stream)
				.distinct();
	}
}

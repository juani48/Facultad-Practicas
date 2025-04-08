package practica.patrones.ejercicio05;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Release extends Criterion{

	@Override
	public List<Movie> recommend(List<Movie> reproduced, List<Movie> movies){
		return super.recommend(reproduced, movies).stream()
				.sorted((x, y) -> x.getRelease().compareTo(y.getRelease()))
				.limit(3)
				.collect(Collectors.toList());
	} 
	
}

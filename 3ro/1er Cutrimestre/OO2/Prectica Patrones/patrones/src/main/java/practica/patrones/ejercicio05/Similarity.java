package practica.patrones.ejercicio05;

import java.util.List;

public abstract class Similarity extends Criterion {
	
	@Override
	public List<Movie> recommend(List<Movie> reproduced, List<Movie> movies){
		return reproduced.stream()
				.map(x -> x.getSimilar().g);
	}

}

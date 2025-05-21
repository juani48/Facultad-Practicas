package practica.patrones.ejercicio05;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Criterion {
	
	
	public List<Movie> recommend(List<Movie> reproduced, List<Movie> movies){
		return this.collect(this.limit(this.sorted(this.noViews(reproduced, movies).stream()), 3));
	}
	
	protected List<Movie> noViews(List<Movie> reproduced, List<Movie> movies){
		List<Movie> list = movies;
		list.removeAll(reproduced);
		return list;
	}
	
	protected abstract Stream<Movie> sorted(Stream<Movie> list);
	
	protected Stream<Movie> limit(Stream<Movie> list, int limit){
		return list.limit(limit);
	}
	
	protected List<Movie> collect(Stream<Movie> list){
		return list.collect(Collectors.toList());
	}
}

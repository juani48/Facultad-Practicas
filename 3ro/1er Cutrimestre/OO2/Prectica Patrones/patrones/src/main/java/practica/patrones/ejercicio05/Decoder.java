package practica.patrones.ejercicio05;

import java.util.ArrayList;
import java.util.List;

public class Decoder {
	
	private List<Movie> movies;
	private List<Movie> reproduced;
	private Criterion criterion;
	
	public Decoder(Criterion criterion) {
		this.criterion = criterion;
		this.reproduced = new ArrayList();
		this.movies = new ArrayList();
	}
	
	public void setCriterion(Criterion criterion) {
		this.criterion = criterion;
	}
	
	public List<Movie> recommend(Movie movie){
		return this.criterion.recommend(movie, this.reproduced, this.movies);
	}
	
}

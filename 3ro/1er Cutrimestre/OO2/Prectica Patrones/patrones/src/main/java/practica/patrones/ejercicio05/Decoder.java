package practica.patrones.ejercicio05;

import java.util.ArrayList;
import java.util.List;

public class Decoder {
	
	private List<Movie> movies;
	private List<Movie> reproduced;
	private Criterion criterion;
	
	public Decoder(Criterion criterion) {
		this.criterion = criterion;
		this.reproduced = new ArrayList<Movie>();
		this.movies = new ArrayList<Movie>();
	}
	
	public void setCriterion(Criterion criterion) {
		this.criterion = criterion;
	}
	
	public List<Movie> recommend(Movie movie){
		return this.criterion.recommend(this.reproduced, this.movies);
	}
	
}

package practica.patrones.ejercicio05;

import java.util.List;

public abstract class Criterion {
	
	private List<Movie> list; 
	
	public  List<Movie> recommend(List<Movie> reproduced, List<Movie> movies){
		this.list = movies;
		this.list.removeAll(reproduced);
		return list;
	}
}

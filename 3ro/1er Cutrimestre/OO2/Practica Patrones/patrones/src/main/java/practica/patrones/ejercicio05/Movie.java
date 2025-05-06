package practica.patrones.ejercicio05;

import java.time.LocalTime;
import java.util.List;

public class Movie {
	
	private String title;
	private LocalTime release;
	private double score;
	private List<Movie> similar;
	
	public Movie(String title, LocalTime release, double score, List<Movie> similar) { 
		this.title = title; this.release = release; this.score = score; this.similar = similar;	
	}
	
	public LocalTime getRelease() { return this.release; }
	public String getTitle() { return this.title; }
	public double getScore() { return this.score; }
	public List<Movie> getSimilar(){ return this.similar; }
	
	public boolean equals(Movie movie) {
		return this.getTitle().equals(movie.getTitle()) 
				&& this.getScore() == movie.getScore()
				&& this.getRelease().equals(movie.getRelease());
	}
	
	public boolean isNovelty(Movie movie) {
		return this.release.isAfter(movie.getRelease());
	}
	
	public boolean isSimilarity(Movie movie) {
		return this.getSimilar().contains(movie);
	}
	
}

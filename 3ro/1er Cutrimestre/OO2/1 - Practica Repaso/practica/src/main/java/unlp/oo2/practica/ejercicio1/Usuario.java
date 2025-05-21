package unlp.oo2.practica.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String screenName;
	private List<Tweet> tweets;
	
	public Usuario(String screenName) {
		this.screenName = screenName;
		this.tweets = new ArrayList<>();
	}
	
	public String getScreenName() {return this.screenName;}
	public List<Tweet> getTweets(){return this.tweets;}
	
	public void eliminarTweets() {this.getTweets().clear();}
	public void agregarTweet(Tweet tweet) {this.getTweets().add(tweet);}
}

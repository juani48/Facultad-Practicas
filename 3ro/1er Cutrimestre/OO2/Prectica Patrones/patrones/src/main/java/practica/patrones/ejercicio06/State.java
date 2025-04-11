package practica.patrones.ejercicio06;

import java.util.ArrayList;
import java.util.List;

public abstract class State {

	private List<User> registered;
	
	public State() {
		this.registered = new ArrayList<User>();
	}
	
	public State(List<User> list) {
		this.registered = list;
	}
	
	public List<User> getRegistered(){ return this.registered; }
	public int registeredSize() { return this.getRegistered().size(); }
	
	public abstract void signOn(Excursion excursion, User user);
	
}

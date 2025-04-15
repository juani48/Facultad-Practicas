package practica.patrones.ejercicio06;

import java.util.ArrayList;
import java.util.List;

public class Full extends State{

	private List<User> onHold;
	
	public Full(List<User> registered) {
		super(registered);
		this.onHold = new ArrayList<User>();
	}
	
	public List<User> getOnHold(){ return this.onHold; }
	
	@Override
	public void signOn(Excursion excursion, User user) {
		this.getOnHold().add(user);
	}
}

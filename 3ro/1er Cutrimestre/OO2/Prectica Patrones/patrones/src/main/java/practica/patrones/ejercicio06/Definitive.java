package practica.patrones.ejercicio06;

import java.util.ArrayList;
import java.util.List;

public class Definitive extends State{
	
	
	public Definitive(List<User> registered) {
		super(registered);
	}
	
	@Override
	public void signOn(Excursion excursion, User user) {
		this.getRegistered().add(user);
		if(this.registeredSize() >= excursion.getMaxQuota()) {
			excursion.setState(new Full(this.getRegistered()));
		}

	}
	
}

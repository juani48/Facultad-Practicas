package practica.patrones.ejercicio06;

public class Provisional extends State{

	public Provisional() {
		super();
	}
	
	@Override
	public void signOn(Excursion excursion, User user) {
		this.getRegistered().add(user);
		if(this.registeredSize() >= excursion.getMinQuota()) {
			excursion.setState(new Definitive(this.getRegistered()));
		}
	}

	@Override
	public String getInformation(Excursion excursion) {
		 return super.getInformation(excursion) + (excursion.getMinQuota() - this.registeredSize());
	}
}

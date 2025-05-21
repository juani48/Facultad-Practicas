
package practica.patrones.ejercicio06;

public class User {

	private String name;
	private String lastName;
	private String email;
	private Excursion excursion;
	
	public User(String name, String lastName, String email) {
		this.name = name; this.lastName = lastName; this.email = email;
	}
	
	public String getName() { return name; }
	public String getLastName() { return lastName; }
	public String getEmail() { return email; }
	
	public void register(Excursion excursion) {
		excursion.signOn(this);
		this.excursion = excursion; 
	}
	
	public String getInformation() {
		return this.excursion.getInformation();
	}
	
}

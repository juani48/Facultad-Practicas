package practica.patrones.ejercicio07;

public class Error extends State{
	
	@Override
	public void delete(Calculator calculator) { this.setValue(0); calculator.setState(new Initial());}
	
	@Override
	public String getResult(Calculator calculator) { return "Error"; }

}

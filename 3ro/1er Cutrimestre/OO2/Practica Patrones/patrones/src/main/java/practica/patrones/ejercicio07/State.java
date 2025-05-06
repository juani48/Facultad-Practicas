package practica.patrones.ejercicio07;

public abstract class State {
	
	private double value;

	public double getValue() { return this.value; }
	protected void setValue(double value) { this.value = value;}
	
	public void plus(Calculator calculator) { calculator.setState(new Error());}
	public void subtraction(Calculator calculator) { calculator.setState(new Error());}
	public void multiplication(Calculator calculator) { calculator.setState(new Error());}
	public void division(Calculator calculator) { calculator.setState(new Error());}
	public void delete(Calculator calculator) { calculator.setState(new Error());}
	
	public void setValue(Calculator calculator, double value) { calculator.setState(new Error());}
	public String getResult(Calculator calculator) { calculator.setState(new Error()); return calculator.getResult(); }
}

package practica.patrones.ejercicio07;

public class Initial extends State{
	
	@Override
	public void setValue(Calculator calculator, double value) { super.setValue(value); }
	
	@Override
	public void plus(Calculator calculator) { calculator.setState(new Plus());}
	
	@Override
	public void subtraction(Calculator calculator) { calculator.setState(new Subtraction());}

	@Override
	public void multiplication(Calculator calculator) { calculator.setState(new Multiplication());}
	
	@Override
	public void division(Calculator calculator) { calculator.setState(new Division());}
	
	@Override
	public void delete(Calculator calculator) { this.setValue(0); }
	
}	

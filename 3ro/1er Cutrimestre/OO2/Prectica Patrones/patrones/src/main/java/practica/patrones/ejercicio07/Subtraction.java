package practica.patrones.ejercicio07;

public class Subtraction extends State{

	@Override
	public void setValue(Calculator calculator, double value) { this.setValue(this.getValue() - value); calculator.setState(new Initial());}
	
	@Override
	public void delete(Calculator calculator) { this.setValue(0); calculator.setState(new Initial());}
}

package practica.patrones.ejercicio07;

public class Calculator {

	private State state;
	
	public Calculator(State state) {
		this.state = state;
	}
	
	public void setState(State state) { this.state = state; }
	public State getState() { return this.state; }
	
	public String getResult() { return this.getState().getResult(this); }
	
	public void delete() { this.getState().delete(this);}
	
	public void setValue(double value) { this.getState().setValue(this, value);}
	
	 public void plus() { this.state.plus(this); }
	 public void subtraction() { this.getState().subtraction(this); }
	 public void multiplication() { this.getState().multiplication(this); }
	 public void division() { this.getState().division(this); }
	
}

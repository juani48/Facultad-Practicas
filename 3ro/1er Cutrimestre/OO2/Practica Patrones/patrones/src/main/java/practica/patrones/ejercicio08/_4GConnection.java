package practica.patrones.ejercicio08;

public class _4GConnection {

	private String symb;
	
	public _4GConnection(String symb) {
		this.symb = symb;
	}
	
	public String getSymb() { return this.symb; }
	
	public String transmit(String data, long crc) {
		return "4G";
	}
	
}

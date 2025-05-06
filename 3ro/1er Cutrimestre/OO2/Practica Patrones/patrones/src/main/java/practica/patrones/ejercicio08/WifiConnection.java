package practica.patrones.ejercicio08;

public class WifiConnection implements IConnection{

	private String pict;
	
	public WifiConnection(String pict) {
		this.pict = pict;
	}
	@Override
	public String sendData(String data, long crc) {
		return "Wifi";
	}

	@Override
	public String pict() { return this.pict; }
	
}

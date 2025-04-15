package practica.patrones.ejercicio08;

public class Device {

	private ICrcCalculator crcCalculator;
	private Ringer ringer;
	private Display display;
	private IConnection connection;
	
	public Device(ICrcCalculator crcCalculator, IConnection connection, Ringer ringer, Display display) {
		this.crcCalculator = crcCalculator; this.connection = connection; this.ringer = ringer; this.display = display;
	}

	public ICrcCalculator getCrcCalculator() { return crcCalculator; }
	public void configureCRC(ICrcCalculator crcConnection) { this.crcCalculator = crcConnection; }

	public IConnection getConnection() { return connection; }
	private void setConnection(IConnection connection) { this.connection = connection; }

	public Ringer getRinger() { return ringer; }
	public Display getDisplay() { return display; }
	
	public String send(String data) { 
		return this.getConnection().sendData(data ,(this.getCrcCalculator().crcFor(data))); 
	}
	
	public String connectWith(IConnection connection) {
		this.setConnection(connection);
		this.getRinger().ringer();
		return this.getDisplay().showBanner(this.getConnection().pict());
	}	
}

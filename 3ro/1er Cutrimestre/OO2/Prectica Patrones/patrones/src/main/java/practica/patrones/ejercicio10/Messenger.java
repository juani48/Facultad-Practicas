package practica.patrones.ejercicio10;

public class Messenger {
	
	private EncryptionStrategy encryptiongStrategy;
	
	public Messenger(EncryptionStrategy encryptiongStrategy) {
		this.encryptiongStrategy = encryptiongStrategy;
	}
	
	public EncryptionStrategy getEncryptionStrategy() { return this.encryptiongStrategy; }
	public void setEncryptionStrategy(EncryptionStrategy encryptiongStrategy) { this.encryptiongStrategy = encryptiongStrategy; }
	
	public void send(String message) {
		
	}
	
	public void receive(String message) {}
	
}

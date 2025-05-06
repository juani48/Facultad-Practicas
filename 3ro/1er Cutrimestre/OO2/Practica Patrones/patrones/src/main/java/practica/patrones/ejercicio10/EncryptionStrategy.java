package practica.patrones.ejercicio10;

public abstract class EncryptionStrategy {
	
	private String key;
	
	public EncryptionStrategy(String key) {
		this.key = key;
	}
	
	public String getKey() { return this.key; }
	
	public abstract String decrypt(String message);
	public abstract String encrypt(String massage);
}

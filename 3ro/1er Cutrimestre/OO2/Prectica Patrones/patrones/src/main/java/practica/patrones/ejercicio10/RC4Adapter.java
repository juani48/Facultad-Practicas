package practica.patrones.ejercicio10;

public class RC4Adapter extends EncryptionStrategy{

	private RC4 rc4;
	
	public RC4Adapter(String key) {
		super(key);
		this.rc4 = new RC4();
	}
	
	public RC4 getRc4() {
		return rc4;
	}

	@Override
	public String decrypt(String message) {
		return this.getRc4().desencriptar(message, this.getKey());
	}

	@Override
	public String encrypt(String massage) {
		return this.getRc4().encriptar(massage, this.getKey());
	}

}

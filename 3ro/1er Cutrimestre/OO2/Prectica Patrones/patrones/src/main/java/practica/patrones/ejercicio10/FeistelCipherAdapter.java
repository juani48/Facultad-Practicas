package practica.patrones.ejercicio10;

public class FeistelCipherAdapter extends EncryptionStrategy{

	private FeistelCipher feistelCipher;
	
	public FeistelCipherAdapter(String key) {
		super(key);
		this.feistelCipher = new FeistelCipher(key);
	}

	public FeistelCipher getFeistelCipher() {
		return feistelCipher;
	}

	@Override
	public String decrypt(String message) {
		return this.getFeistelCipher().encode(message);
	}

	@Override
	public String encrypt(String massage) {
		return this.getFeistelCipher().encode(massage);
	}

}

package practica.patrones.ejercicio08;

public class _4GConnectionAdapter implements IConnection{

	private _4GConnection _4gConnection;
	
	public _4GConnectionAdapter(_4GConnection _4gConnection) {
		this._4gConnection = _4gConnection;
	}
	
	public _4GConnection get_4gConnection() {
		return _4gConnection;
	}

	@Override
	public String sendData(String data, long crc) {
		return this.get_4gConnection().transmit(data, crc);
	}

	@Override
	public String pict() {
		return this.get_4gConnection().getSymb();
	}

}

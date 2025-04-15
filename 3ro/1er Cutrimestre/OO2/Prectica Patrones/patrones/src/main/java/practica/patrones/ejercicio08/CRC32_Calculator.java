package practica.patrones.ejercicio08;

import java.util.zip.CRC32;

public class CRC32_Calculator implements ICrcCalculator{

	@Override
	public long crcFor(String data) {
		CRC32 crc = new CRC32();
		String datos = "un mensaje";
		crc.update(datos.getBytes());
		return crc.getValue();
	}
}

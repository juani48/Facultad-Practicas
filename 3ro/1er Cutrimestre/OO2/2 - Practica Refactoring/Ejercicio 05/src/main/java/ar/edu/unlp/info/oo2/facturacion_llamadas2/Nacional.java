package ar.edu.unlp.info.oo2.facturacion_llamadas2;

public class Nacional implements TipoLlamada{

	@Override
	public double calcularMonto(int duracion) {
		return duracion * 3 + (duracion * 3 * 0.21);
	}

}

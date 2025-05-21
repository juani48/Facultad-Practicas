package ar.edu.unlp.info.oo2.facturacion_llamadas2;

public class Internacional implements TipoLlamada{

	@Override
	public double calcularMonto(int duracion) {
		return duracion * 150 + (duracion * 150 * 0.21) + 50;
	}

}

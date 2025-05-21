package ar.edu.unlp.info.oo2.facturacion_llamadas2;

public class Juridico implements TipoCliente{

	@Override
	public double descuento(double total) {
		return total * 0.15;
	}

}

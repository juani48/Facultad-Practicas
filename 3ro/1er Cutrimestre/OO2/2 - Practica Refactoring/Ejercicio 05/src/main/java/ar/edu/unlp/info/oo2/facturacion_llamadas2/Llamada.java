package ar.edu.unlp.info.oo2.facturacion_llamadas2;

public class Llamada {

	private TipoLlamada tipoDeLlamada;
	private String origen;
	private String destino;
	private int duracion;

	public Llamada(TipoLlamada tipoLlamada, String origen, String destino, int duracion) {
		this.tipoDeLlamada = tipoLlamada; this.origen= origen; this.destino= destino; this.duracion = duracion;
	}

	public TipoLlamada getTipoDeLlamada() { return tipoDeLlamada; }

	public String getRemitente() { return destino; }

	public int getDuracion() { return this.duracion; }

	public String getOrigen() { return origen; }
	
	public double calcularMonto() { return this.getTipoDeLlamada().calcularMonto(this.getDuracion()); }
	
}

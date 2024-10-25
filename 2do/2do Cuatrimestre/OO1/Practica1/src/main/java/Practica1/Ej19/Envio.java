package Practica1.Ej19;
import java.time.LocalDate;

public abstract class Envio  implements IEnvio {

	private LocalDate fechaDespacho;
	private String origen;
	private String destino;
	private double gramos;
	
	public Envio(LocalDate fecha, String origen, String destino, double gramos) {
		this.fechaDespacho = fecha;
		this.origen = origen;
		this.destino = destino;
		this.gramos = gramos;
	}
	
	public double getGramos() {
		return this.gramos;
	}
	
	public LocalDate getFechaDespacho() {
		return this.fechaDespacho;
	}
	
}

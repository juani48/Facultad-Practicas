package Practica1.Ej19;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Practica1.Ej14a.DateLapse1;
import Practica1.Ej14a.IDateLapse;

public class EnvioLocalTest {

	private EnvioLocal envioLocal;
	private LocalDate fecha;
	private IDateLapse periodo;
	
	@BeforeEach
	void setUp() {
		this.fecha = LocalDate.now();
		this.periodo = new DateLapse1(this.fecha, this.fecha.plusDays(3));
	}
	
	@Test
	void testMontoPagarLento() {
		this.envioLocal = new EnvioLocal(this.fecha, "origen1","destino1", 1, false);
		assertEquals(1000, this.envioLocal.montoPagar(this.periodo));
		
		IDateLapse periodo2 = new DateLapse1(this.fecha.plusDays(1), this.fecha.plusDays(3));
		assertEquals(0, this.envioLocal.montoPagar(periodo2));
	}
	
	@Test
	void testMontoPagarRapido() {
		this.envioLocal = new EnvioLocal(this.fecha, "origen2","destino2", 1, true);
		assertEquals(1500, this.envioLocal.montoPagar(periodo));
		
		IDateLapse periodo2 = new DateLapse1(this.fecha.plusDays(1), this.fecha.plusDays(3));;
		assertEquals(0, this.envioLocal.montoPagar(periodo2));
	}
	
}

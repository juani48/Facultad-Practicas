package Practica1.Ej19;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Practica1.Ej14a.DateLapse1;
import Practica1.Ej14a.IDateLapse;

public class EnvioInternacionalTest {

	private EnvioInternacional envioInternacional;
	private LocalDate fecha;
	private IDateLapse periodo;
	
	@BeforeEach
	void setUp() {
		this.fecha = LocalDate.now();
		this.periodo = new DateLapse1(this.fecha, this.fecha.plusDays(3));
	}
	
	@Test
	void testMontoPagarFuera() {
		this.envioInternacional = new EnvioInternacional(this.fecha, "origen", "destino", 1000);
		IDateLapse periodo2 = new DateLapse1(this.fecha.plusDays(1), this.fecha.plusDays(3));
		assertEquals(0, this.envioInternacional.montoPagar(periodo2));
	}
	
	@Test
	void testMontoPagarLiviano() {
		this.envioInternacional = new EnvioInternacional(this.fecha, "origen", "destino", 999);
		assertEquals(5000, this.envioInternacional.montoPagar(periodo));
	}
	
	@Test
	void testMontoPagarMedio() {
		this.envioInternacional = new EnvioInternacional(this.fecha, "origen", "destino", 1000);
		assertEquals(15000, this.envioInternacional.montoPagar(periodo));
	}
	@Test
	void testMontoPagarPesado() {
		this.envioInternacional = new EnvioInternacional(this.fecha, "origen", "destino", 1001);
		assertEquals(17012, this.envioInternacional.montoPagar(periodo));
	}
	
}

package Practica1.Ej19;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Practica1.Ej14a.DateLapse1;
import Practica1.Ej14a.IDateLapse;

public class EnvioInterUrbanoTest {

	private EnvioInterUrbano envioInterUrbano;
	private LocalDate fecha;
	private IDateLapse periodo;
	
	@BeforeEach
	void setUp() {
		this.fecha = LocalDate.now();
		this.periodo = new DateLapse1(this.fecha, this.fecha.plusDays(3));
	}
	
	@Test
	void testMontoPagarFuera() {
		this.envioInterUrbano = new EnvioInterUrbano(this.fecha, "origen", "destino",1, 1);
		IDateLapse periodo2 = new DateLapse1(this.fecha.plusDays(1), this.fecha.plusDays(3));
		assertEquals(0, this.envioInterUrbano.montoPagar(periodo2));
	}
	
	@Test
	void testMontoPagarMinimo() {
		this.envioInterUrbano = new EnvioInterUrbano(this.fecha, "origen", "destino", 1, 99);
		assertEquals(20, this.envioInterUrbano.montoPagar(periodo));
		
		this.envioInterUrbano = new EnvioInterUrbano(this.fecha, "origen", "destino", 1, 100);
		assertNotEquals(20, this.envioInterUrbano.montoPagar(periodo));
	}
	
	@Test
	void testMontoPagarInteredio() {
		this.envioInterUrbano = new EnvioInterUrbano(this.fecha, "origen", "destino", 1 , 100);
		assertEquals(25, this.envioInterUrbano.montoPagar(periodo));
		
		this.envioInterUrbano = new EnvioInterUrbano(this.fecha, "origen", "destino", 1, 99);
		assertNotEquals(25, this.envioInterUrbano.montoPagar(periodo));
		
		this.envioInterUrbano = new EnvioInterUrbano(this.fecha, "origen", "destino", 1, 500);
		assertEquals(25, this.envioInterUrbano.montoPagar(periodo));
		
		this.envioInterUrbano = new EnvioInterUrbano(this.fecha, "origen", "destino", 1, 501);
		assertNotEquals(25, this.envioInterUrbano.montoPagar(periodo));
	}
	
	@Test
	void testMontoPagarMaximo() {
		this.envioInterUrbano = new EnvioInterUrbano(this.fecha, "origen", "destino", 1, 501);
		assertEquals(30, this.envioInterUrbano.montoPagar(periodo));
		
		this.envioInterUrbano = new EnvioInterUrbano(this.fecha, "origen", "destino", 1, 499);
		assertNotEquals(30, this.envioInterUrbano.montoPagar(periodo));
	}
}

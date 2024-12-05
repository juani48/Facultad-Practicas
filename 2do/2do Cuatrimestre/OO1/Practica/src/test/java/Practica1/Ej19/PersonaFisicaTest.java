package Practica1.Ej19;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Practica1.Ej14a.DateLapse1;
import Practica1.Ej14a.IDateLapse;

public class PersonaFisicaTest {

	private PersonaFisica personaFisica;
	private LocalDate fecha;
	private IDateLapse periodo;
	
	@BeforeEach
	void setUp() {
		this.personaFisica = new PersonaFisica("direccion", "nombre", 123);
		this.fecha = LocalDate.now();
		IEnvio envio = new EnvioLocal(this.fecha, "origen", "destino", 1, false);
		this.personaFisica.egregarEnvio(envio);
		this.periodo = new DateLapse1(this.fecha, this.fecha.plusDays(3));
	}
	
	@Test
	void testMontoPagara() {
		assertEquals(900, this.personaFisica.montoPagara(this.periodo));
		assertNotEquals(901, this.personaFisica.montoPagara(this.periodo));
		this.periodo = new DateLapse1(this.fecha.plusDays(1), this.fecha.plusDays(3));
		assertEquals(0, this.personaFisica.montoPagara(periodo));
	}
}


package Practica1.Ej19;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Practica1.Ej14a.DateLapse1;
import Practica1.Ej14a.IDateLapse;

public class ClienteCorporativoTest {

	private ClienteCorporativo clienteCorporativo;
	private LocalDate fecha;
	private IDateLapse periodo;
	
	@BeforeEach
	void setUp() {
		this.clienteCorporativo = new ClienteCorporativo("direccion", "nombre", 123);
		this.fecha = LocalDate.now();
		IEnvio envio = new EnvioLocal(this.fecha, "origen", "destino", 1, false);
		this.clienteCorporativo.egregarEnvio(envio);
		this.periodo = new DateLapse1(this.fecha, this.fecha.plusDays(3));
	}
	
	@Test
	void testMontoPagara() {
		assertEquals(1000, this.clienteCorporativo.montoPagara(this.periodo));
		assertNotEquals(1001, this.clienteCorporativo.montoPagara(this.periodo));
		this.periodo = new DateLapse1(this.fecha.plusDays(1), this.fecha.plusDays(3));
		assertEquals(0, this.clienteCorporativo.montoPagara(periodo));
	}
	
}

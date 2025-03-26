package unlp.oo2.practica.ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TijeraTest {

	public Piedra tijera;
	
	@BeforeEach
	void setUp() {
		this.tijera = new Piedra();
	}
	
	@Test
	void testContraPiedra() {
		assertEquals(this.tijera.contraPiedra(), Resultado.Pierdo);
	}
	
	@Test
	void testContraPapel() {
		assertEquals(this.tijera.contraPapel(), Resultado.Gano);
	}
	
	@Test
	void testContraTijera() { 
		assertEquals(this.tijera.contraTijera(), Resultado.Empato);
	}
}

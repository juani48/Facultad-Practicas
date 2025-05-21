package unlp.oo2.practica.ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PiedraTest {

	public Piedra piedra;
	
	@BeforeEach
	void setUp() {
		this.piedra = new Piedra();
	}
	
	@Test
	void testContraPiedra() {
		assertEquals(this.piedra.contraPiedra(), Resultado.Empato);
	}
	
	@Test
	void testContraPapel() {
		assertEquals(this.piedra.contraPapel(), Resultado.Pierdo);
	}
	
	@Test
	void testContraTijera() { 
		assertEquals(this.piedra.contraTijera(), Resultado.Gano);
	}
	
}

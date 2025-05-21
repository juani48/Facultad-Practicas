package unlp.oo2.practica.ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PapelTest {
	
	public Piedra papel;
	
	@BeforeEach
	void setUp() {
		this.papel = new Piedra();
	}
	
	@Test
	void testContraPiedra() {
		assertEquals(this.papel.contraPiedra(), Resultado.Gano);
	}
	
	@Test
	void testContraPapel() {
		assertEquals(this.papel.contraPapel(), Resultado.Empato);
	}
	
	@Test
	void testContraTijera() { 
		assertEquals(this.papel.contraTijera(), Resultado.Pierdo);
	}
}

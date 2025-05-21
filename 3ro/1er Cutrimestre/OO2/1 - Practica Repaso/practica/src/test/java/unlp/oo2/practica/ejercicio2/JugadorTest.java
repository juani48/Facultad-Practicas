package unlp.oo2.practica.ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JugadorTest {

    public Jugador jugador1;
    public Jugador jugador2;
    
    @BeforeEach
    void setUp() {
    	this.jugador1 = new Jugador(new Piedra());
    	this.jugador2 = new Jugador(new Tijera());
    }
    
    @Test
    void testPartido() {
    	assertEquals(this.jugador1.partido(this.jugador2), Resultado.Gano);
    }
    
}

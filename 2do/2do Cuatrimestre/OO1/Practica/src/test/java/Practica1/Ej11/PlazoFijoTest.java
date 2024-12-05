package Practica1.Ej11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlazoFijoTest {

    private PlazoFijo plazoFijo;

    @BeforeEach
    void setUp(){
        this.plazoFijo = new PlazoFijo(10, 1.05);
        
        LocalDate localDate = LocalDate.now().minusDays(1);
        this.plazoFijo.setFechaDeConstitucion(localDate);
    }

    @Test
    void testValorActual(){
        assertEquals(10.5, this.plazoFijo.valorActual());
        assertNotEquals(10, this.plazoFijo.valorActual());
    }

}

package Practica1.Ej23.Pago;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlContadoTest {

    private AlContado alContado;

    @BeforeEach
    void setUp(){
        this.alContado = new AlContado();
    }

    @Test
    void testMontoTotal(){
        assertEquals(100, this.alContado.montoTotal(100));
        assertNotEquals(101, this.alContado.montoTotal(100));
    }

}

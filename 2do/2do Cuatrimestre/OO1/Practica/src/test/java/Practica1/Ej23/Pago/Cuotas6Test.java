package Practica1.Ej23.Pago;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Cuotas6Test {

    private Cuotas6 cuotas6;

    @BeforeEach
    void setUp(){
        this.cuotas6 = new Cuotas6();
    }

    @Test
    void testMontoTotal(){
        assertEquals(120, this.cuotas6.montoTotal(100));
        assertNotEquals(119, this.cuotas6.montoTotal(100));
    }
}

package Practica1.Ej23.Envio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExpressDomicilioTest {

    private ExpressDomicilio expressDomicilio;

    @BeforeEach
    void setUp(){
        this.expressDomicilio = new ExpressDomicilio("direccion1", "direccion2");
    }

    @Test
    void testMontotTotal(){
        assertEquals(100, this.expressDomicilio.montoTotal());
        assertNotEquals(0, this.expressDomicilio.montoTotal());
    }

}

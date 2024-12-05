package Practica1.Ej23.Envio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RetirarComercioTest {

    private RetirarComercio retirarComercio;

    @BeforeEach
    void setUp(){
        this.retirarComercio = new RetirarComercio();
    }

    @Test
    void testMontoTotal(){
        assertEquals(0, this.retirarComercio.montoTotal());
        assertNotEquals(1, this.retirarComercio.montoTotal());
    }
}

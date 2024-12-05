package Practica1.Ej09;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CajaDeAhorroTest {

    private CajaDeAhorro cajaDeAhorro;


    @BeforeEach
    void setUp(){
        cajaDeAhorro = new CajaDeAhorro();
        cajaDeAhorro.depositar(10);
    }

    @Test
    void testExtraer(){
        assertFalse(this.cajaDeAhorro.extraer(9.9));
        assertTrue(this.cajaDeAhorro.extraer(9.8));
        assertEquals(0.0039999999999995595, this.cajaDeAhorro.getSaldo());
    }
}

package Practica1.Ej15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuadroTarifarioTest {

    private CuadroTarifario cuadroTarifario;

    @BeforeEach
    void setUp(){
        this.cuadroTarifario = new CuadroTarifario(100);
    }

    @Test
    void testGetPrecioKWH(){
        assertEquals(100, this.cuadroTarifario.getPrecioKWH());
        assertNotEquals(99.9, this.cuadroTarifario.getPrecioKWH());
    }

    @Test
    void testSetPrecioKWH(){
        assertEquals(100, this.cuadroTarifario.getPrecioKWH());
        this.cuadroTarifario.setPrecioKWH(89.8);
        assertEquals(89.8, this.cuadroTarifario.getPrecioKWH());
    }
}

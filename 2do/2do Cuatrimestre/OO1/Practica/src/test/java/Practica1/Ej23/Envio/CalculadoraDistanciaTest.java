package Practica1.Ej23.Envio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class CalculadoraDistanciaTest {

    @Test
    void testDistanciaEntre(){
        assertEquals(100, CalculadoraDistancia.distanciaEntre("direccion1","direccion2"));
        assertNotEquals(101, CalculadoraDistancia.distanciaEntre("direccion1","direccion2"));
    }

}

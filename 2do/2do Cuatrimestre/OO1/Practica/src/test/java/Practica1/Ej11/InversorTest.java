package Practica1.Ej11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InversorTest {

    private Inversor inversor;

    @BeforeEach
    void setUp(){
        Inversiones valor4 = new InversionesEnAcciones("Inversion 1", 2, 2);
        Inversiones valor6 = new InversionesEnAcciones("Inversion 2", 2,3);
        this.inversor = new Inversor("Juan");
        this.inversor.agregarInversion(valor4);
        this.inversor.agregarInversion(valor6);
    }

    @Test
    void testValorActual(){
        assertEquals(10, this.inversor.valorActual());
        assertNotEquals(9, this.inversor.valorActual());
    }

}

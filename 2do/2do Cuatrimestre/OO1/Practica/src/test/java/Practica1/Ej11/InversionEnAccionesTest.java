package Practica1.Ej11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class InversionEnAccionesTest {

    private InversionesEnAcciones inversionesEnAcciones;

    @Test
    void testValorActualVacio(){
        this.inversionesEnAcciones = new InversionesEnAcciones("Inversion vacia", 0, 1);
        assertEquals(0, this.inversionesEnAcciones.valorActual());
        assertNotEquals(1,this.inversionesEnAcciones.valorActual());
    }

    void testValorActual(){
        this.inversionesEnAcciones = new InversionesEnAcciones("Inversion", 1,1);
        assertEquals(1, this.inversionesEnAcciones.valorActual());
        assertNotEquals(2,this.inversionesEnAcciones.valorActual());
    }

}

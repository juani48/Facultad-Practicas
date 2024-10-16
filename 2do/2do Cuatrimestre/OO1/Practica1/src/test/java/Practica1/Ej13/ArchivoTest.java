package Practica1.Ej13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArchivoTest {

    private Archivo archivo;

    @Test
    void testTamaño1(){
        this.archivo = new Archivo("Archivo");
        assertEquals(7, this.archivo.tamaño());
    }
    @Test
    void testTamaño2(){
        this.archivo = new Archivo("");
        assertEquals(0, this.archivo.tamaño());
    }
}

package Practica1.Ej13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarpetaTest {
    private Carpeta carpeta1;
    private Carpeta carpeta2;

    @BeforeEach
    void setUp(){
        this.carpeta1 = new Carpeta("Carpeta1");
        this.carpeta2 = new Carpeta("Carpeta2");

        Email email = new Email("Titulo", "Cuerpo");
        this.carpeta1.addEmail(email);
    }

    @Test
    void testBuscar(){
        //assertEquals(new Email("Titulo", "Cuerpo"), this.carpeta1.buscar("itu"));
        assertTrue(new Email("Titulo", "Cuerpo").equals(this.carpeta1.buscar("itu")));
        assertNull(this.carpeta2.buscar("itu"));
    }

    @Test
    void testMover1(){
        this.carpeta1.mover(new Email("Titulo", "Cuerpo"), carpeta2);
        assertNull(this.carpeta1.buscar("Titulo"));
        assertTrue(new Email("Titulo", "Cuerpo").equals(this.carpeta2.buscar("itu")));
    }
    
    @Test
    void testMover2(){
        this.carpeta1.mover(new Email("Otro titulo", "Otro cuerpo"), carpeta2);
        assertNull(this.carpeta2.buscar("Titulo"));
        assertTrue(new Email("Titulo", "Cuerpo").equals(this.carpeta1.buscar("itu")));
    }

    @Test
    void testTamaño(){
        assertEquals(8, this.carpeta2.tamaño());
        assertEquals(20, this.carpeta1.tamaño());
    }
}

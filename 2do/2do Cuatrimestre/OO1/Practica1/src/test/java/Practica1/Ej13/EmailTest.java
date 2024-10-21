package Practica1.Ej13;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmailTest {

    private Email email;

    @BeforeEach
    void setUp(){
        this.email = new Email("Titulo", "Cuerpo");
    }

    @Test
    void testBuscar(){
        //assertEquals(new Email("Titulo", "Cuerpo"), this.email.buscar("itu"));
        assertTrue(new Email("Titulo", "Cuerpo").equals(this.email.buscar("itu")));
        assertFalse(new Email("Titulo", "Otro cuerpo").equals(this.email.buscar("rpo")));
        assertNull(this.email.buscar("Otro"));
    }

    @Test
    void testTamaño(){
        Archivo archivo = new Archivo("Archivo");
        assertEquals(12, this.email.tamaño());
        this.email.addAdjunto(archivo);
        assertEquals(19, this.email.tamaño());
    }
}

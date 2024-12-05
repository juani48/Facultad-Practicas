package Practica1.Ej13;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteDeCorreoTest {

    private ClienteDeCorreo clienteDeCorreo;

    @BeforeEach
    void setUp(){
        this.clienteDeCorreo = new ClienteDeCorreo();
    }

    @Test
    void testBuscar(){
        Carpeta carpeta = new Carpeta("Carpeta");
        carpeta.addEmail(new Email("Titulo", "Cuerpo"));
        this.clienteDeCorreo.addCarpeta(carpeta);

        assertTrue(new Email("Titulo", "Cuerpo").equals(this.clienteDeCorreo.buscar("Ti")));
        assertNull(this.clienteDeCorreo.buscar("A"));
    }

    @Test
    void testRecibir(){
        Email email = new Email("Titulo", "Cuerpo");
        this.clienteDeCorreo.recibir(email);
        assertNotNull(this.clienteDeCorreo.buscar("Tit"));
    }

}   

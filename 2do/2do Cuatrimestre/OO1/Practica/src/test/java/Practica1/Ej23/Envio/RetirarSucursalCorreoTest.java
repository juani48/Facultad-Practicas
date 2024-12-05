package Practica1.Ej23.Envio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RetirarSucursalCorreoTest {

    private RetirarSucursalCorreo retirarSucursalCorreo;

    @BeforeEach
    void setUp(){
        this.retirarSucursalCorreo = new RetirarSucursalCorreo();
    }

    @Test
    void testMontoTotal(){
        assertEquals(3000, this.retirarSucursalCorreo.montoTotal());
        assertNotEquals(3001, this.retirarSucursalCorreo.montoTotal());
    }

}

package Practica1.Ej15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    void setUp(){
        this.usuario = new Usuario("Nombre", "Domicilio", new ArrayList<>());
    }

    @Test
    void testUltimoConsumo(){
        assertEquals(null, this.usuario.getUltimoConsumo());

        CuadroTarifario cuadroTarifario = new CuadroTarifario(1);
        Consumo consumo = new Consumo(1, 1, cuadroTarifario);
        this.usuario.addConsumo(consumo);
        assertEquals(consumo, this.usuario.getUltimoConsumo());
        
        Consumo consumo2 = new Consumo(1, 1, cuadroTarifario);
        this.usuario.addConsumo(consumo2);
        assertNotEquals(consumo, this.usuario.getUltimoConsumo());
        assertEquals(consumo2, this.usuario.getUltimoConsumo());
    }

}

package Practica1.Ej12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CilindroTest {

    private Cilindro cilindro;

    @BeforeEach
    void setUp(){
        this.cilindro = new Cilindro("Material", "Color", 2, 1);
    }

    @Test
    void testVolumentMaterial(){
        assertEquals(12.566370614359172, this.cilindro.getVolumenDeMaterial());
        assertNotEquals(12, this.cilindro.getVolumenDeMaterial());
    }

    @Test
    void testSuperficieDeColor(){
        assertEquals(37.69911184307752, this.cilindro.getSuperficieDeColor());
        assertNotEquals(37, this.cilindro.getSuperficieDeColor());
    }
}

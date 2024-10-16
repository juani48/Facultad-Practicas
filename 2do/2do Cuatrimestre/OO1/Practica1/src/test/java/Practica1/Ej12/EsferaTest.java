package Practica1.Ej12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EsferaTest {

    private Esfera esfera;

    @BeforeEach
    void setUp(){
        this.esfera = new Esfera("Material", "Color", 2);
    }

    @Test
    void testVolumenDeMaterial(){
        assertEquals(33.510321638291124, this.esfera.getVolumenDeMaterial());
        assertNotEquals(33, this.esfera.getVolumenDeMaterial());
    }

    @Test
    void testSuperficieDeColor(){
        assertEquals(50.26548245743669, this.esfera.getSuperficieDeColor());
        assertNotEquals(50, this.esfera.getSuperficieDeColor());
    }
}

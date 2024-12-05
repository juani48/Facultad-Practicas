package Practica1.Ej12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PrismaRectangularTest {

    private PrismaRectangular prismaRectangular;

    @BeforeEach
    void setUp(){
        this.prismaRectangular = new PrismaRectangular(
            "Material", "Color", 2, 1, 1);
    }

    @Test
    void testVolumenDeMaterial(){
        assertEquals(2, this.prismaRectangular.getVolumenDeMaterial());
        assertNotEquals(1, this.prismaRectangular.getVolumenDeMaterial());
    }

    @Test
    void testSuperficieDeColor(){
        assertEquals(10, this.prismaRectangular.getSuperficieDeColor());
        assertNotEquals(9, this.prismaRectangular.getSuperficieDeColor());
    }

}

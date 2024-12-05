package Practica1.Ej12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReporteDeConstruccionTest {

    private ReporteDeConstruccion reporteDeConstruccion;

    @BeforeEach
    void setUp(){
        Pieza pieza1 = new Esfera("Material", "Color", 2);
        List<Pieza> list = new ArrayList<>();
        list.add(pieza1);
        this.reporteDeConstruccion = new ReporteDeConstruccion(list);
    }

    @Test
    void testVolumenDeMaterial(){
        assertEquals(25.132741228718345, this.reporteDeConstruccion.getVolumenDeMaterial("Material"));
        assertEquals(0, this.reporteDeConstruccion.getVolumenDeMaterial("Otro material"));
    }

    @Test
    void testSuperficieDeColor(){
        assertEquals(50.26548245743669, this.reporteDeConstruccion.getSuperficieDeColor("Color"));
        assertEquals(0, this.reporteDeConstruccion.getSuperficieDeColor("Otro color"));
    }

}

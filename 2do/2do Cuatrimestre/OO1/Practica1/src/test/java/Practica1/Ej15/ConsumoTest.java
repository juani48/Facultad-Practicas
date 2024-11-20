package Practica1.Ej15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsumoTest {

    private Consumo consumo;

    @BeforeEach 
    void setUp(){
        this.consumo = new Consumo(2,1, new CuadroTarifario(2));
    }

    @Test // minimo activa = 1.334 reactiva = 1 => 0.8001439309
    void testGetMontoFinal(){
        assertEquals(4.4, this.consumo.getMontoFinal());
       this.consumo = new Consumo(1,1, new CuadroTarifario(2));
        assertEquals(5, this.consumo.getMontoFinal());
    }

}

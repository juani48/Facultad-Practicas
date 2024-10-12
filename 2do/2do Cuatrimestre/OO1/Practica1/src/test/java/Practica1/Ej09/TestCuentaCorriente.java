package Practica1.Ej09;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCuentaCorriente {

    private CuentaCorriente cuentaCorriente;

    @BeforeEach
    void setUp(){
        cuentaCorriente = new CuentaCorriente();
        this.cuentaCorriente.depositar(10);
    }

    @Test //Limite descubierto = 0
    void testPuedeExtraer_LDen0(){
        assertFalse(this.cuentaCorriente.extraer(11));
        assertTrue(this.cuentaCorriente.extraer(10));
    }
    @Test //Limite descubierto = -5
    void testPuedeExtraer_LDen5(){
        this.cuentaCorriente.setLimiteDescubierto(-5);
        assertFalse(this.cuentaCorriente.extraer(16));
        assertTrue(this.cuentaCorriente.extraer(15));
    }
}

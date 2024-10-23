package Practica1.Ej17;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Practica1.Ej14a.DateLapse1;
import Practica1.Ej14a.IDateLapse;

public class ReservaTest {

    private Propiedad propiedad;
    private Usuario usuario;
    private IDateLapse periodo;

    @BeforeEach
    void setUp(){
        this.propiedad = new Propiedad("Direccion propiedad", "Propiedad", 2);
        this.usuario = new Usuario("Usuario", 1234, "Direccion usuario");
        this.periodo = new DateLapse1(
            LocalDate.of(1,1,1), 
            LocalDate.of(1,1,5)
        );
        this.propiedad.crearReserva(this.periodo, this.usuario);
    }

    @Test
    void testPrecioNoche(){
        assertEquals(8, this.propiedad.getReservas().get(0).getPrecioNoche(this.periodo));
        assertNotEquals(9, this.propiedad.getReservas().get(0).getPrecioNoche(this.periodo));
    }

}

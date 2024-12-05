package Practica1.Ej17;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Practica1.Ej14a.DateLapse1;
import Practica1.Ej14a.IDateLapse;

public class PropiedadTest {

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
    void testCrearReservaMismoPerido(){
        // Compurebo que tenga una reserva
        assertEquals(1, this.propiedad.getReservas().size());
    
        // Intento agregar un reserva nueva en el mismo periodo
        this.propiedad.crearReserva(this.periodo, this.usuario);

        // Comrpuebo de que no se agrego
        assertEquals(1, this.propiedad.getReservas().size());
    }

    @Test
    void testCrearReservaDiferentePerido(){
        // Compurebo que tengan una reserva
        assertEquals(1, this.propiedad.getReservas().size());

        // Intento agregar un reserva nueva en el otro periodo
        this.propiedad.crearReserva(new DateLapse1(
            LocalDate.of(1, 2, 1),
            LocalDate.of(1, 2, 5))
            , this.usuario
        );

        // Comrpuebo de que se agrego
        assertEquals(2, this.propiedad.getReservas().size());

        // Compruebo que tegan las mismas reservas
        assertTrue(this.propiedad.getReservas().get(0).equals(this.usuario.getReservas().get(0)));
        assertTrue(this.propiedad.getReservas().get(1).equals(this.usuario.getReservas().get(1)));
    }


    @Test
    void testDisponibilidad(){
        // Compruebo que no este disponible en el mismo periodo
        assertFalse(this.propiedad.diponibilidad(this.periodo));

        IDateLapse periodo = new DateLapse1(LocalDate.of(1, 2, 1), LocalDate.of(1, 2, 5));
        assertTrue(this.propiedad.diponibilidad(periodo));
    }

    @Test
    void testMontoTotal(){
        assertEquals(8, this.propiedad.getMontoTotal(this.periodo));
        assertNotEquals(9, this.propiedad.getMontoTotal(this.periodo));
    }
}

package Practica1.Ej17;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Practica1.Ej14a.DateLapse1;
import Practica1.Ej14a.IDateLapse;

public class UsuarioTest {

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
    }

    @Test
    void testAgregarReserva(){
        // Compruebo que no tenga reservas
        assertEquals(0, this.usuario.getReservas().size());

        // Agrego una reserva
        this.propiedad.crearReserva(this.periodo, this.usuario);

        // Comrpuebo que se agrego
        assertEquals(1, this.usuario.getReservas().size());

        // Compruebo que tengan la misma
        assertTrue(this.usuario.getReservas().get(0).equals(this.propiedad.getReservas().get(0)));
    }

    @Test
    void testCancelarReserevaNoActiva(){
        // Agrego una reserva no activa
        this.propiedad.crearReserva(this.periodo, this.usuario);

        // Cancelo la reserva
        this.usuario.cancelarReserva(this.usuario.getReservas().get(0));

        // Compruebo que se cancelo
        assertEquals(0, this.usuario.getReservas().size());
    }

    @Test
    void testCancelarReserevaActiva(){
        // Agrego una reserva activa
        this.propiedad.crearReserva(new DateLapse1(
            LocalDate.now(), LocalDate.now().plusDays(2)), 
            this.usuario
        );

        // Cancelo la reserva
        this.usuario.cancelarReserva(this.usuario.getReservas().get(0));

        // Compruebo que no se cancelo
        assertEquals(1, this.usuario.getReservas().size());
    }
}

package Practica1.Ej17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Practica1.Ej14a.DateLapse1;
import Practica1.Ej14a.IDateLapse;

public class PropiedtarioTest {

    private Propietario propietario;
    private Propiedad propiedad;
    private Usuario usuario;
    private IDateLapse periodo;

    @BeforeEach
    void setUp(){
        this.propiedad = new Propiedad("Direccion propiedad", "Propiedad", 2);
        this.usuario = new Usuario("Usuario", 1234, "Direccion usuario");
        this.propietario = new Propietario("Propietario", 4321);
        this.propietario.agreagrPropiedad(this.propiedad);
        this.periodo = new DateLapse1(
            LocalDate.of(1,1,1), 
            LocalDate.of(1,1,5)
        );
        this.propiedad.crearReserva(this.periodo, this.usuario);
    }

    @Test
    void testCalcularRetribucion(){
        assertEquals(8*0.75, this.propietario.calcularRetribucion(this.periodo));
    }

}

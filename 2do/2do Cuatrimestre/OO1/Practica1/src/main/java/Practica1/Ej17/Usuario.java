package Practica1.Ej17;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona {

    private String direccion;
    private List<Reserva> reservas;

    public Usuario(String nombre, int dni, String direccion) {
        super(nombre, dni);
        this.direccion = direccion;
        this.reservas = new ArrayList<>();
    }

    public List<Reserva> getReservas(){
        return this.reservas;
    }

    public void agregarReserva(Reserva reserva){
        this.getReservas().add(reserva);
    }

    public boolean cancelarReserva(Reserva reserva){
        Reserva aux = this.getReservas().stream().filter(x -> x.equals(reserva) && x.isActivo() == false).findFirst().orElse(null);
        if(aux != null){
            aux.cancelar();
            this.getReservas().remove(aux);
            return true;
        }
        return false;
    }

}

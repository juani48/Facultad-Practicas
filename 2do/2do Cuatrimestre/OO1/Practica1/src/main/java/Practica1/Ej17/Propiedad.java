package Practica1.Ej17;

import java.util.ArrayList;
import java.util.List;

import Practica1.Ej14a.IDateLapse;

public class Propiedad {

    private String direccion;
    private String nombre;
    private double precio;
    private List<Reserva> reservas;

    public Propiedad(String direccion, String nombre, double precio){
        this.direccion = direccion;
        this.nombre = nombre;
        this.precio = precio;
        this.reservas = new ArrayList<>();
    }

    public String getDireccion(){
        return this.direccion;
    }
    public String getNombre(){
        return this.nombre;
    }

    public boolean equals(Propiedad propiedad){
        return this.getNombre().equals(propiedad.getNombre()) && this.getDireccion().equals(propiedad.getDireccion());
    }

    public double getPrecio(){
        return this.precio;
    }

    public double getMontoTotal(IDateLapse periodo){
        return this.getReservas().stream().mapToDouble(x -> x.getPrecioNoche(periodo)).sum();
    }

    public List<Reserva> getReservas(){
        return this.reservas;
    }

    public boolean diponibilidad(IDateLapse periodo){
        return this.getReservas().stream().noneMatch(r -> r.getPeriodo().includesDate(periodo));
    }

    public boolean crearReserva(IDateLapse periodo, Usuario usuario){
        if(this.diponibilidad(periodo)){
            Reserva reserva = new Reserva(periodo, usuario, this);
            this.getReservas().add(reserva);
            usuario.agregarReserva(reserva);
            return true;
        }
        return false;
    }

    public void cancelar(Reserva reserva){
        this.getReservas().remove(reserva);
    }
}

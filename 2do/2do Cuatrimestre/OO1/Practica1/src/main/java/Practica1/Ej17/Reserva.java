package Practica1.Ej17;

import Practica1.Ej14a.IDateLapse;

public class Reserva {

    private IDateLapse periodo;
    private Usuario usuario;
    private Propiedad propiedad;

    public Reserva(IDateLapse periodo, Usuario usuario, Propiedad propiedad){
        this.periodo = periodo;
        this.usuario = usuario;
        this.propiedad = propiedad;
    }

    public boolean equals(Reserva reserva){
        return this.getPropiedad().equals(reserva.getPropiedad());
    }

    public Propiedad getPropiedad(){
        return this.propiedad;
    }

    public IDateLapse getPeriodo(){
        return this.periodo;
    }

    public boolean isActivo(IDateLapse periodo){
        return this.getPeriodo().includesDate(periodo);
    }

    public Usuario usuario(){
        return this.usuario;
    }

    public double getPrecioNoche(IDateLapse perido){
        if(this.isActivo(perido)){
            return this.getPropiedad().getPrecio() * this.getPeriodo().sizeInDays();
        }
        return 0;
    }

    public void cancelar(){
        this.getPropiedad().cancelar(this);
    }

}

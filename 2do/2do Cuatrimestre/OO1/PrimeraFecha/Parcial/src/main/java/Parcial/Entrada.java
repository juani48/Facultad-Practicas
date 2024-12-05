package PrimeraFecha.Parcial.src.main.java.Parcial;

import java.time.LocalDate;

public class Entrada {

    private LocalDate fechaCompra;
    private boolean seguro;
    private Evento evento;

    public Entrada(Evento evento, boolean seguro){
        this.evento = evento;
        this.fechaCompra = LocalDate.now();
        this.seguro = seguro;
    }

    public Evento getEvento(){ return this.evento; }
    public boolean getSeguro(){ return this.seguro; }
    public LocalDate getFechaCompra(){ return this.fechaCompra; }

   public double montoDevolucion(){
        double aux = 0;
        if(this.getEvento().dias(this.getFechaCompra()) >= 30){
            aux += this.getEvento().precioAsistencia(this.getFechaCompra()) * 0.5;
        }
        if(this.getSeguro()){
            aux += this.getEvento().precioAsistencia(this.getFechaCompra()) * 0.15;
        }
        return aux;
   }    

    public double montoTotal(){
        double aux = this.getEvento().precioAsistencia(this.getFechaCompra());
        if(this.getSeguro()){
            aux += 500;
        } 
        return aux;
    }
    
    public boolean between(LocalDate inicio, LocalDate fin){
        return this.getFechaCompra().isBefore(inicio) && this.getFechaCompra().isAfter(fin);
    }

    public int dias(LocalDate fecha){
        return this.getEvento().dias(fecha);
    }
}

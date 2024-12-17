package RedictadoTercera2024.parcial.src.main.java.parcial.parcial;

import java.time.LocalDate;

public class Oferta implements IEstrategia {

    private LocalDate fechaLimite;
    private double descuento;

    public Oferta(LocalDate fechaLimite, double descuento){
        this.descuento = descuento;
        this.fechaLimite = fechaLimite;
    }

    public LocalDate getFechaLimite(){ return this.fechaLimite; }
    public double getDescuento(){ return this.descuento; }

    private boolean descuento(){ return this.getFechaLimite().isEqual(LocalDate.now()); }


    @Override
    public double costoCompra() {
       if(!this.descuento()){ return this.getDescuento(); }
       return 1;
    }

    @Override
    public int puntos() {
        if(!this.descuento()){
            return 5;
        }
        return 10;
    }

}

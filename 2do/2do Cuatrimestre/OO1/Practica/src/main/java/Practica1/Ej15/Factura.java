package Practica1.Ej15;

import java.time.LocalDate;

public class Factura {

    @SuppressWarnings("unused")
    private LocalDate fechaEmision;
    @SuppressWarnings("unused")
    private boolean bonificacion;
    @SuppressWarnings("unused")
    private double montoFinal;
    @SuppressWarnings("unused")
    private Usuario usuario;

    public Factura(){
        this.fechaEmision = LocalDate.now();
        
    }

}

package Practica1.Ej15;

import java.time.LocalDate;

public class Factura {

    private LocalDate fechaEmision;
    private boolean bonificacion;
    private double montoFinal;
    private Usuario usuario;

    public Factura(){
        this.fechaEmision = LocalDate.now();
        
    }

}

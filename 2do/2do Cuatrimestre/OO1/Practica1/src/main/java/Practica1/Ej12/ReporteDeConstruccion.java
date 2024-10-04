package Practica1.Ej12;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {

    private List<IPieza> piezas;

    public ReporteDeConstruccion(){
        this.piezas = new ArrayList<>();
    }

    private List<IPieza> getPeizas(){
        return this.piezas;
    }

    public double getVolumenDeMaterial(String mateiral){
        return this.getPeizas().stream().mapToDouble(x -> x.getVolumenDeMaterial(mateiral)).sum();
    }

}

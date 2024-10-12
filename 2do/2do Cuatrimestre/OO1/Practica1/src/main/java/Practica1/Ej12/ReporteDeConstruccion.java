package Practica1.Ej12;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {

    private List<Pieza> piezas;

    public ReporteDeConstruccion(List<Pieza> list){
        this.piezas = new ArrayList<>(list);
    }

    private List<Pieza> getPeizas(){
        return this.piezas;
    }

    public double getVolumenDeMaterial(String material){
        return this.getPeizas().stream().filter(x -> x.getMaterial() == material).mapToDouble(x -> x.getVolumenDeMaterial()).sum();
    }

    public double getSuperficieDeColor(String color){
        return this.getPeizas().stream().filter(x -> x.getColor() == color).mapToDouble(x -> x.getSuperficieDeColor()).sum();
    }

}

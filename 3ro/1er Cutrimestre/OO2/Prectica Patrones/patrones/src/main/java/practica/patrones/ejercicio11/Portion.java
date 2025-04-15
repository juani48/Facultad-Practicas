package main.java.practica.patrones.ejercicio11;
//package practica.patrones.ejercicio11;

import java.util.ArrayList;
import java.util.List;

public abstract class Portion {
    private double waterPortion;

    public Portion(double waterPortion){ this.waterPortion = waterPortion; }
    
    public double getWaterPortion() { return waterPortion; }
    public List<Portion> getPortions(){ return new ArrayList<Portion>(); }
    
    public double calculatePortion(){ return this.getWaterPortion(); }
    public boolean equals(Portion portion){ return this.getWaterPortion() == portion.getWaterPortion(); }
}

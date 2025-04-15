package main.java.practica.patrones.ejercicio11;
//package practica.patrones.ejercicio11;

import java.util.ArrayList;
import java.util.List;

public abstract class Portion {
    private double waterPortion;

    public Portion(double waterPortion){
         this.waterPortion = waterPortion; }
    
    public double getWaterPortion() { return waterPortion; }    
    public double calculatePortion(){ return this.getWaterPortion(); }

    // EL equals pregunta por instansof y creo un metodo polimorfico
    public boolean equals(Portion portion){ return portion.equals(this); }

    public abstract boolean equals(Dirth dirth);
    public abstract boolean equals(Water water);
    public abstract boolean equals(MixPortion mixPortion);
}

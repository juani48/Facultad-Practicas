package main.java.practica.patrones.ejercicio11;

import java.util.List;

public class MixPortion extends Portion{
    private List<Portion> portions;

    public MixPortion(List<Portion> portions){
        super(1.1);
        if(portions.size() <= 4){
            this.portions = portions;
        }
        throw new Exception("Numero maximo de porciones superado.");
    }

    @Override
    public List<Portion> getPortions(){ return this.portions; }

    @Override
    public double calculatePortion(){
        return this.getPortions().stream().mapToDouble(x -> x.calculatePortion()).average();
    }

    @Override
    public boolean equals(Portion portion){
        return this.getPortions().equals(portion.getPortions());
    }
}

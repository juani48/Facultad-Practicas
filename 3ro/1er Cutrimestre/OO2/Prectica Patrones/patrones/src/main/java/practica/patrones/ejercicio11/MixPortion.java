package main.java.practica.patrones.ejercicio11;

import java.util.List;

public class MixPortion extends Portion{
    private List<Portion> portions;

    public MixPortion(List<Portion> portions){
        super(1.1);
        this.portions = portions; //asumo que la comprobacion se realiza antes :)
    }

    public List<Portion> getPortions(){ return this.portions; }

    @Override
    public double calculatePortion(){
        return this.getPortions().stream().mapToDouble(x -> x.calculatePortion()).average();
    }

    @Override
    public boolean equals(Water water){ return false; }

    @Override
    public boolean equals(Dirth dirth){ return false; }

    @Override
    public boolean equals(MixPortion mixPortion){
        return this.getPortions().equals(portion.getPortions()); 
    }
}

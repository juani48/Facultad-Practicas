package main.java.practica.patrones.ejercicio11;

public class Dirth extends Portion{

    public Dirth() { super(0); }

    @Override
    public boolean equals(Water water){
        return false;
    }

    @Override
    public boolean equals(Dirth dirth){
        return true;
    }

    @Override
    public boolean equals(MixPortion mixPortion){
        return false;
    }

}

package main.java.practica.patrones.ejercicio11;

//package practica.patrones.ejercicio11;

public class Water extends Portion{

    public Water() { super(1); }

    @Override
    public boolean equals(Water water){
        return true;
    }

    @Override
    public boolean equals(Dirth dirth){
        return false;
    }

    @Override
    public boolean equals(MixPortion mixPortion){
        return false;
    }

}

package Practica1.Ej12;

public abstract class Pieza implements IPieza {

    private String mateiral;
    private String color;

    public Pieza(String material, String color){
        this.mateiral = material;
        this.color = color;
    }

    public String getMaterial(){
        return this.mateiral;
    }

    public String getColor(){
        return this.color;
    }
}

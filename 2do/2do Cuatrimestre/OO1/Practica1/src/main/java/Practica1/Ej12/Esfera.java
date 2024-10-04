package Practica1.Ej12;

public class Esfera extends Pieza {

    private int radio;

    public Esfera(String material, String color, int radio){
        super(material, color);
        this.radio = radio;
    }

    private int getRadio(){
        return this.radio;
    }

    @Override
    public double getVolumenDeMaterial(String mateiral) {
        return (4/3) * Math.PI * Math.pow(this.getRadio(), 3);
    }

    @Override
    public double getSuperficieDeColor(String mateiral) {
        return 4 * Math.PI * Math.pow(this.getRadio(), 2);     
    }

}

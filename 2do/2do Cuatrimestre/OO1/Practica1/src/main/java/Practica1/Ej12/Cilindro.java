package Practica1.Ej12;

public class Cilindro extends Pieza{

    private int radio;
    private int altura;

    public Cilindro(String material, String color, int radio, int altura ){
        super(material, color);
        this.altura = altura;
        this.radio = radio;
    }

    private int getRadio(){
        return this.radio;
    }

    private int getAltura(){
        return this.altura;
    }

    @Override
    public double getVolumenDeMaterial(String mateiral) {
        return Math.PI * Math.pow(this.getRadio(), 2) * this.getAltura();
    }

    @Override
    public double getSuperficieDeColor(String mateiral) {
        return 2 * Math.PI * this.getRadio() * this.getAltura() + 2 * Math.PI * Math.pow(this.getRadio(), 2);
    }
    
}

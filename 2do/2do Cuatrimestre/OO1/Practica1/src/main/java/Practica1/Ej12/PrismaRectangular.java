package Practica1.Ej12;

public class PrismaRectangular extends Pieza{

    private int ladoMayor;
    private int ladoMenor;
    private int altura;

    public PrismaRectangular(String material, String color, int ladoMayor, int ladoMenor, int altura){
        super(material, color);
        this.ladoMayor = ladoMayor;
        this.ladoMenor = ladoMenor;
        this.altura = altura;
    }

    private int getLadoMayor(){
        return this.ladoMayor;
    }

    private int getLadoMenor(){
        return this.ladoMenor;
    }

    private int getAltura(){
        return this.altura;
    }

    @Override
    public double getVolumenDeMaterial(String mateiral) {
       return this.getAltura() * this.getLadoMayor() * this.getLadoMenor();
    }

    @Override
    public double getSuperficieDeColor(String mateiral) {
        return 2 * (this.getLadoMayor() * this.getLadoMenor() + this.getLadoMayor() * this.getAltura() + this.getLadoMenor());
    }
    
}

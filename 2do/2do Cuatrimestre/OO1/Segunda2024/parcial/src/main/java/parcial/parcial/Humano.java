package Segunda2024.parcial.src.main.java.parcial.parcial;

public class Humano extends Personaje {

    public Humano(String nombre, IRol rol){
        super(nombre, 1, 1, 2, rol);
    }

    @Override
    public void subirNivel() {
        super.subirNivel();
        if(this.getNivel() >= 7){
            this.getRol().incremento(this);
        }
    }

    @Override
    public int poder(int hora) {
        int poder = this.getRol().valorBase(this);
        if(this.esDia(hora)){
            poder *= 1.4;
        }
        return poder;
    }
}

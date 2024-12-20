package Segunda2024.parcial.src.main.java.parcial.parcial;

import java.util.List;

public abstract class Personaje {

    private String nombre;
    private int nivel;
    private int fuerza;
    private int inteligencia;
    private IRol rol;

    public Personaje(String nombre, int nivel, int fuerza, int inteligencia, IRol rol){
        this.nombre = nombre;
        this.nivel = nivel;
        this.fuerza = fuerza;
        this.inteligencia = inteligencia;
        this.rol = rol;
    }

    public int getNivel(){ return this.nivel; }
    public int getFuerza(){ return this.fuerza; }
    public int getInteligencia(){ return this.inteligencia; }
    public IRol getRol(){ return this.rol; }

    public void setFuerza(int fuerza){ this.fuerza = fuerza; }
    public void setInteligencia(int inteligencia){this.inteligencia = inteligencia; }
    public void setRol(IRol rol){ this.rol = rol;}

    protected boolean esDia(int hora){
        return hora >= 8 && hora <= 20;
    }

    public void subirNivel(){ this.nivel++; }
    public abstract int poder(int hora);

    protected boolean emparejar(int nivel, Personaje personaje){
        if(this.getNivel() == nivel){
            return personaje.poder(12) < 5;
        }
        return Math.abs(this.getNivel() - nivel) >= 2;
    }

    public void enfrentar(Personaje personaje, int hora){
        int p1 = this.poder(hora);
        int p2 = personaje.poder(hora);
        if(p1 > p2){ this.subirNivel(); }
        else if(p2 > p1){ personaje.subirNivel(); }
        else {this.subirNivel(); personaje.subirNivel(); }
    }

    public List<Personaje> oponentes(List<Personaje> list){
        return list.stream()
            .filter(x -> x.emparejar(this.getNivel(), this))
            .toList();
    }

}

package Practica1.Ej13;

import java.util.ArrayList;
import java.util.List;

public class Email {

    private String titulo;
    private String cuerpo;
    private List<Archivo> adjuntos;
    
    public Email(String titulo, String cuerpo){
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.adjuntos = new ArrayList<>();
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getCuerpo(){
        return this.cuerpo;
    }

    public List<Archivo> getAdjuntos(){
        return this.adjuntos;
    }

    public Email buscar(String texto){
        if (this.getCuerpo().contains(texto) && this.getTitulo().contains(texto)){
            return this;
        }
        return null;
    }

    public int tamaño(){
        return this.getCuerpo().length() + this.getTitulo().length() + this.getAdjuntos().stream()
        .mapToInt(x -> x.tamaño()).sum();
    }
}

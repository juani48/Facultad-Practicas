package Practica1.Ej13;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {

    private String nombre;
    private List<Email> emails;

    public Carpeta(String nombre){
        this.nombre = nombre;
        this.emails = new ArrayList<>();
    }

    public String getNombre(){
        return this.nombre;
    }

    private List<Email> getEmails(){
        return this.emails;
    }

    public void addEmail (Email email){
        this.getEmails().add(email);
    }

    public void mover(Email email, Carpeta carpeta){
        Email aux = this.getEmails().stream().filter(x -> x.equals(email)).findFirst().orElse(null);
        if (aux != null){
            this.getEmails().remove(aux);
            carpeta.addEmail(aux);
        }
    }

    public Email buscar (String texto){
        return this.getEmails().stream().map(x -> x.buscar(texto)).findFirst().get();
    }

    public int tamaño(){
        return this.getEmails().stream().mapToInt(x -> x.tamaño()).sum() + this.getNombre().length();
    }
}

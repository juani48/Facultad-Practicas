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

    private void add (Email email){
        this.getEmails().add(email);
    }

    public void mover(Email email, Carpeta carpeta){
        carpeta.add(this.getEmails().stream().filter(x -> x.equals(email)).findFirst().get());
    }

    public Email buscar (String texto){
        return this.getEmails().stream().filter(x -> x.buscar(texto) != null).findFirst().orElse(null);
    }
}

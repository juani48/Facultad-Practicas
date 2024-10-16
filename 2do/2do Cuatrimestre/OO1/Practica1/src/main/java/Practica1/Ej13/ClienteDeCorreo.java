package Practica1.Ej13;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {
    
    private Carpeta inbox;
    private List<Carpeta> carpetas;
    
    public ClienteDeCorreo(){
        this.inbox = new Carpeta("Inbox");
        this.carpetas = new ArrayList<>();
    }

    private Carpeta getInbox(){
        return this.inbox;
    }

    private List<Carpeta> getCarpetas(){
        return this.carpetas;
    }

    public void addCarpeta(Carpeta carpeta){
        this.getCarpetas().add(carpeta);
    }
    
    public void recibir(Email email){
        this.getInbox().addEmail(email);
    }

    public Email buscar(String texto){
        Email aux = this.getInbox().buscar(texto);
        if(aux != null){
            return aux;
        }
        return this.getCarpetas().stream().map(x -> x.buscar(texto)).findFirst().get();
    }

    public int espacioOcupado(){
        return this.getCarpetas().stream().mapToInt(x -> x.tamaño()).sum();
    }

    public void mover(Carpeta origen, Carpeta destino, Email email){
        this.getCarpetas().stream()
        .filter(x -> x.getNombre() == origen.getNombre())
        .findFirst().get().mover(email, destino);
    }
}

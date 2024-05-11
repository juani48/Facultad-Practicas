/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica3_2;

/**
 *
 * @author Guada
 */
public class Estante {
    String[] libros = new String[20]; //definir los libros como otro objeto
    int dl;

    public String[] getLibros() {
        return libros;
    }

    public void setLibros(String[] libros) {
        this.libros = libros;
    }

    public int getDl() {
        return dl;
    }

    public void setDl(int dl) {
        this.dl = dl;
    }
    
    public Estante(){
        this.setDl(0);
        String[] aux = new String[20]; 
        for(int i = 0; i < 20; i++)
            aux[i] = "sin libro";
        this.setLibros(aux);
    }
    
    public boolean estanteLleno(){
        if( this.getDl() < 20)
            return false;
        else {
            System.out.println("El estanta esta lleno");
            return true;
        }
    }
    
    public void agregarLibro(String nombreLibro){
       if (!this.estanteLleno()){
        int i = this.getDl();
        i =+ 1;
        this.setDl(i);
        String[] aux = this.getLibros(); 
        aux[i] = nombreLibro;
        }
       else
           System.out.println("No es posible agregar un libro nuevo");
    }
    
    public int totlaLibros(){
        return getDl();
    }
    
    public String buscarLibro(String unLibro){
        int dl = this.getDl();
        String[] aux = this.getLibros();
        while((dl > -1)&&(aux[dl] != unLibro))
            dl--;
        if(aux[dl] == unLibro){
            return unLibro;
        }
        else
            return "El libro buscado no existe";
    }
}

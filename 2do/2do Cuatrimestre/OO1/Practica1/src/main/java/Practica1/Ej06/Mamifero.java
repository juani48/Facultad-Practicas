package Practica1.Ej06;

import java.time.LocalDate;

public class Mamifero {

    private String identificador;
    private String especie;
    private LocalDate fechaNacimiento;

    private Mamifero padre;
    private Mamifero madre;

    public Mamifero(String identificador){
        this.identificador = identificador;
        this.madre = null;
        this.padre = null;
    }

    public Mamifero(){
    	this.madre = null;
        this.padre = null;
    }

    public String getIdentificador(){
        return this.identificador;
    }
    
    public void setIdentificador(String identificador){
        this.identificador = identificador;
    }

    public String getEspecie(){
        return this.especie;
    }

    public void setEspecie(String especie){
        this.especie = especie;
    }

    public LocalDate getFechaNacimiento(){
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public Mamifero getPadre(){
        return this.padre;
    }

    public void setPadre(Mamifero padre){
        this.padre = padre;
    }

    public Mamifero getMadre(){
        return this.madre;
    }

    public void setMadre(Mamifero madre){
        this.madre = madre;
    }

    public Mamifero getAbueloMaterno(){
        if(this.getMadre() != null) {
        	return this.getMadre().getPadre();
        }
        else {
        	return null;
        }	
    }

    public Mamifero getAbuelaMaterna(){ 
    	if(this.getMadre() != null) {
        	return this.getMadre().getMadre();
        }
        else {
        	return null;
        }	
    }

    public Mamifero getAbueloPaterno(){
    	if(this.getPadre() != null) {
        	return this.getPadre().getPadre();
        }
        else {
        	return null;
        }	
    }

    public Mamifero getAbuelaPaterna(){
    	if(this.getPadre() != null) {
        	return this.getPadre().getMadre();
        }
        else {
        	return null;
        }	
    }

    public boolean equals(Mamifero mamifero){
        return this.getIdentificador() == mamifero.getIdentificador();
    }

    public boolean tieneComoAncestroA(Mamifero ancestro){
        boolean ok = false;
        if(this.getMadre() != null && !ok){
        	ok = this.getMadre().equals(ancestro) || this.getMadre().tieneComoAncestroA(ancestro);
        }
        if(this.getPadre() != null && !ok){
        	ok = this.getPadre().equals(ancestro) || this.getPadre().tieneComoAncestroA(ancestro);	
        }
        return ok;
    }
}

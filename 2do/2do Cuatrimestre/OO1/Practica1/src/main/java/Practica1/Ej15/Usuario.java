package Practica1.Ej15;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nombre;
    private String domicilio;
    private List<Consumo> consumos;

    public Usuario(String nombre, String domicilio, List<Consumo> consumos){
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.consumos = new ArrayList<>(consumos);
    }

    public List<Consumo> getConsumos(){
        return this.consumos;
    }

    public void addConsumo(Consumo consumo){
        this.getConsumos().add(consumo);
    }

    public Consumo getUltimoConsumo(){
        if(this.getConsumos().size() != 0){
            return this.getConsumos().get(this.getConsumos().size() - 1);
        }
        return null;
    }

}

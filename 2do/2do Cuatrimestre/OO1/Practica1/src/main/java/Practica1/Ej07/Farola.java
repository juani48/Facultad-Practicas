package Practica1.Ej07;

import java.util.ArrayList;
import java.util.List;

public class Farola {
    
    private boolean state;
    private List<Farola> farolas;

    public Farola(){
        this.state = false;
        this.farolas = new ArrayList<Farola>();
    }

    public void pairWithNeighbor(Farola farola){
        this.getNeighbors().add(farola);
        farola.getNeighbors().add(this);
    }

    public boolean isOn(){
        return this.state == true;
    }

    public boolean isOff(){
        return this.state == false;
    }

    public List<Farola> getNeighbors(){
        return this.farolas;
    }

    public void turnOn(){
        if(this.isOff()){
            this.state = true;
            for(Farola x : this.getNeighbors()){
                x.turnOn();
            }
        }
    }

    public void turnOff(){
        if(this.isOn()){
            this.state = false;
            for(Farola x : this.getNeighbors()){
                x.turnOff();
            }
        }
    }

}

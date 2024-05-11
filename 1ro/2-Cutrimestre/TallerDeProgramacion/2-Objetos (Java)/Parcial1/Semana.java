/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;

/**
 *
 * @author Guada
 */
public class Semana {
    private Paciente[][] semana;

    public Paciente[][] getSemana() {
        return semana;
    }

    private void setSemana(Paciente[][] semana) {
        this.semana = semana;
    }
    
    public Semana(){
        Paciente[][] aux = new Paciente[6][5];
        int i,j;
        for(i = 0; i < 5; i++){
            for(j = 0; j < 6; j++)
                aux[j][i] = null;
        }
        this.setSemana(aux);
    }
    public void agregarTurno(Paciente paciente, int dia, int turno){
        Paciente[][] aux = this.getSemana();
        aux[turno-1][dia-1] = paciente;
        this.setSemana(aux);
    }
    public void liberarTurnos(String nombre){
        Paciente[][] aux = this.getSemana();
        int i,j;
        for(i = 0; i < 5; i++){
            for(j = 0; j < 6; j++){
                if(aux[j][i].getNombre() == nombre)
                    aux[j][i] = null;
            }
        }
        this.setSemana(aux);
    }
    public boolean tieneTurno(String nombre){
        int i = 0, j =0;
        Paciente[][] aux = this.getSemana();
        while((i < 5)&&(aux[j][i].getNombre() != nombre)){
            j = 0;
            while((j < 6)&&(aux[j][i].getNombre() != nombre))
                j++;
            i++;
        }
        if(aux[j][i].getNombre() == nombre)
            return true;
        else
            return false;
    }
    
}

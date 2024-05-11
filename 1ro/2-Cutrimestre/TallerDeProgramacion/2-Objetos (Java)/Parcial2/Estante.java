/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

/**
 *
 * @author Guada
 */
public class Estante {
    private Libro[][] estante;
    private int cantEstantes;
    private int cantLibros;

    public Libro[][] getEstante() {
        return estante;
    }

    private void setEstante(Libro[][] estante) {
        this.estante = estante;
    }

    public int getCantEstantes() {
        return cantEstantes;
    }

    private void setCantEstantes(int cantEstantes) {
        this.cantEstantes = cantEstantes;
    }

    public int getCantLibros() {
        return cantLibros;
    }

    private void setCantLibros(int cantLibros) {
        this.cantLibros = cantLibros;
    }
    
    public Estante(int estantes, int lugares){
        this.setCantEstantes(estantes);
        this.setCantLibros(lugares);
        Libro[][] aux = new Libro[estantes][lugares];
        int i,j;
        for(i = 0; i < estantes; i++){
            for(j = 0; j < lugares; j++){
                aux[i][j] = null;
            }
        }
        this.setEstante(aux);
    }
    public void agregarLibro(Libro libro, int estante, int lugar){
        if((estante <= this.getCantEstantes())&&(lugar <= this.getCantLibros())){
            Libro[][] aux = this.getEstante();
            aux[estante-1][lugar-1] = libro;
            this.setEstante(aux);
        }
    }
    public Libro sacarLibro(String nombre){
        Libro[][] aux = this.getEstante();
        int i = 0, j = 0;
        while((i < this.getCantEstantes())&&(aux[i][j].getNombre() != nombre)){
            j = 0;
            while((j < this.getCantLibros())&&(aux[i][j].getNombre() != nombre))
                j++;
            i++;
        }
        if(aux[i][j].getNombre() == nombre){
            Libro libro = aux[i][j];
            aux[i][j] = null;
            return libro;
        }
        else
            return null;
    }
    public Libro calcular(){
        Libro[][] aux = this.getEstante();
        double max = -1;
        int i, j, maxEstante =0, maxLugar=0;
        for(i = 0; i < this.getCantEstantes(); i++){
            for(j = 0; j < this.getCantLibros(); j++){
                if(aux[i][j].getPeso() > max){
                    max = aux[i][j].getPeso();
                    maxEstante = i;
                    maxLugar = j;
                }
            }
        }
        return aux[maxEstante][maxLugar];
    }
}

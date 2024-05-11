
package practica4;

/**
 *
 * @author Alumno
 */
public class Estacion {
    private String nombre;
    private double latitud;
    private double longitud;
    
    private double[][] años;
    private int añoInicio;
    private int cantidadAños;
    
    private double temperaturaBase = 60.0;
            
    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    private void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    private void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getAñoInicio() {
        return añoInicio;
    }

    private void setAñoInicio(int añoInicio) {
        this.añoInicio = añoInicio;
    }

    public int getCantidadAños() {
        return cantidadAños;
    }

    private void setCantidadAños(int cantidadAños) {
        this.cantidadAños = cantidadAños;
    }
    
    public double[][] getAños(){
        return años;
    }
    
    public Estacion (String nombre, double latitud, double longitud, int añoInicio, int cantidadAños){
        this.setNombre(nombre);
        this.setLatitud(latitud);
        this.setLongitud(longitud);
        this.setAñoInicio(añoInicio);
        this.setCantidadAños(cantidadAños);
        this.años = new double[12][cantidadAños];
        int c , f; 
        for(c = 0; c < cantidadAños; c++){
            for(f = 0; f < 12; f++)
                años[f][c] = 0; 
        }
        
    }
    
    public double getTemperaturaBase(){
        return temperaturaBase;
    }
    
    public void setTemperatura(int columna, int fila, double temperatura){
        años[fila-1][columna - this.getAñoInicio()] = temperatura;
    }
    
    public double getTemperatura(int columna, int fila){
        if(años[fila-1][columna- this.getAñoInicio()] != 0)
            return años[fila - 1][columna - this.getAñoInicio()];
        else
            return this.getTemperaturaBase();
    }
    
    private String temperaturaMax(){
        int f, c, fMax = 0,cMax = 0;
        double temperaturaMax = -1.0;
        for(c = 0; c < this.getCantidadAños(); c++){
            for(f =0; f < 12; f++){
                if(this.getTemperatura(c + this.getAñoInicio(), f+1) > temperaturaMax){
                    temperaturaMax = this.getTemperatura(c + this.getAñoInicio(),f+1);
                    fMax = f;
                    cMax = c;
                }
            }
        }
        String aux = "El año es: " + (cMax + this.getAñoInicio()) + " en el mes: " + (fMax +1); 
        return aux;
    }
    
    
    public String toStringTemperatura(){
        String aux = "El año con el mas de mayor temperatura fue: " + this.temperaturaMax();
        return aux;
    }
    
    private double promedioAño (int columna){
        double prom = 0;
        for(int f = 0; f < 12; f++ )
            prom += this.getTemperatura(columna + this.getAñoInicio(), f +1);
        return (double) prom / 12;  
    } 
    
    public String toString(){
        String aux = "Estacion " + this.getNombre() 
                + " (" + this.getLatitud() +
                " , " + this.getLongitud() 
                + " )";
        
        for(int c = 0; c < this.getAñoInicio(); c++){
            aux += "\n el año " + (c + this.getAñoInicio()) + ": " + this.promedioAño(c);
        }
        return aux;
    }
}

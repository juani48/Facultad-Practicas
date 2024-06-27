package Ej4;

public class AreaEmpresa {
    private String identificador = "";

    private int tardanza = 0;

    public AreaEmpresa(String identificador, int tardanza){
        this.tardanza = tardanza;
        this.identificador = identificador;
    }

    public int getTardanza(){
        return this.tardanza;
    }
    public String getIdentificador(){
        return this.identificador;
    }
}

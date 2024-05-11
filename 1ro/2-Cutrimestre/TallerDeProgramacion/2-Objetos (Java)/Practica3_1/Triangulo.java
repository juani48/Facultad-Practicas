/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectojuan.Practica3_1;


public class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;
    
    private String colorRelleno = "Sin color de relleno";
    private String colorLinea = "Sin color de linea";

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }
    
    public Triangulo(double lado1 , double lado2, double lado3 , 
                          String colorRelleno , String colorLinea)
    {
        this.setLado1(lado1);
        this.setLado2(lado2);
        this.setLado3(lado3);
        this.setColorRelleno(colorRelleno);
        this.setColorLinea(colorLinea);
    }
    
    public double calcularPerimetro(){ //modificar formula
        double aux = this.getLado1() + this.getLado2() + this.getLado3();
        return aux;
    }
    
    public double calcularArea (){ //modificar formula
        double altura = (double)((this.getLado1() /2) + this.getLado2()*this.getLado2());
        altura = altura*altura;
        double aux = (this.getLado1() * altura) / 2;
        return aux;
    }
    
    
}

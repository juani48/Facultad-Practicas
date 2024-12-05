package Practica1.Ej23.Envio;

public class ExpressDomicilio implements IEnvio {

    private String direccionCliente;
    private String direccionVendedor;

    public ExpressDomicilio(String direccionCliente, String direccionVendedor){
        this.direccionCliente = direccionCliente;
        this.direccionVendedor = direccionVendedor;
    }

    public String getDireccionCliente(){return this.direccionCliente;}
    public String getDireccionVendedor(){return this.direccionVendedor;}

    public double montoTotal(){
        return CalculadoraDistancia.distanciaEntre(this.getDireccionCliente(), this.direccionVendedor);
    }

}

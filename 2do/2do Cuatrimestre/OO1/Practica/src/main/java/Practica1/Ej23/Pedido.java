package Practica1.Ej23;

import Practica1.Ej23.Envio.IEnvio;
import Practica1.Ej23.Pago.IPago;

public class Pedido {

    private Producto producto;
    private Cliente cliente;
    private int cantidad;
    private IEnvio envio;
    private IPago pago;

    public Pedido(Cliente cliente, IPago pago, IEnvio envio, Producto producto, int cantidad){
        if(producto.siHayStock(cantidad)){
            this.cliente = cliente;
            this.pago = pago;
            this.envio = envio;
            this.producto = producto;
            this.cantidad = cantidad;
            this.cliente.agregarPedido(this);
        }  
    }   

    private Producto getProducto(){
        return this.producto;
    }

    public String getCategoriaProducto(){
        return this.getProducto().getCategoria();
    }

    public int getCantidad(){
        return this.cantidad;
    }

    public IEnvio getEnvio(){
        return this.envio;
    }

    public IPago getPago(){
        return this.pago;
    }

    public double montoTotal(){
        double precio = this.getProducto().montoTotal(this.getCantidad());
        return this.getEnvio().montoTotal() + this.getPago().montoTotal(precio);
    }
}

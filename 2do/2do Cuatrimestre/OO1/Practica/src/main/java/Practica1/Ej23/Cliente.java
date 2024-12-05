package Practica1.Ej23;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {

    private List<Pedido> pedidos;
    
    public Cliente(String nombre, String direccion){
        super(nombre, direccion);
        this.pedidos = new ArrayList<>();
    }
    
    public List<Pedido> getPedidos(){
        return this.pedidos;
    }

    public void agregarPedido(Pedido pedido){
        this.getPedidos().add(pedido);
    }

    public List<Pedido> productosPorCategoria(String string){
        return null;
    }
}


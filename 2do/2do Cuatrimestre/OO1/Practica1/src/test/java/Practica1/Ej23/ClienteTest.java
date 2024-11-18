package Practica1.Ej23;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp(){
        this.cliente = new Cliente("nombre", "direccion");
        Producto producto1 = new Producto("nombre 1", "categoria 1", 0, 0);
        Producto producto2 = new Producto("nombre 2", "categoria 2", 0, 0);
        Producto producto3 = new Producto("nombre 3", "categoria 2", 0, 0);
        new Pedido(this.cliente, null, null, producto1, 0);
        new Pedido(this.cliente, null, null, producto2, 0);
        new Pedido(this.cliente, null, null, producto3, 0);
    }
    
    @Test
    void testProductosPorCategoria(){
        assertEquals(1, this.cliente.productosPorCategoria("categoria 1").size());
        assertEquals(2, this.cliente.productosPorCategoria("categoria 2").size());
        assertEquals(0, this.cliente.productosPorCategoria("categoria 3").size());
    }
}

package Practica1.Ej23;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Practica1.Ej23.Envio.RetirarComercio;
import Practica1.Ej23.Pago.AlContado;

public class PedidoTest {

    private Pedido pedido;
    private Cliente cliente;
    private Producto producto1;

    @BeforeEach
    void setUp(){
        this.cliente = new Cliente("nombre","direccion");
        this.producto1 = new Producto("nombre 1", "cagoria 1", 1, 1);
    }

    @Test
    void testCrearPedidoTrue(){
        this.pedido = new Pedido(this.cliente, null, null, producto1, 1);
        assertEquals(this.pedido, this.cliente.getPedidos().get(0));
    }

    @Test
    void testCrearPedidoFalse(){
        this.pedido = new Pedido(this.cliente, null, null, producto1, 2);
        assertTrue(this.cliente.getPedidos().isEmpty());
    }

    @Test 
    void testMontoTotal(){
        this.pedido = new Pedido(cliente, new AlContado(), new RetirarComercio(), producto1, 1);
        assertEquals(1, this.pedido.montoTotal());
        assertNotEquals(0, this.pedido.montoTotal());
    }
}

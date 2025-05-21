## Se tiene el siguiente modelo de un sistema de pedidos y la correspondiente implementación.
```java
public class Pedido {​
    private Cliente cliente;​
    private List<Producto> productos;​
    private String formaPago;​
    
    public Pedido(Cliente cliente, List<Producto> productos, String formaPago) {
        if (!"efectivo".equals(formaPago)​ && !"6 cuotas".equals(formaPago)​ && !"12 cuotas".equals(formaPago)) {​
            throw new Error("Forma de pago incorrecta");​
        }
        ​this.cliente = cliente;​
        this.productos = productos;​
        this.formaPago = formaPago;​
    }​

    public double getCostoTotal() {​
        double costoProductos = 0;​
        for (Producto producto : this.productos) {​
            costoProductos += producto.getPrecio();​
        }​
        double extraFormaPago = 0;​
        if ("efectivo".equals(this.formaPago)) {​
            extraFormaPago = 0;​
        }
        else if ("6 cuotas".equals(this.formaPago)) {​
            extraFormaPago = costoProductos * 0.2;​
        } 
        else if ("12 cuotas".equals(this.formaPago)) {​
            extraFormaPago = costoProductos * 0.5;​
        }​
        int añosDesdeFechaAlta = Period.between(this.cliente.getFechaAlta(),LocalDate.now()).getYears();​
        // Aplicar descuento del 10% si el cliente tiene más de 5 años de antiguedad​
        if (añosDesdeFechaAlta > 5) {​
            return (costoProductos + extraFormaPago) * 0.9;​
        }​
        return costoProductos + extraFormaPago;​
    }
}
public class Cliente {​
    private LocalDate fechaAlta;​
    public LocalDate getFechaAlta() {​ return this.fechaAlta;​ }
}​
public class Producto {​
    private double precio;​
    public double getPrecio() {​ return this.precio;​ }​
}
```
## A -Dado e​l código anterior, aplique únicamente los siguientes refactoring:
1. Replace Loop with Pipeline (líneas 16 a 19)
```java
public class Pedido {​
    private Cliente cliente;​
    private List<Producto> productos;​
    private String formaPago;​
    
    public Pedido(Cliente cliente, List<Producto> productos, String formaPago) {
        if (!"efectivo".equals(formaPago)​ && !"6 cuotas".equals(formaPago)​ && !"12 cuotas".equals(formaPago)) {​
            throw new Error("Forma de pago incorrecta");​
        }
        ​this.cliente = cliente;​
        this.productos = productos;​
        this.formaPago = formaPago;​
    }​

    public double getCostoTotal() {​
        double costoProductos = this.productos.stream().map(p -> p.getPrecio()).sum();

        double extraFormaPago = 0;​
        if ("efectivo".equals(this.formaPago)) {​
            extraFormaPago = 0;​
        }
        else if ("6 cuotas".equals(this.formaPago)) {​
            extraFormaPago = costoProductos * 0.2;​
        } 
        else if ("12 cuotas".equals(this.formaPago)) {​
            extraFormaPago = costoProductos * 0.5;​
        }​
        int añosDesdeFechaAlta = Period.between(this.cliente.getFechaAlta(),LocalDate.now()).getYears();​
        // Aplicar descuento del 10% si el cliente tiene más de 5 años de antiguedad​
        if (añosDesdeFechaAlta > 5) {​
            return (costoProductos + extraFormaPago) * 0.9;​
        }​
        return costoProductos + extraFormaPago;​
    }
}
public class Cliente {​
    private LocalDate fechaAlta;​
    public LocalDate getFechaAlta() {​ return this.fechaAlta;​ }
}​
public class Producto {​
    private double precio;​
    public double getPrecio() {​ return this.precio;​ }​
}
```
2. Replace Conditional with Polymorphism (líneas 21 a 27)
```java
public interface IFormaPago{
    double getCosto();
}

public abstract class Efectivo implements IFormaPago {
    public double getCosto(){
        return 0;
    }
}
public abstract class 6Cuotas implements IFormaPago {
    public double getCosto(){
        return 0.2;
    }
}
public abstract class 12Cuotas implements IFormaPago {
    public double getCosto(){
        return 0.5;
    }
}

public class Pedido {​
    private Cliente cliente;​
    private List<Producto> productos;​
    private IFormaPago formaPago;​
    
    public Pedido(Cliente cliente, List<Producto> productos, IFormaPago formaPago) {
        if (!"efectivo".equals(formaPago)​ && !"6 cuotas".equals(formaPago)​ && !"12 cuotas".equals(formaPago)) {​
            throw new Error("Forma de pago incorrecta");​
        }
        ​this.cliente = cliente;​
        this.productos = productos;​
        this.formaPago = formaPago;​
    }​

    public double getCostoTotal() {​
        double costoProductos = this.productos.stream().map(p -> p.getPrecio()).sum();

        double extraFormaPago = costoProductos * this.formaPago.getCosto();​
 
        int añosDesdeFechaAlta = Period.between(this.cliente.getFechaAlta(),LocalDate.now()).getYears();​
        // Aplicar descuento del 10% si el cliente tiene más de 5 años de antiguedad​
        if (añosDesdeFechaAlta > 5) {​
            return (costoProductos + extraFormaPago) * 0.9;​
        }​
        return costoProductos + extraFormaPago;​
    }
}
public class Cliente {​
    private LocalDate fechaAlta;​
    public LocalDate getFechaAlta() {​ return this.fechaAlta;​ }
}​
public class Producto {​
    private double precio;​
    public double getPrecio() {​ return this.precio;​ }​
}
```
3. Extract method y move method (línea 28)
```java
public interface IFormaPago{
    double getCosto();
}

public abstract class Efectivo implements IFormaPago {
    public double getCosto(){
        return 0;
    }
}
public abstract class 6Cuotas implements IFormaPago {
    public double getCosto(){
        return 0.2;
    }
}
public abstract class 12Cuotas implements IFormaPago {
    public double getCosto(){
        return 0.5;
    }
}

public class Pedido {​
    private Cliente cliente;​
    private List<Producto> productos;​
    private IFormaPago formaPago;​
    
    public Pedido(Cliente cliente, List<Producto> productos, IFormaPago formaPago) {
        if (!"efectivo".equals(formaPago)​ && !"6 cuotas".equals(formaPago)​ && !"12 cuotas".equals(formaPago)) {​
            throw new Error("Forma de pago incorrecta");​
        }
        ​this.cliente = cliente;​
        this.productos = productos;​
        this.formaPago = formaPago;​
    }​

    public double getCostoTotal() {​
        double costoProductos = this.productos.stream().map(p -> p.getPrecio()).sum();

        double extraFormaPago = costoProductos * this.formaPago.getCosto();​
 
        int añosDesdeFechaAlta = this.cliente.añosDesdeFechaAlta();
        // Aplicar descuento del 10% si el cliente tiene más de 5 años de antiguedad​
        if (añosDesdeFechaAlta > 5) {​
            return (costoProductos + extraFormaPago) * 0.9;​
        }​
        return costoProductos + extraFormaPago;​
    }
}
public class Cliente {​
    private LocalDate fechaAlta;​
    public LocalDate getFechaAlta() {​ return this.fechaAlta;​ }
    public int añosDesdeFechaAlta(){ return Period.between(this.getFechaAlta(), LocalDate.now()).getYears(); ​}
}​
public class Producto {​
    private double precio;​
    public double getPrecio() {​ return this.precio;​ }​
}
```
4. Extract method y replace temp with query (líneas 28 a 33)
```java
public interface IFormaPago{
    double getCosto();
}

public abstract class Efectivo implements IFormaPago {
    public double getCosto(){
        return 0;
    }
}
public abstract class 6Cuotas implements IFormaPago {
    public double getCosto(){
        return 0.2;
    }
}
public abstract class 12Cuotas implements IFormaPago {
    public double getCosto(){
        return 0.5;
    }
}

public class Pedido {​
    private Cliente cliente;​
    private List<Producto> productos;​
    private IFormaPago formaPago;​
    
    public Pedido(Cliente cliente, List<Producto> productos, IFormaPago formaPago) {
        if (!"efectivo".equals(formaPago)​ && !"6 cuotas".equals(formaPago)​ && !"12 cuotas".equals(formaPago)) {​
            throw new Error("Forma de pago incorrecta");​
        }
        ​this.cliente = cliente;​
        this.productos = productos;​
        this.formaPago = formaPago;​
    }​

    public double getCostoTotal() {​
        double costoProductos = this.productos.stream().map(p -> p.getPrecio()).sum();

        double extraFormaPago = costoProductos * this.formaPago.getCosto();​

        return (costoProductos + extraFormaPago) * this.cliente.descuentoPorAntiguedad();​
    }
}
public class Cliente {​
    private LocalDate fechaAlta;​
    public LocalDate getFechaAlta() {​ return this.fechaAlta;​ }
    public int añosDesdeFechaAlta(){ return Period.between(this.getFechaAlta(), LocalDate.now()).getYears(); ​}

    public double descuentoPorAntiguedad() { 
        if (this.añosDesdeFechaAlta() > 5) {​
            return 0.9;​
        }​
        return 1;
    }
}​
public class Producto {​
    private double precio;​
    public double getPrecio() {​ return this.precio;​ }​
}
```
## B - Realice el diagrama de clases del código refactorizado.


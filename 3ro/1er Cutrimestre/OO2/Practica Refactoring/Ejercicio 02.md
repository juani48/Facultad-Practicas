## Para cada una de las siguientes situaciones, realice en forma iterativa los siguientes pasos:
### 1. Indique el mal olor,
### 2. Indique el refactoring que lo corrige, 
### 3. Aplique el refactoring, mostrando el resultado final (código y/o diseño según corresponda). 
### Si vuelve a encontrar un mal olor, retorne al paso 1. 


## A - Empleados
```java
public class EmpleadoTemporario {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public double horasTrabajadas = 0;
    public int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * 500) + (this.cantidadHijos * 1000) - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPlanta {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
        return this.sueldoBasico + (this.cantidadHijos * 2000) - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPasante {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    // ......
    
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
```
1. Code smell: Codigo duplicado.
2. Crear una generalizacion y aplicar: Pull Up Method, Push Up Field 
3. 
```java
public class EmpleadoPasante {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    // ......
    
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPlanta extends EmpleadoPasante{
    public int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
        return super.sueldo() + (this.cantidadHijos * 2000);
    }
}

public class EmpleadoTemporario extends EmpleadoPlanta{
    public double horasTrabajadas = 0;
    // ......
    
    public double sueldo() {
        return super.sueldo() + (this.horasTrabajadas * 500) + (this.cantidadHijos * 1000);
    }
}
```
1. Organizacion de datos
2. Aplicar Hide Field o Encapsulate Field.
3. 
```java
public class EmpleadoPasante {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    // ......

    public double getSueldoBasico(){ return this.sueldoBasico; }
    
    public double sueldo() {
        return this.getSueldoBasico() - (this.getSueldoBasico() * 0.13);
    }
}

public class EmpleadoPlanta extends EmpleadoPasante{
    private int cantidadHijos = 0;
    // ......

    public int getCantidadHijos(){ return this.cantidadHijos; }
    
    public double sueldo() {
        return super.sueldo() + (this.getCantidadHijos() * 2000);
    }
}

public class EmpleadoTemporario extends EmpleadoPlanta{
    private double horasTrabajadas = 0;
    // ......

    public double getHorasTrabajadas(){ return this.horasTrabajadas; }
    
    public double sueldo() {
        return super.sueldo() + (this.getHorasTrabajadas() * 500) + (this.getCantidadHijos() * 1000);
    }
}
```

## B - Juego 
```java
public class Juego {
    // ......
    public void incrementar(Jugador j) {
        j.puntuacion = j.puntuacion + 100;
    }
    public void decrementar(Jugador j) {
        j.puntuacion = j.puntuacion - 50;
    }
}

public class Jugador {
    public String nombre;
    public String apellido;
    public int puntuacion = 0;
}
```
1. Code smell: Clase de datos, Clase envidiosa.
2. Aplicar: Move Method y Replace Temp with Query.
3. 
```java
public class Juego {
    // ......
    public void incrementar(Jugador j) {
        j.modificar(100);
    }
    public void decrementar(Jugador j) {
        j.modificar(-50);
    }
}

public class Jugador {
    public String nombre;
    public String apellido;
    public int puntuacion = 0;

    public void modificar(int puntaje){ this.puntuacion += puntaje; }
}
```
1. Organizacion de datos.
2. Aplicar: Hide Field o Encapsulate Field.
3. 
```java
public class Juego {
    // ......
    public void incrementar(Jugador j) {
        j.modificar(100);
    }
    public void decrementar(Jugador j) {
        j.modificar(-50);
    }
}

public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion = 0;

    public void modificar(int puntaje){ this.puntuacion += puntaje; }
}
```

## Publicaciones
```java
/**
* Retorna los últimos N posts que no pertenecen al usuario user
*/
public List<Post> ultimosPosts(Usuario user, int cantidad) {
    List<Post> postsOtrosUsuarios = new ArrayList<Post>();
    for (Post post : this.posts) {
        if (!post.getUsuario().equals(user)) {
            postsOtrosUsuarios.add(post);
        }
    }
    // ordena los posts por fecha
    for (int i = 0; i < postsOtrosUsuarios.size(); i++) {
        int masNuevo = i;
        for(int j= i +1; j < postsOtrosUsuarios.size(); j++) {
            if (postsOtrosUsuarios.get(j).getFecha().isAfter(postsOtrosUsuarios.get(masNuevo).getFecha())) {
                masNuevo = j;
            }
        }
    Post unPost = postsOtrosUsuarios.set(i,postsOtrosUsuarios.get(masNuevo));
    postsOtrosUsuarios.set(masNuevo, unPost);
    }

    List<Post> ultimosPosts = new ArrayList<Post>();
    int index = 0;
    Iterator<Post> postIterator = postsOtrosUsuarios.iterator();
    while (postIterator.hasNext() && index < cantidad) {
        ultimosPosts.add(postIterator.next());
    }
    return ultimosPosts;
}
```
1. Clase envidiosa y Clase de datos.
2. Move Method.
3. 
```java
public class PostApp{

    private List<Post> posts;

    public List<Post> ultimosPosts(Usuario user, int cantidad) {
        List<Post> postsOtrosUsuarios = new ArrayList<Post>();
        for (Post post : this.posts) {
            if (!post.compararUsuario(user)) {
                postsOtrosUsuarios.add(post);
            }
        }
        // ordena los posts por fecha
        for (int i = 0; i < postsOtrosUsuarios.size(); i++) {
            int masNuevo = i;
            for(int j= i +1; j < postsOtrosUsuarios.size(); j++) {
                if (postsOtrosUsuarios.get(j).postMasNuevo(postsOtrosUsuarios.get(masNuevo))) {
                    masNuevo = j;
                }
            }
        //Post unPost = postsOtrosUsuarios.set(i,postsOtrosUsuarios.get(masNuevo));
        postsOtrosUsuarios.set(masNuevo, unPost);
        }

        List<Post> ultimosPosts = new ArrayList<Post>();
        int index = 0;
        Iterator<Post> postIterator = postsOtrosUsuarios.iterator();
        while (postIterator.hasNext() && index < cantidad) {
            ultimosPosts.add(postIterator.next());
        }
        return ultimosPosts;
    }  
}

public class Post{
    private String texto;
    private LocalDateTime fecha;
    private Usuario usuario;

    public Usuario getUsuario(){ return this.usuario; }
    public LocalDateTime getFecha(){ return this.fecha;}

    public boolean compararUsuario(Usuario usuario){ return this.getUsuario.equals(usuario); }

    public boolean postMasNuevo(Post post){ return post.fechaMasNueva(this.getFecha()); }

    public boolean fechaMasNueva(LocalDateTime fecha){ return fecha.isAfter(this.getFecha()); }
    
}

```
1. Metodo largo.
2. Replace Temp with Query y eliminacion de parametros no utilizados.
3. 
```java
public class PostApp{

    private List<Post> posts;

    public List<Post> ultimosPosts(Usuario user) {
        List<Post> postsOtrosUsuarios = this.posts.stream()
            .filter(post -> !post.compararUsuario(user))
            .collect(Collectors.toList());
        
        return postsOtrosUsuarios.stream()
            .sorted((p1, p2) -> p1.postMasNuevo(p2)).collect(COllectors.toList());
    }  
}

public class Post{
    private String texto;
    private LocalDateTime fecha;
    private Usuario usuario;

    public Usuario getUsuario(){ return this.usuario; }
    public LocalDateTime getFecha(){ return this.fecha;}

    public boolean compararUsuario(Usuario usuario){ return this.getUsuario.equals(usuario); }

    public boolean postMasNuevo(Post post){ return post.fechaMasNueva(this.getFecha()); }

    public boolean fechaMasNueva(LocalDateTime fecha){ return fecha.isAfter(this.getFecha()); }
    
}
```
1. Organizacion de datos.
2. Encapsulate Field.
3. 
```java
public class PostApp{

    private List<Post> posts;
    
    public List<Post> getPost(){ return this.posts}

    public List<Post> ultimosPosts(Usuario user, int cantidad) {
        List<Post> postsOtrosUsuarios = this.getPost.stream()
            .filter(post -> !post.compararUsuario(user))
            .collect(Collectors.toList());
        
        return postsOtrosUsuarios.stream()
            .sorted((p1, p2) -> p1.postMasNuevo(p2)).collect(COllectors.toList());
    }  
}

public class Post{
    private String texto;
    private LocalDateTime fecha;
    private Usuario usuario;

    public Usuario getUsuario(){ return this.usuario; }
    public LocalDateTime getFecha(){ return this.fecha;}

    public boolean compararUsuario(Usuario usuario){ return this.getUsuario.equals(usuario); }

    public boolean postMasNuevo(Post post){ return post.fechaMasNueva(this.getFecha()); }

    public boolean fechaMasNueva(LocalDateTime fecha){ return fecha.isAfter(this.getFecha()); }
    
}
```

## Carrito de compras
```java
public class Producto {
    private String nombre;
    private double precio;

    public double getPrecio() {
        return this.precio;
    }
}

public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    public Producto getProducto() {
        return this.producto;
    }
    public int getCantidad() {
    return this.cantidad;
    }
}

public class Carrito {
    private List<ItemCarrito> items;

    public double total() {
        return this.items.stream().mapToDouble(item ->
            item.getProducto().getPrecio() * item.getCantidad())
            .sum();
    }
}
```
1. Clase envidiosa
2. Mover el metodo.
3. 
```java
public class Producto {
    private String nombre;
    private double precio;

    public double getPrecio() {
        return this.precio;
    }
}

public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    public Producto getProducto() { return this.producto; }
    public int getCantidad() { return this.cantidad; }

    public double getPrecio(){ return this.getProducto.getPrecio() * this.getCantidad(); }
}

public class Carrito {
    private List<ItemCarrito> items;

    public double total() {
        return this.items.stream().mapToDouble(ic -> ic.getPrecio()).sum();
    }
}
```
1. Mal uso de tipos
2. Cambiar tipos de datos.
3. 
```java
public class Producto {
    private String nombre;
    private double precio;

    public double getPrecio() {
        return this.precio;
    }
}

public class ItemCarrito {
    private Producto producto;
    private double cantidad;

    public Producto getProducto() { return this.producto; }
    public int getCantidad() { return this.cantidad; }

    public double getPrecio(){ return this.getProducto.getPrecio() * this.getCantidad(); }
}

public class Carrito {
    private List<ItemCarrito> items;

    public double total() {
        return this.items.stream().map(ic -> ic.getPrecio()).sum();
    }
}
```
1. Organizacion de datos.
2. Encapsular campo.
3. 
```java
public class Producto {
    private String nombre;
    private double precio;

    public double getPrecio() {
        return this.precio;
    }
}

public class ItemCarrito {
    private Producto producto;
    private double cantidad;

    public Producto getProducto() { return this.producto; }
    public int getCantidad() { return this.cantidad; }

    public double getPrecio(){ return this.getProducto.getPrecio() * this.getCantidad(); }
}

public class Carrito {
    private List<ItemCarrito> items;
    
    public List<ItemCArrito> getItems(){ return this.items; }

    public double total() {
        return this.getItems().stream().map(ic -> ic.getPrecio()).sum();
    }
}
```

## Envío de pedidos
```java
public class Supermercado {
    public void notificarPedido(long nroPedido, Cliente cliente) {
        String notificacion = MessageFormat.format("Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección{1}", new Object[] { nroPedido, cliente.getDireccionFormateada() });
        
        // lo imprimimos en pantalla, podría ser un mail, SMS, etc..
        System.out.println(notificacion);
    }
}

public class Cliente {
    public String getDireccionFormateada() { 
        return this.direccion.getLocalidad() + ", " + this.direccion.getCalle() + ", " + this.direccion.getNumero() + ", " + this.direccion.getDepartamento();
    }
}
```
1. Clase envidiosa y Clase de datos.
2. Mover metodo y Replace Temp with Query
3. 
```java
public class Supermercado {
    public void notificarPedido(long nroPedido, Cliente cliente) {
        String notificacion = MessageFormat.format("Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección{1}", new Object[] { nroPedido, cliente.getDireccionFormateada() });
        
        // lo imprimimos en pantalla, podría ser un mail, SMS, etc..
        System.out.println(notificacion);
    }
}

public class Cliente {

    private Direccion direccion;

    public String getDireccionFormateada() { 
        return this.direccion.toString();
    }
}

public class Direccion{
    public String localidad;
    public String calle;
    public String numero;
    public String departamento;

    public String getLocalidad(){ return this.localidad; } 
    public String getCalle(){ return this.calle; } 
    public String getNumero(){ return this.numero; } 
    public String getDepartamento(){ return this.departamento; } 

    public String toString(){
        return this.direccion.getLocalidad() + ", " + this.direccion.getCalle() + ", " + this.direccion.getNumero() + ", " + this.direccion.getDepartamento();
    }
}
```
1. Metodo largo y variables innecesarias
2. Replace Temp with Query.
3. 
```java
public class Supermercado {
    public void notificarPedido(long nroPedido, Cliente cliente) {
        System.out.println("Estimado cliente, se le informa que hemos recibido su pedido con número "+ nroPedido +", el cual será enviado a la dirección " + cliente.getDireccionFormateada());
    }
}

public class Cliente {

    private Direccion direccion;

    public String getDireccionFormateada() { 
        return this.direccion.toString();
    }
}

public class Direccion{
    public String localidad;
    public String calle;
    public String numero;
    public String departamento;

    public String getLocalidad(){ return this.localidad; } 
    public String getCalle(){ return this.calle; } 
    public String getNumero(){ return this.numero; } 
    public String getDepartamento(){ return this.departamento; } 

    public String toString(){
        return this.direccion.getLocalidad() + ", " + this.direccion.getCalle() + ", " + this.direccion.getNumero() + ", " + this.direccion.getDepartamento();
    }
}
```
1. Organizacion de datos.
2. Encapsular campo.
3. 
```java
public class Supermercado {
    public void notificarPedido(long nroPedido, Cliente cliente) {
        System.out.println("Estimado cliente, se le informa que hemos recibido su pedido con número "+ nroPedido +", el cual será enviado a la dirección " + cliente.getDireccionFormateada());
    }
}

public class Cliente {

    private Direccion direccion;

    public Direccion getDireccion(){ return this.direccion; }

    public String getDireccionFormateada() { 
        return this.getDireccion().toString();
    }
}

public class Direccion{
    public String localidad;
    public String calle;
    public String numero;
    public String departamento;

    public String getLocalidad(){ return this.localidad; } 
    public String getCalle(){ return this.calle; } 
    public String getNumero(){ return this.numero; } 
    public String getDepartamento(){ return this.departamento; } 

    public String toString(){
        return this.direccion.getLocalidad() + ", " + this.direccion.getCalle() + ", " + this.direccion.getNumero() + ", " + this.direccion.getDepartamento();
    }
}
```
## Películas
```java
public class Usuario {
    String tipoSubscripcion;
    // ...
    public void setTipoSubscripcion(String unTipo) {
        this.tipoSubscripcion = unTipo;
    }
    public double calcularCostoPelicula(Pelicula pelicula) {
        double costo = 0;
        if (tipoSubscripcion=="Basico") {
            costo = pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno();
        }
        else if (tipoSubscripcion== "Familia") {
            costo = (pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno()) * 0.90;
        }
        else if (tipoSubscripcion=="Plus") {
            costo = pelicula.getCosto();
        }
        else if (tipoSubscripcion=="Premium") {
            costo = pelicula.getCosto() * 0.75;
        }
        return costo;
    }
}

public class Pelicula {
    LocalDate fechaEstreno;
    // ...
    public double getCosto() {
        return this.costo;
    }
    public double calcularCargoExtraPorEstreno(){
        // Si la Película se estrenó 30 días antes de la fecha actual, retorna un cargo de 0$, caso contrario, retorna un cargo extra de 300$
        return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) ) > 30 ? 0 :300;
    }
}
```
1. Uso de condicionales en vez de polimorfismo.
2. Crear una interfaz y generalizar.
3. 
```java
public interface ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula);
}

public abstract class Basico implements ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula){
        return pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno();
    }
}

public abstract class Familia implements ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula){
        return (pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno()) * 0.90;
    }
}

public abstract class Plus implements ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula){
        return pelicula.getCosto();
    }
}

public abstract class Premium implements ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula){
        return pelicula.getCosto() * 0.75;
    }
}

public class Usuario {
    String tipoSubscripcion;
    // ...
    public void setTipoSubscripcion(ISubscripcion unTipo) {
        this.tipoSubscripcion = unTipo;
    }
    public double calcularCostoPelicula(Pelicula pelicula) {
        double costo = 0;
        costo = this.tipoSubscripcion.calcularCostoPelicula(pelicula);
        return costo;
    }
}

public class Pelicula {
    LocalDate fechaEstreno;
    // ...
    public double getCosto() {
        return this.costo;
    }
    public double calcularCargoExtraPorEstreno(){
        // Si la Película se estrenó 30 días antes de la fecha actual, retorna un cargo de 0$, caso contrario, retorna un cargo extra de 300$
        return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) ) > 30 ? 0 :300;
    }
}
```
1. Clase envidiosa
2. Mover el metodo.
3. 
```java
public interface ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula);
}

public abstract class Basico implements ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula){
        return pelicula.getCosto(LocalDate.now());
    }
}

public abstract class Familia implements ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula){
        return pelicula.getCosto(LocalDate.now()) * 0.90;
    }
}

public abstract class Plus implements ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula){
        return pelicula.getCosto();
    }
}

public abstract class Premium implements ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula){
        return pelicula.getCosto() * 0.75;
    }
}

public class Usuario {
    String tipoSubscripcion;
    // ...
    public void setTipoSubscripcion(ISubscripcion unTipo) {
        this.tipoSubscripcion = unTipo;
    }
    public double calcularCostoPelicula(Pelicula pelicula) {
        double costo = 0;
        costo = this.tipoSubscripcion.calcularCostoPelicula(pelicula);
        return costo;
    }
}

public class Pelicula {
    LocalDate fechaEstreno;
    // ...
    public double getCosto() {
        return this.costo;
    }
    public double getCosto(LocalDate fecha){
        double costo = this.getCosto();
        if (ChronoUnit.DAYS.between(this.fechaEstreno, fecha) > 30){
            cosot += 300;
        }
        return costo; 
    }
}
```
1. Variables innecesarias.
2. Replace Temp with Query.
3. 
```java
public interface ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula);
}

public abstract class Basico implements ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula){
        return pelicula.getCosto(LocalDate.now());
    }
}

public abstract class Familia implements ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula){
        return pelicula.getCosto(LocalDate.now()) * 0.90;
    }
}

public abstract class Plus implements ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula){
        return pelicula.getCosto();
    }
}

public abstract class Premium implements ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula){
        return pelicula.getCosto() * 0.75;
    }
}

public class Usuario {
    String tipoSubscripcion;
    // ...
    public void setTipoSubscripcion(ISubscripcion unTipo) {
        this.tipoSubscripcion = unTipo;
    }
    public double calcularCostoPelicula(Pelicula pelicula) {
        return this.tipoSubscripcion.calcularCostoPelicula(pelicula);
    }
}

public class Pelicula {
    LocalDate fechaEstreno;
    // ...
    public double getCosto() {
        return this.costo;
    }
    public double getCosto(LocalDate fecha){
        double costo = this.getCosto();
        if (ChronoUnit.DAYS.between(this.fechaEstreno, fecha) > 30){
            cosot += 300;
        }
        return costo; 
    }
}
```
1. Organizacion de datos.
2. Ocultar y encapsular el campo.
3. 
```java
public interface ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula);
}

public abstract class Basico implements ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula){
        return pelicula.getCosto(LocalDate.now());
    }
}

public abstract class Familia implements ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula){
        return pelicula.getCosto(LocalDate.now()) * 0.90;
    }
}

public abstract class Plus implements ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula){
        return pelicula.getCosto();
    }
}

public abstract class Premium implements ISubscripcion{
    public double calcularCostoPelicula(Pelicula pelicula){
        return pelicula.getCosto() * 0.75;
    }
}

public class Usuario {
    private String tipoSubscripcion;
    // ...
    public String getSubscripcion(){ return this.tipoSubscripcion}
    public void setTipoSubscripcion(ISubscripcion unTipo) { this.tipoSubscripcion = unTipo; }

    public double calcularCostoPelicula(Pelicula pelicula) {
        return this.getSubscripcion().calcularCostoPelicula(pelicula);
    }
}

public class Pelicula {
    private LocalDate fechaEstreno;
    // ...
    public LocalDate getFechaEstreno(){ return this.fechaEstreno; }

    public double getCosto() {
        return this.costo;
    }
    public double getCosto(LocalDate fecha){
        double costo = this.getCosto();
        if (ChronoUnit.DAYS.between(this.getFechaEstreno(), fecha) > 30){
            cosot += 300;
        }
        return costo; 
    }
}
```

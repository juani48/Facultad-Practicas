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
2. Crear una generalizacion y aplicar: Pull Up Method, Push Up Field y Hide Field o Encapsulate Field.
3. El resultado es:

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
    public double horasTrabajadas = 0;
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
2. Aplicar: Move Method, Replace Temp with Query y Hide Field to Encapsulate Field.
3. El resultado es:

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
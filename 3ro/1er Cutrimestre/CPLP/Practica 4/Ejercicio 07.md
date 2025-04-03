## Sea el siguiente segmento de código escrito en Java, indique para los identificadores si son globales o locales.
```java
public class Persona{
    public long id;
    public String nombreApellido;​
    public Domicilio domicilio;
    private String dni;
    public String fechaNac;
    public static int cantTotalPersonas;

    //Se tienen los getter y setter de cada una de las variables
    //Este método calcula la edad de la persona a partir de la fecha de nacimiento

    public int getEdad(){
        public int edad = 0;
        public String fN = this.getFechaNac();
        //...
        return edad;
    }

}

public class Domicilio{
    public long​ id;
    public static int nro;
    public String calle;
    public Localidad loc;

    //Se tienen los getter y setter de cada una de las variables
}
```

LOs identificadores son globales.
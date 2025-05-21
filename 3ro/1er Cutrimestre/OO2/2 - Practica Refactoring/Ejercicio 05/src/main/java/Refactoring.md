## Clase Empresa

### 1 - Varaibles innecesarias
```java
private List<Llamada> llamadas = new ArrayList<Llamada>();
```
Remover varaible

### 2 - Clase envidiosa
```java
    public boolean agregarNumeroTelefono(String str) {
		boolean encontre = guia.getLineas().contains(str);
		if (!encontre) {
			guia.getLineas().add(str);
			encontre= true;
			return encontre;
		}
		else {
			encontre= false;
			return encontre;
		}
	}
```
Move Method a GestorNumerosDisponibles:
```java
class Emporesa {
    public boolean agregarNumeroTelefono(String str) {
		return this.getGestorNumeros().agregarNumeroTelefono(str);
    }
}
class GestorNumerosDisponibles{
    public boolean agregarNumeroTelefono(String str) {
		boolean encontre = this.getLineas().contains(str);
		if (!encontre) {
            this.getLineas().add(str);
			encontre= true;
			return encontre;
		}
		else {
			encontre= false;
			return encontre;
		}
	}
}
```
### 3 - Cadena de mensajes
```java
    public Cliente registrarUsuario(String data, String nombre, String tipo) { //agregar consturctor cliente
		Cliente var = new Cliente();
		if (tipo.equals("fisica")) {
			var.setNombre(nombre);
			String tel = this.obtenerNumeroLibre();
			var.setTipo(tipo);
			var.setNumeroTelefono(tel);
			var.setDNI(data);
		}
		else if (tipo.equals("juridica")) {
			String tel = this.obtenerNumeroLibre();
			var.setNombre(nombre);
			var.setTipo(tipo);
			var.setNumeroTelefono(tel);
			var.setCuit(data);
		}
		clientes.add(var);
		return var;
	}
```
Crear constructores en Cliente:
```java
class Empresa {
    public Cliente registrarUsuario(String data, String nombre, String tipo) { //agregar consturctor cliente
		Cliente var = null;
		if (tipo.equals("fisica")) {
			var = new Cliente(tipo, nombre, this.obtenerNumeroLibre(), "", data);
		}
		else if (tipo.equals("juridica")) {
			var = new Cliente(tipo, nombre, this.obtenerNumeroLibre(), data, "");
		}
		clientes.add(var);
		return var;
	}
}
class Cliente{
    public Cliente(String tipo, String nombre, String numero, String cuit, String dni) {
		this.tipo = tipo; this.nombre = nombre; this.numeroTelefono = numero; this.cuit = cuit; this.dni = dni;
	}
}
```
### 4 - Clase envidiosa
``` java
    public Llamada registrarLlamada(Cliente origen, Cliente destino, String t, int duracion) {
		Llamada llamada = new Llamada(t, origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion); 
		origen.llamadas.add(llamada); 
		return llamada;
}
```
Move Method a Cliente:
```java
class Empresa{
    public Llamada registrarLlamada(Cliente origen, Cliente destino, String t, int duracion) {
		Llamada llamada = new Llamada(t, origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion); 
		origen.agregarLlamada(llamada);
		return llamada;
	}
}
class Cliente{
    public void agregarLlamada(Llamada llamada) {
		this.getLlamadas().add(llamada);
	}
}
```

### 5 - Metodo grande y clase envidiosa
```java
    public double calcularMontoTotalLlamadas(Cliente cliente) {
		double c = 0;
		for (Llamada l : cliente.llamadas) {
			double auxc = 0;
			if (l.getTipoDeLlamada() == "nacional") {
				// el precio es de 3 pesos por segundo más IVA sin adicional por establecer la llamada
				auxc += l.getDuracion() * 3 + (l.getDuracion() * 3 * 0.21);
			} else if (l.getTipoDeLlamada() == "internacional") {
				// el precio es de 150 pesos por segundo más IVA más 50 pesos por establecer la llamada
				auxc += l.getDuracion() * 150 + (l.getDuracion() * 150 * 0.21) + 50;
			}

			if (cliente.getTipo() == "fisica") {
				auxc -= auxc*descuentoFis;
			} else if(cliente.getTipo() == "juridica") {
				auxc -= auxc*descuentoJur;
			}
			c += auxc;
		}
		return c;
	}
```
Move Metohd a Cliente
```java
class Empresa{
    public double calcularMontoTotalLlamadas(Cliente cliente) {
		return cliente.calcularMontoTotalLlamadas(this.descuentoFis, this.descuentoJur);
	}
}
class Cliente{
    public double calcularMontoTotalLlamadas(double descuentoFis, double descuentoJur) {
		double c = 0;
		for (Llamada l : this.getLlamadas()) { 
			double auxc = 0;
			if (l.getTipoDeLlamada() == "nacional") {
				// el precio es de 3 pesos por segundo más IVA sin adicional por establecer la llamada
				auxc += l.getDuracion() * 3 + (l.getDuracion() * 3 * 0.21);
			} else if (l.getTipoDeLlamada() == "internacional") {
				// el precio es de 150 pesos por segundo más IVA más 50 pesos por establecer la llamada
				auxc += l.getDuracion() * 150 + (l.getDuracion() * 150 * 0.21) + 50;
			}

			if (this.getTipo() == "fisica") {
				auxc -= auxc*descuentoFis;
			} else if(this.getTipo() == "juridica") {
				auxc -= auxc*descuentoJur;
			}
			c += auxc;
		}
		return c;
	}
}
```

## Clase Cliente

### 1 - Codigo duplicado
```java
    public double calcularMontoTotalLlamadas(double descuentoFis, double descuentoJur) {
		double c = 0;
		for (Llamada l : this.getLlamadas()) { 
			double auxc = 0;
			if (l.getTipoDeLlamada() == "nacional") {
				// el precio es de 3 pesos por segundo más IVA sin adicional por establecer la llamada
				auxc += l.getDuracion() * 3 + (l.getDuracion() * 3 * 0.21);
			} else if (l.getTipoDeLlamada() == "internacional") {
				// el precio es de 150 pesos por segundo más IVA más 50 pesos por establecer la llamada
				auxc += l.getDuracion() * 150 + (l.getDuracion() * 150 * 0.21) + 50;
			}

			if (this.getTipo() == "fisica") {
				auxc -= auxc*descuentoFis;
			} else if(this.getTipo() == "juridica") {
				auxc -= auxc*descuentoJur;
			}
			c += auxc;
		}
		return c;
	}
```
Replace conditional with strategy
```java
class Cliente{
    private TipoCliente tipo;

    public double calcularMontoTotalLlamadas(double descuentoFis, double descuentoJur) {
		double c = 0;
		for (Llamada l : this.getLlamadas()) { 
			double auxc = 0;
			if (l.getTipoDeLlamada() == "nacional") {
				// el precio es de 3 pesos por segundo más IVA sin adicional por establecer la llamada
				auxc += l.getDuracion() * 3 + (l.getDuracion() * 3 * 0.21);
			} else if (l.getTipoDeLlamada() == "internacional") {
				// el precio es de 150 pesos por segundo más IVA más 50 pesos por establecer la llamada
				auxc += l.getDuracion() * 150 + (l.getDuracion() * 150 * 0.21) + 50;
			}

			auxc *= this.getTipo().descuento();
			c += auxc;
		}
		return c;
	}
}

interface TipoCliente{
    public double descuento(double total);
}
public class Jurico implements TipoCliente{
	public double descuento(double total) {
		return total * 0.15;
	}
}
public class Fisico implements TipoCliente{
	public double descuento(double total) {
		return total * 0; 
	}
}
```
### 2 - Varaibles innecesaria
```java
class Cliente{
    private String cuit;
	private String dni;
}
```
Reemplazar para una sola variable data:
```java
class Cliente{
    private String data;
}
```
Replace conditional with polymorphism en Clase Empresa:
```java
    public Cliente registrarUsuario(String data, String nombre, TipoCliente tipo) { 
		Cliente var = new Cliente(tipo, nombre, this.obtenerNumeroLibre(), data);
		clientes.add(var);
		return var;
	}
```
### 3 - Metodo grande y clase envidiosa
```java
    public double calcularMontoTotalLlamadas(double descuentoFis, double descuentoJur) {
		double c = 0;
		for (Llamada l : this.getLlamadas()) { 
			double auxc = 0;
			if (l.getTipoDeLlamada() == "nacional") {
				// el precio es de 3 pesos por segundo más IVA sin adicional por establecer la llamada
				auxc += l.getDuracion() * 3 + (l.getDuracion() * 3 * 0.21);
			} else if (l.getTipoDeLlamada() == "internacional") {
				// el precio es de 150 pesos por segundo más IVA más 50 pesos por establecer la llamada
				auxc += l.getDuracion() * 150 + (l.getDuracion() * 150 * 0.21) + 50;
			}

			auxc *= this.getTipo().descuento();
			c += auxc;
		}
		return c;
	}
```
Move Method a Llamada:
```java
class Cliente{
    public double calcularMontoTotalLlamadas(double descuentoFis, double descuentoJur) {
		double c = 0;
		for (Llamada l : this.getLlamadas()) { 
			double auxc = l.calcularMonto();
			auxc *= this.getTipo().descuento();
			c += auxc;
		}
		return c;
	}
}
class Llamada{
    public double calcularMonto() {
		double auxc = 0;
		if (this.getTipoDeLlamada() == "nacional") {
			// el precio es de 3 pesos por segundo más IVA sin adicional por establecer la llamada
			auxc += this.getDuracion() * 3 + (this.getDuracion() * 3 * 0.21);
		} else if (this.getTipoDeLlamada() == "internacional") {
			// el precio es de 150 pesos por segundo más IVA más 50 pesos por establecer la llamada
			auxc += this.getDuracion() * 150 + (this.getDuracion() * 150 * 0.21) + 50;
		}
		return auxc;
	}
}
```
### 4 - Variables innecesarias
```java
class Cliente{
    public double calcularMontoTotalLlamadas(double descuentoFis, double descuentoJur) {
		double c = 0;
		for (Llamada l : this.getLlamadas()) { 
			double auxc = l.calcularMonto();
			auxc *= this.getTipo().descuento();
			c += auxc;
		}
		return c;
	}
}
```
Replace temp with query:
```java
class Cliente{
    public double calcularMontoTotalLlamadas(double descuentoFis, double descuentoJur) {
		return this.getLlamadas().stream().mapToDouble(x -> x.calcularMonto() - this.getTipo().descuento(x.calcularMonto())).sum();
	}
}
```
## Clase Llamada
### 1 - Codigo duplicado
```java
public double calcularMonto() {
		double auxc = 0;
		if (this.getTipoDeLlamada() == "nacional") {
			// el precio es de 3 pesos por segundo más IVA sin adicional por establecer la llamada
			auxc += this.getDuracion() * 3 + (this.getDuracion() * 3 * 0.21);
		} else if (this.getTipoDeLlamada() == "internacional") {
			// el precio es de 150 pesos por segundo más IVA más 50 pesos por establecer la llamada
			auxc += this.getDuracion() * 150 + (this.getDuracion() * 150 * 0.21) + 50;
		}
		return auxc;
	}
```
Replace conditional with strategy:
```java
class Llamada{
    private TipoLlamada tipoDeLlamada;

    public TipoLlamada getTipoDeLlamada() { return tipoDeLlamada; }

    public double calcularMonto() {
		return this.getTipoDeLlamada().calcularMonto(this.getDuracion());
	}
}
interface TipoLlamada{
    public double calcularMonto(int duracion);
}
class Nacional implements TipoLlamada{
    public double calcularMonto(int duracion) {
		return duracion * 3 + (duracion * 3 * 0.21);
	}
}
class Internacional implements TipoLlamada{
    public double calcularMonto(int duracion) {
		return duracion * 150 + (duracion * 150 * 0.21) + 50;
	}
}
```

## Clase GestorNumerosDisponibles
### 1 - Codigo duplicado
```java
    public boolean agregarNumeroTelefono(String str) {
		boolean encontre = this.getLineas().contains(str);
		if (!encontre) {
			encontre= true;
			return encontre;
		}
		else {
			encontre= false;
			return encontre;
		}
	}
```
Replace temp with query
```java
    public boolean agregarNumeroTelefono(String str) {
		if (!this.getLineas().contains(str)) {
			this.getLineas().add(str);
			return true;
		}
		return false;
	}
```
### 2 - Metodo largo
```java
    public String obtenerNumeroLibre() {
		String linea;
		switch (tipoGenerador) {
			case "ultimo":
				linea = lineas.last();
				lineas.remove(linea);
				return linea;
			case "primero":
				linea = lineas.first();
				lineas.remove(linea);
				return linea;
			case "random":
				linea = new ArrayList<String>(lineas)
						.get(new Random().nextInt(lineas.size()));
				lineas.remove(linea);
				return linea;
		}
		return null;
	}
```
Repslace conditional with strategy:
```java
public class GestorNumerosDisponibles {

	private SortedSet<String> lineas = new TreeSet<String>();
	private GeneradorNumero tipoGenerador = new Ultimo();

	public SortedSet<String> getLineas() { return lineas; }
	public void cambiarTipoGenerador(GeneradorNumero valor) { this.tipoGenerador = valor; }
	public GeneradorNumero getTipoGenerador() { return this.tipoGenerador; }
	
	public boolean agregarNumeroTelefono(String str) {
		boolean aux = this.getLineas().contains(str);
		if (aux) {
			this.getLineas().add(str);
		}
		return aux;
	}
	
	public String obtenerNumeroLibre() {
		return this.getTipoGenerador().obtenerNumeroLibre(this.getLineas());
	}
}
interface GeneradorNumero{
    public String obtenerNumeroLibre(SortedSet<String> lineas);
}
public class Ultimo implements GeneradorNumero{
	public String obtenerNumeroLibre(SortedSet<String> lineas) {
		String linea = lineas.last();
		lineas.remove(linea);
		return linea;
	}
}
public class Primero implements GeneradorNumero{
	public String obtenerNumeroLibre(SortedSet<String> lineas) {
		String linea = lineas.first();
		lineas.remove(linea);
		return linea;
	}
}
public class Random implements GeneradorNumero{
	public String obtenerNumeroLibre(SortedSet<String> lineas) {
		String linea = new ArrayList<String>(lineas).get(((RandomGenerator) new Random()).nextInt(lineas.size()));
		lineas.remove(linea);
		return linea;
	}
}
```

## Clase Empresa
### 6 - Variables innecesarias
```java
static double descuentoJur = 0.15; 
static double descuentoFis = 0;
```
Eliminar variables.

Modificar parametro del motodo `calcularMontoTotalLlamadas(this.descuentoFis, this.descuentoJur);` a `calcularMontoTotalLlamadas();`.

Modificar la definicion de la funcion `calcularMontoTotalLlamadas(this.descuentoFis, this.descuentoJur){}` en la clase Ciiente.

### 7 - Acceso a variables de instancia sin metodos getters
```java
    public Cliente registrarUsuario(String data, String nombre, TipoCliente tipo) { 
		Cliente var = new Cliente(tipo, nombre, this.obtenerNumeroLibre(), data);
		clientes.add(var);
		return var;
	}
```
Agregar getters para clientes.



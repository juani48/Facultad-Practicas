## B - Participación en proyectos
# Al revisar el siguiente diseño inicial (Figura 1), se decidió realizar un cambio para evitar lo que se consideraba un mal olor. El diseño modificado se muestra en la Figura 2. Indique qué tipo de cambio se realizó y si lo considera apropiado. Justifique su respuesta.

Se cambio quien es el encargado de saber si una persona participo en un proyecto. Este cambio es apropiado ya que el proyecto al concer a las personas es el verdadero responsable de saber si un X persona participo en el proyecto.

## C - Cálculos
# Analice el código que se muestra a continuación. Indique qué code smells encuentra y cómo pueden corregirse.

```java
public void imprimirValores() {
	int totalEdades = 0;
	double promedioEdades = 0;
	double totalSalarios = 0;
	
	for (Empleado empleado : personal) {
		totalEdades = totalEdades + empleado.getEdad();
		totalSalarios = totalSalarios + empleado.getSalario();
	}
	promedioEdades = totalEdades / personal.size();
		
	String message = String.format("El promedio de las edades es %s y el total de salarios es %s", promedioEdades, totalSalarios);
	
	System.out.println(message);
}
```
El motodo posee decalracion de varaibles redundantes, ya que estas se utilizan una sola vez, como "message" o "promedioEdades". Se puede correguir con "Replace Temp with Query".

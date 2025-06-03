## Cuando se termina de manejar la excepción, la acción que se toma luego es importante. Indique:

### 1 - ​¿Qué modelos diferentes existen en este aspecto?

- Reasunción: Se refiere a la posibilidad de retomar la ejecución normal del programa después de manejar una excepción. El controlador de excepciones realiza las acciones necesarias para manejar la excepción (medidas correctivas) y luego el programa continúa su ejecución a partir del punto donde se produjo la excepción.

- Terminación: El controlador de excepciones realiza las acciones necesarias para manejar la excepción, pero no se retorna al punto donde se produjo la excepción (invocador), continúa su ejecución a partir de la finalización del manejador. Terminación es el más utilizado actualmente.

### 2 - ​Dé ejemplos de lenguajes que utilizan cada uno de los modelos presentados anteriormente. Por cada uno responda respecto de la forma en que trabaja las excepciones: ¿Cómo se define? ¿Cómo se lanza? ¿Cómo se maneja? ¿Cuál es su criterio de continuación?

- PL/1 -> reasuncion:
  - Definicion (excepcion con manejador): `ON CONDITION nombre_excepcion begin ... end;`
  - Lanzar excepciones: `SIGNAL CONDITION nombre_excepcion`
  - Los manejadores se ligan dinámicamente con las excepciones. Una excepción siempre estará ligada con el último manejador definido.
- Java -> Terminacion:
  - Definicion: Cada excepción está representada por una instancia de la clase `Throwable` o de unade sus subclases (`Error` y `Exception`).
  - Lanzar excepcion: `throw NombreExcepcion()`
  - Manejo: La excecpion debe haberse lanzado dentro de un bloque `try` para que sea manjeado por su manejador (en caso de haber defino uno para la excepcion detectada) o por en manjeador generico (en caso de haber definido un `catch` para cualquier excepcion o un `default`)

### 3 - ​¿Cuál de esos modelos es más inseguro y por qué?

El modelo de resuncion es más inseguro por el riesgo a que un manjeador deje el estado incosistente, dado que en la reasunción, al volver al punto exacto del error, el programa asume que el manejador solucionó todos los problemas, ademas el manejador necesita conocer detalles internos del contexto donde ocurrió la excepción para "corregir" el problema.
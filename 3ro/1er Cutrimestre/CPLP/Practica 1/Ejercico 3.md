## ¿Qué atributos debería tener un buen lenguaje de programación? Por ejemplo, ortogonalidad, expresividad, legibilidad, simplicidad, etc. De al menos un ejemplo de un lenguaje que cumple con las características citadas.

- **Simplicidad y legibilidad**: Los lenguajes de programación deberían:
  - Poder producir programas fáciles de escribir y de leer.
  - Resultar fáciles a la hora de aprenderlo o enseñarlo.
  - La estructura subyacente del algoritmo y los datos que el programa representa deben quedan en manifiesto al inspeccionar el texto del programa.

- **Claridad en los bindings**: Los elementos de los lenguajes de programación pueden ligarse (binding) a sus atributos o propiedades en diferentes momentos (relacion entre el token o word con su significo). La ligadura en cualquier caso debe ser clara.

- **Confiabilidad**: La confiabilidad está relacionada con la seguridad.
  - Chequeo de tipos: Cuanto antes se encuentren errores menos costoso resulta realizar los arreglos que se requieran.
  - Manejo de excepciones: La habilidad para interceptar errores en tiempo de ejecución, tomar medidas correctivas y continuar.

- **Soporte**: Debería ser accesible para cualquiera que quiera usarlo o instalarlo. Lo ideal sería que su compilador o intérprete sea de dominio público. Debería poder ser implementado en diferentes plataformas.

- **Abstracción**: Capacidad de definir y usar estructuras u operaciones complicadas de manera que sea posible ignorar muchos de los detalles. Concepto clave para manejar la complejidad, abstracción de procesos y de datos.

- **Ortogonalidad**: Ortogonalidad refiere a la posibilidad que ofrece el lenguaje de poder combinar sus elementos sin producir errores. Significa que un conjunto pequeño de constructores primitivos, puede ser combinado en número relativamente pequeño a la hora de construir estructuras de control y datos. Cada combinación es legal y con sentido.

- **Eficiencia**: La eficiencia se relaciona con:
  - Tiempo y Espacio: Capacidad de un programa para realizar una tarea de manera correcta y consumiendo pocos recursos, de memoria, espacio en disco, tiempo de ejecución, tráfico de red, etc.
  - Esfuerzo humano: Que mejore el rendimiento del programador.
  - Optimizable: Capacidad del lenguaje de programación de venir optimizado para tareas específicas.

Pascal es una ejemplo de lenguaje que cumple con las características citadas. Es simple y legible, de por si Pascal fue desarrollados con fines educativos, por lo que desde su concepción, es una lenguaje que posee una sintaxis simple y entendible, su necesidad de separar en regiones la declaración de tipos, procedimientos variables y código, le dala facilidad de leer y entender su flujo. 
Posee claridad a la hora de definir los bindings, al ser una lenguaje compilado es fácil identificar en que momento se realizan las ligaduras entre variables o propiedades con su semántica.
Pascal es un lenguaje altamente confiable por ser fuertemente y estaticamente tipado, permitiendo seguridad sobre el tipo de dato utilizado y confiabilidad al la hora del manejo de excepciones.
Pascal es una lenguaje que tiene un gran soporte, al ser una lenguaje sencillo existe mucha inflacionario para lograr comprender su sintaxis y su estructura.
La abstracción es Pascal es compleja, por mas de que exista la posibilidad de definir estructuras de datos para representar la realidad, estas terminan siendo complejas y antes sistemas grandes, Pascal no proporciona una buena abstracción como lo podría ofrecer una lenguaje que soporte programación orinada a objetos (No estoy teniendo en cuenta a Object Pascal o Turbo Pascal).
Pascal ofrece una buena ortogonalidad, creando estructuras de datos complejas con tipos primitivos.



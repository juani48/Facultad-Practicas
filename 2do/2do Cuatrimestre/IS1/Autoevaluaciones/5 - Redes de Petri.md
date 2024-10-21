## 1 - Una Red de Petri es una representación matemática y/o gráfica de un sistema que reacciona a eventos  en el cual se puede describir un sistema distribuido, paralelo o concurrente.

- [x] Verdadero.
- [ ] Falso.

## 2 - Dada la definición formal de una "red de petri" indique que representa cada letra del siguiente 4-upla: C=(P, T, I, O):

- T → [*eventos*]
- O → [*función de salida*]
- C → [*Conjunto formado por*]
- P → [*sitios*]
- I → [*función de entrada*]

## 3 - Dada la siguiente definición matemática de Red de Petri, indicar cual es explicación correcta: "Una Red de Petri es un multigrafo bipartito dirigido".

1. [ ] Es un grafo en el cual desde un nodo puede partir hasta tres aristas o arcos de manera que su conjunto de vértices puede particionarse en dos conjuntos independientes donde las aristas tienen un sentido definido.
2. [ ] Es un grafo en el cual desde un nodo puede partir mas de una arista o arco de manera que su conjunto de vértices puede particionarse en dos conjuntos independientes donde las aristas tienen un sentido definido.
3. [x] Es un grafo en el cual desde un nodo puede partir mas de una arista o arco de manera que su conjunto de vértices puede particionarse en varios conjuntos independientes donde las aristas tienen un sentido definido.
4. [ ] Es un árbol en el cual desde un nodo puede partir varias aristas o arcos de manera que su conjunto de vértices puede particionarse en dos conjuntos independientes donde las aristas tienen un sentido definido.
5. [ ] Es un grafo en el cual desde un nodo puede partir mas de una arista o arco de manera que su conjunto de vértices puede particionarse en dos conjuntos independientes donde las aristas son relaciones simétricas y no apuntan en ningún sentido.

## 4 - En una Red de Petri los estados se representan como transiciones y los eventos como lugares o sitios.

- [ ] Verdadero.
- [x] Falso.

## 5 - Complete el texto con las palabras correctas:

### La ocurrencia de un evento está sujeta a que se den ciertas \___ y al ocurrir el evento causa que se hagan verdaderas las \___ . En las Redes de Petri el \___  en que ocurren los eventos es uno de los permitidos y son \___ . La ejecución es \___ . Se acepta que el disparo de una transición es \___ .

**La respuesta correcta es:** La ocurrencia de un evento está sujeta a que se den ciertas [*precondiciones*] y al ocurrir el evento causa que se hagan verdaderas las [*postcondiciones*]. En las Redes de Petri el [*orden*] en que ocurren los eventos es uno de los permitidos  y son [*asincrónicas*]. La ejecución es [*no determinística*]. Se acepta que el disparo de una transición es [*instantáneo*].

## 7 - Indicar para cada definición cual es la situacion del modelo de concurrencia.

- Es una forma de computación en la cual varios cálculos/procesos pueden realizarse simultáneamente. → [*Paralelismo*]
- Varios procesos pueden colaborar en la solución de un problema para eso necesitan compartir información y recursos pero esto debe ser controlado para asegurar la integridad y correcta operación del sistema. → [*Sincronización*]
- Es un bloqueo permanente de un conjunto de procesos o hilos de ejecución en un sistema concurrente que compiten por recursos del sistema o bien se comunican entre ellos. → [*Deadlock*]
- Estrategia que se utiliza para evitar que entre más de un proceso a la vez en la sección crítica (por ejemplo un recurso compartido como memoria, o impresora). → [*Exclusión mutua*]

## 8 - Selecciones las reglas del siguiente listado pueden definir la ejecución de la red:

1. [x] Una transición está habilitada si cada uno de sus lugares de entrada contiene tantos tokens como arcos haya desde el lugar de entrada a la transición.
2. [x] Una transición habilitada se puede disparar, removiéndose un token de cada lugar de entrada por cada arco que va desde ese lugar de entrada a la transición y colocando un token en cada lugar de salida por cada arco que haya de la transición al lugar de salida.
3. [ ] Al disparar una transición no es necesario distribuir todos los token, lo puedo hacer de a uno a la vez en diferentes momentos en diferentes disparos.
4. [ ] Una transición está habilitada si tengo al menos un token en uno de los lugares (sitios).
5. [x] Cada disparo de una transición modifica la distribución de las fichas, y por ello produce un nuevo marcado en la red.

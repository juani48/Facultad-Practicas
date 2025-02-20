## 1 - Si un proceso quiere modificar datos en un área compartida con otro proceso, puede hacerlo directamente si el otro proceso sólo accede en modo lectura

La respuesta correcta es: **Falso**.

## 2 - En el diseño de la E/S no bloqueante, un proceso que realiza una operación ___ su ejecución ___ .

La respuesta correcta es: **En el diseño de la E/S no bloqueante, un proceso que realiza una operación [continuara] su ejecución [por lo que debera consultar el estado de la operacion de forma explicita] .**

## 3 - Entre los servicios que se brindan en el diseño de la E/S de un SO se encuentran la planificación de requerimientos y buffering de datos. En cambio, el manejo de errores de los dispositivos es delegado a los procesos de usuario que quieran utilizar dichos dispositivos.

La respuesta correcta es: **Falso**.

## 4 - Los drivers de un dispositivo se ejecutan en modo kernel, aún cuando los mismos fueron diseñados por personas que no participan en el desarrollo del kernel de SO.

La respuesta correcta es: **Verdadero**.

## 5 - En el diseño de la Entrada/Salida de un sistema operativo, se busca:

- [ ] Modelar una forma diferente de hacer E/S para cada tipo de dispositivos.
- [x] Unificar la forma de hacer E/S de para todos los dispositivos.

## 6 - De las siguientes técnicas de administración de espacio de disco indique en cual(es) se puede producir fragmentación externa:

### 1. Indexada.
### 2. Enlazada.
### 3. Continua.

- [ ] Ninguna.
- [ ] 2 y 3.
- [ ] 1, 2 y 3.
- [ ] 1 y 3.
- [ ] 1.
- [x] 3.
- [ ] 1 y 2.

## 7 - En la técnica de administración de archivo indexada, el tamaño maximo de un archivo lo determina: 

- [x] La cantidad de índices definidos  en la estructura de datos utilizada.
- [ ] La cantidad máxima posible de entradas que puede tener un directorio
- [ ] La cantidad de entradas en la FAT 

## 8 - Para la gestión de espacio de disco, el uso de clusters de gran tamaño podrá causar fragmentación: 

- [ ] Tanto interna como externa.
- [x] Interna.
- [ ] Externa.
- [ ] No produce fragmentación.

## 9 - Suponiendo el manejo de espacio libre un disco por tabla de bits; la utilización de clusters de de 8 sectores de disco hará que la tabla de bits sea mas chica que si se utiliza clusters de 4 sectores de disco

La respuesta correcta es: **Verdadero**.

## 10 - Para los medios de almacenamiento que son solo lectura, como un CD-ROM, la mejor técnica para manejar el espacio de datos de los archivos es:

- [ ] Enlazada.
- [x] Continua.
- [ ] Indexada.

## 11 - Indique cual/cuales de las siguientes afirmaciones son correctas respecto al sistema de archivos de Unix System V visto en la teoría:

1. [ ] Todos los atributos de un archivo se encuentran en el I-Nodo.
2. [ ] La cantidad de indices de sectores/clusteres que se pueden utilizar por archivos es ilimitada.
3. [ ] El tamaño de la  tabla de I-Nodos es dinámico.
4. [x] La cantidad de indices a sectores/clusteres que se pueden utilizar por archivos es limitada.
5. [ ] Produce fragmentación interna.
6. [ ] Produce fragmentacion externa.

## 12 - En la administración de espacio de disco “Enlazada” estudiada, cada entrada de la FAT (para cada archivo) contiene una lista con las referencias a todos los bloques de cada archivo.

La respuesta correcta es: **Falso**.

## 13 - Un filesystem es un componente de hardware que define el formato de los archivos, sus estructuras  y brinda las operaciones necesarias para la manipulación de los mismos.

La respuesta correcta es: **Falso**.

## 14 - En Unix System V puede modificarse el contenido del archivo sin modificar su i-nodo.

La respuesta correcta es: **Falso**.

## 15 - Indique cual/cuales de las siguientes afirmaciones son validas si se modifica el nombre de un archivo en el sistema de archivos de Unix System V visto en la teoría:

1. [x] Se modifica el I-Nodo del directorio donde se encuentra ubicado el archivo.
2. [ ] Se modifica el tamaño de la tabla de I-Nodos.
3. [ ] Se modifica el I-Nodo del archivo al que se le cambio el nombre.
4. [ ] Se modifica el contenido del archivo al que se le cambio el nombre.
5. [x] Se modifica el contenido del directorio donde se encuentra ubicado el archivo.

## 16 - El siguiente gráfico representa la situación de buffer cache en Unix System V. Seleccione la/las opciones  que sucederá/n si un proceso P1 requiere el bloque 38 

1. [ ] En la free list, como primer header queda el que contiene al bloque 319 en estado DW, y a este le sigue header que contiene al bloque 117, también en estado DW.
2. [ ] El proceso deberá esperar porque la hash queue correspondiente al bloque que solicita no tiene un header en estado libre.
3. [x] El header que contiene el bloque 319 pasa  a estar en estado writing.
4. [x] Se toma el header que contiene el bloque 25 y se lo acomoda en la hash queue correspondiente al bloque 38.

## 17 - El siguiente gráfico representa la situación de buffer cache en Unix System V. Seleccione la/las opciones  que se sucederá/n si un proceso P1 requiere el bloque 36.

1. [ ] El proceso deberá esperar a que se libere el bloque.
2. [x] El proceso podrá utilizar el bloque directamente porque el mismo ya se encuentra en el buffer cache.
3. [ ] El header que contiene el bloque 36 pasara a estar a estado ocupado.

## 18 - Si un buffer delayed write está primero en la free list y un proceso solicita acceder al bloque que está “dentro” de este buffer. ¿Cuál(es) de las siguientes afirmaciones es/son válida(s)?:

1. Se escribe a disco y se asigna al proceso.
2. No se escribe a disco y se asigna al proceso.
3. El buffer pasa a estar ocupado.

- [ ] 2.
- [ ] 3.
- [ ] Ninguna.
- [ ] 1.
- [ ] 2 y 3.
- [x] 1 y 3.

## 19 - En la técnica de Buffer Cache vista, todos los buffers que se encuentran en la free list están vacíos (sin bloques de disco).

La respuesta correcta es: **Falso**.

## 20 - En la técnica de buffer cache vista en la teoría, de Unix System V,  cuando un header en estado ocupado es liberado y el proceso que lo tenia había modificado el contenido del bloque, es:

- [x] Colocado al final de la free list.
- [ ] Colocado al comienzo de la free list.

## 21 - En una arquitectura de 32 bits con tablas de paginas de 2 niveles donde se utilizan: 10 bits para el primer nivel, 10 bits para el segundo nivel y 12 bits para desplazamiento, y tamaño de la palabra de 1 byte,  la cantidad maxima de paginas que un proceso puede tener es 210 * 210

La respuesta correcta es: **Verdadero**.

## 22 - Suponiendo que en un SO se produce una situación de hiperpaginación. Disminuir el grado de multiprogramación ayudará a que mejore la productividad de la CPU.

La respuesta correcta es: **Verdadero**.

## 23 - En la técnica de administración de memoria con paginación donde se utiliza una Tabla de Páginas Invertida existe: 

- [ ] Una tabla invertida por proceso.
- [x] Una tabla invertida para todas las paginas que se encuentran cargadas en memoria principal.
- [ ] Una tabla de paginas invertida por cada proceso y una tabla general para todas las paginas que se encuentran cargas en memoria principal. 

## 24 - ¿Cuál/Cuáles de las siguientes opciones es correcta acerca del Translation Lookaside Buffer (TLB)?

1. [ ] Existe una única TLB y sus entradas con compartidas por todos los procesos.
2. [ ] Sus entradas son administradas por el Kernel.
3. [x] Es una memoria caché que contiene las entradas de la tabla de páginas usadas recientemente.
4. [x] Los cambios de contexto invalidan la TLB.
5. [x] Si todas las entradas buscadas generan un TLB MISS, su uso perjudica al tiempo de resolución.
6. [ ] Para realizar una resolución de direcciones, primero se verifica en la tabla de páginas y si el bit de validez es 0, se analiza la TLB.

## 25 - La selección de una página víctima con los bits R=0 y M=1 resulta óptima frente a una cuyos valores de los bits es R=1 y M=0.

La respuesta correcta es: **Verdadero**.

## 26 - Cuál de las siguientes técnicas de reemplazo de páginas favorece al control de tasa de fallo de páginas de un proceso

- [ ] Reemplazo Global.
- [ ] Se puede controlar tanto con reemplazo global como local.
- [x] Reemplazo Local.

## 27 - En el modelo del Working Set la elección de un Δ (delta) demasiado grande en un momento dado causara que los procesos no cuenten con todas las paginas necesarias.

La respuesta correcta es: **Falso**.

## 28 - En la técnica del working set para aproximarse al modelo de localidad la selección de un delta ( Δ ) ___ causara que en el conjunto de trabajo de un momento dado el proceso no cuente con toda su localidad.

La respuesta correcta es: **En la técnica del working set para aproximarse al modelo de localidad la selección de un delta ( Δ ) [chico] causara que en el conjunto de trabajo de un momento dado el proceso no cuente con toda su localidad.**

## 29 - Un tamaño de página ___ resulta beneficioso para subir o bajar  páginas del disco de la computadora.  

La respuesta correcta es: **Un tamaño de página [grande] resulta beneficioso para subir o bajar  páginas del disco de la computadora.**

## 30 - Cuando en la técnica de frecuencia de fallo de página todos los procesos se tienen una frecuencia mayor que el límite superior definido y no hay marcos libres nos encontramos con el problema de Hiperpaginacion.  

La respuesta correcta es: **Verdadero**.

## 31 - Dado un SO que se encuentra con hiperpaginación (trashing), aumentar el grado de multiprogramación ayudará a que el problema se resuelva.

La respuesta correcta es: **Falso**.

## 32 - Todo fallo de página que causa la ejecución de un proceso generará al menos dos operaciones de E/S: una escritura de una página en el área de intercambio y otra de la lectura de la página que corresponde a la dirección que género el fallo en si.

La respuesta correcta es: **Falso**.

## 33 - Siempre que la página buscada no se encuentre en la TLB (TLB miss) se producirá un fallo de pagina.

La respuesta correcta es: **Falso**.

## 34 - Para una gestión eficiente del área de intercambio (Swap Area) indique cual/cuales de las siguiente opciones deberán ser guardadas en la misma:

1. [ ] Páginas del código del proceso.
2. [x] Páginas de los stacks.
3. [ ] Páginas del código de librerías utilizadas por el proceso.
4. [ ] Páginas del código del Kernel.
5. [x] Páginas de datos (variables).
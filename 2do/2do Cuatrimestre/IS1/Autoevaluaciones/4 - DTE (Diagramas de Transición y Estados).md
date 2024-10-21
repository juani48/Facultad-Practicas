## 1 - Complete el texto con las palabras correctas:

### Una máquina de estados finitos describe al sistema como un conjunto de \___ donde el sistema reacciona a ciertos \___ posibles \___ o internos. Una máquina de estado finito es algo más general que un \___ . Las máquinas de estado finito se modelizan como una \___ aplicada a un estado y un \___ que nos devuelve un nuevo estado de nuestro sistema.

**La respuesta correcta es:** Una máquina de estados finitos describe al sistema como un conjunto de [*estados*] donde el sistema reacciona a ciertos [*eventos*] posibles [*externos*] o internos. Una máquina de estado finito es algo más general que un [*diagrama de transición y estados*]. Las máquinas de estado finito se modelizan como una [*función*] aplicada a un estado y un [*estímulo*] que nos devuelve un nuevo estado de nuestro sistema.

## 2 -Un autómata finito (AF) puede ser descrito como una 5-tupla (S,Σ,T,s,A). Seleccione la definición correcta para cada componente de la 5-tupla:

- Σ → [*alfabeto*]
- s (minúscula) → [*el estado inicial*]
- T → [*la función de transición*]
- A → [*un conjunto de estados de aceptación o finales*]
- S (mayúscula) → [*un conjunto de estados*]
 
## 3 - Complete el texto con las palabras correctas sobre la definición de los Diagramas de Transición y estados:

### Un diagrama de transición de estados muestra el \___ dependiente del \___ de un sistema de información. Representa los \___ que puede tomar un componente o un sistema y muestra los \___ que implican el cambio de un estado a otro.

**La respuesta correcta es:** Un diagrama de transición de estados muestra el [*comportamiento*] dependiente del [*tiempo*] de un sistema de información. Representa los [*estados*] que puede tomar un componente o un sistema y muestra los [*eventos*] que implican el cambio de un estado a otro.

## 4 - Una transición es una relación entre dos estados que están unidos por una flecha, identificando a una situación particular en un estado primario donde se realizará una acción específica y que pasará a un segundo estado, cuando ocurra un evento y se cumplan unas condiciones específicas

- [x] Verdadero.
- [ ] Falso.

## 5 - El Diagrama de transición y estados (DTE) es una técnica de especificación estática porque no describe como el sistema responde a eventos

- [ ] Verdadero.
- [x] Falso.

**Justifiacion:** Es falso, es dinámica porque justamente, especifica un sistema en función de los cambios que ocurren a lo largo del tiempo.

## 6 - Indique en el siguiente listado cuáles identifica con eventos y cuáles son acciones de un DTE.

- Paso de cierto período de tiempo, después de entrar al estado actual, o de cierta hora y fecha concretas. → [*evento*]
- Liberar habitación. → [*acción*]
- Crear un archivo. → [*acción*]
- Recepción de una llamada para realizar una operación. → [*evento*]
- Modificar la hora. → [*acción*]
- Recepción de una señal. → [*evento*]

## 7 - Mediante la descripción de las transiciones es posible describir con más detalle las condiciones bajo las cuales se abandona un estado para pasar al siguiente.

- [x] Verdadero.
- [ ] Falso.

## 8 - Ordena los pasos para crear un DTE:

1. [*Identificar los estados*]
2. [*Si hay un estado complejo se puede explotar*]
3. [*Se identifica el estado inicial*]
4. [*Se identifican los cambios de estado con flechas*]
5. [*Se analizan las condiciones y las acciones*]
6. [*Se verifica la consistencia*]

## 9 - Según lo visto en teoría identifique para el siguiente problema cuales son estados y cuales transiciones (evento, condición o acción).

### La fotocopiadora estará apagada durante los fines de semana. Los lunes se enciende y se queda en modo hibernación hasta que llega un usuario a fotocopiar. El usuario debe introducir el dinero y cuando lo considere oportuno pulsa el número de copias que desea hacer, o simplemente pulsa fotocopiar si por defecto quiere hacer una sola copia. Si no hubiera dinero suficiente para hacer las copias requeridas se lo indicará al usuario. Cuando ha terminado de hacer las copias muestra el saldo disponible. Si el usuario ha terminado de fotocopiar debe poder recuperar el dinero que quede en la fotocopiadora. Los sábados a las 10 de la mañana la fotocopiadora se apaga y vuelve a encenderse los lunes a las 7 de la mañana.

- Devolver dinero. → [*acción*]
- Pidiendo número de copias. → [*estado*]
- Esperando dinero. → [*estado*]
- Operación completada. → [*evento*]
- Fotocopiadora lista. → [*evento*]
- Encender fotocopiadora. → [*acción*]
- Aceptando dinero. → [*estado*]
- Dinero no suficiente. → [*condición*]
- Dinero suficiente. → [*condición*]
- Calentando. → [*estado*]
- Pulsa copiar. → [*evento*]
- Devolviendo dinero. → [*estado*]


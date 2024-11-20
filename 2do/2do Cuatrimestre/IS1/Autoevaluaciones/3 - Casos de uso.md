## 1 - Los elementos de modelado de un Diagrama de Casos de Uso son:

1. [ ] Actores- Casos de Uso- Sistema.
2. [ ] Casos de Uso- Sistema- Subsistemas.
3. [ ] Actores- Casos de Uso- Subsistemas.
4. [x]Actores- Casos de Uso- Relaciones.

## 2 - Los principales propósitos de los Casos de uso (CU) son:

1. [x] Describir los requerimientos funcionales del sistema.
2. [ ] Relacionar las funciones del sistema con las clases del sistema.
3. [ ] Presentar un orden cronológico de la funcionalidad del sistema.
4. [ ] Identificar los requerimientos no funcionales del sistema.
5. [x] Identificar los roles que interactúan con el sistema.

## 3 - Seleccione los pasos generales que se corresponden con el proceso de modelado de los CU:

1. [x] Identificar los casos de uso para los requerimientos.
2. [ ] Definir en un diagrama de contexto el alcance del sistema.
3. [ ] Hacer minutas de las reuniones de definición de casos de uso.
4. [ ] Revisar los manuales de usuario de sistemas similares para realizar documentación del sistema  a desarrollar.
5. [ ] Crear una épica  como un conjunto de casos de uso que se agrupan por algún denominador común.
6. [x] Construir un diagrama para el modelo de casos de uso.
7. [x] Documentar las narraciones de casos de uso para los requerimientos.
8. [x] Identificar a los actores.

## 4 - Seleccione las características que definen a un actor:

1. [x] Puede modelar a una persona, un subsistema, un dispositivo, el tiempo.
2. [ ] Puede modelar a una persona y un subsistema pero no a un dispositivo ni al tiempo.
3. [ ] Puede modelar al sistema en desarrollo.
4. [x] Modela un tipo de rol que interacciona con el sistema.
5. [ ] Es interno al sistema.

## 5 -Dado el siguiente problema  seleccione los casos de uso que se corresponden con el actor "usuario":
### Sokoban es un juego de varios niveles. Cada nivel está compuesto por un jugador, cajas, repisas y muros. El objetivo del jugador es empujar todas las cajas sobre las repisas. Cuando esto sucede el jugador pasa al siguiente nivel. Para mover una caja, el jugador debe colocarse al lado y empujarla. Si la casilla hacia la que está empujando la caja está libre la caja se moverá. Si el jugador se queda bloqueado, es decir, no puede terminar el nivel, puede reiniciar el nivel perdiendo una vida. Cuando el jugador pierde todas sus vidas la partida termina. Se requiere que el sistema debe permitir comenzar una nueva partida y terminarla. El sistema debe permitir mover al jugador y a las cajas y reiniciar el nivel cuando el usuario lo solicite. El sistema deberá almacenar varios niveles y cambiar de nivel cuando el usuario complete el nivel actual.

1. [ ] Cambiar de nivel.
2. [ ] Cargar un nivel.
3. [ ] Terminar la partida.
4. [x] Mover jugador.
5. [x] Reiniciar nivel.
6. [] Iniciar partida.

## 6 - Seleccione la palabra que define el concepto presentado:

- Un caso de uso que reduce la redundancia entre dos o más casos de uso al combinar los pasos comunes existentes en estos casos. → [*Uso o inclusión*]
- Cuando dos o más actores comparten un comportamiento común (en otras palabras, pueden iniciar el mismo caso de uso) lo mejor es extrapolar este comportamiento común y asignarlo a un nuevo actor resumen con objeto de reducir la comunicación redundante con el sistema. → [*Herencia*]
- Un caso de uso que consiste en los pasos extraídos de otro más complejo para simplificar el caso original y, así, ampliar su funcionalidad. Este tipo de caso de uso hace algo que no hace la funcionalidad del caso de uso original. →[*Extensión*]
- Relación entre un actor y un caso de uso en la que interactúan entre sí. → [*Asociación*]
- Cualquier cosa que necesite interactuar con el sistema para intercambiar información. → [*Actor*]

## 7 - Coloque la palabra que define adecuadamente a cada descripción presentada de los componentes de los escenarios de los CU:

- Es la descripción del comportamiento si ocurre una excepción o variación del curso típico. → [*Curso alterno*]
- Es una restricción del estado del sistema antes de la ejecución del caso de uso. En general, esto se refiere a otro caso de uso que debe ejecutarse previamente. → [*Precondición*]
- Es una restricción del estado del sistema después que el caso de uso ha sido ejecutado con éxito. Esto podría ser datos registrados en una base de datos o un recibo entregado a un cliente. → [*Postcondición*]
- Son los involucrados que se benefician del caso de uso al recibir algo de valor medible u observable. → [*Actores*]
- Representa la interacción entre el actor y el sistema sin errores ni condiciones → [*Curso normal*]

## 8 - Seleccione aquellas preguntas que realizaría para poder identificar los "actores" de un sistema:

1. [x] ¿Se requieren interfaces con otros sistemas?
2. [ ] ¿Quién se encargará de las pruebas de aceptación del sistema?
3. [ ] ¿Quién realizará el manual de usuario del sistema?
4. [x] ¿Quién le proporciona entradas al sistema?
5. [x] ¿Existen eventos que son originados automáticamente en un instante predeterminado?
6. [ ] ¿Quién determina si el sistema es viable para su desarrollo?
7. [x] ¿Quién o qué recibe salidas del sistema?
8. [ ] ¿Necesita el sistema informar al actor de cambios o eventos que hayan ocurrido? 

## 9 - Un curso alterno de eventos en el escenario de CU son  las actividades realizadas por el(los) actor(es) y por el sistema con objeto de satisfacer la meta del caso de uso. Se incluyen las interacciones entre el sistema y el actor y las actividades realizadas por el sistema como respuesta a las interacciones.

- [ ] Verdadero
- [x] Falso 

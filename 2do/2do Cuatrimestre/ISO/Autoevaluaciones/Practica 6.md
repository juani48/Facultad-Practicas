## 1 - ¿Cual de los siguientes algoritmos puede causar inanición?
- [x] SSTF
- [ ] FCFS
- [ ] SCAN

## 2 - ¿Qué valores son necesarios para calcular el tiempo de acceso a disco?
- [x] El valor de seek, el de latencia, la cantidad de bloques del archivo y la velocidad de transferencia de un bloque.
- [ ] El valor de latencia, la cantidad de bloques del archivo y la velocidad de transferencia de un bloque. El seek se deduce en función de la latencia.
- [ ] Solamente es necesario la cantidad de bloques y la velocidad de transferencia del bloque.

## 3 - Considere el concepto de inanición y la planificación de discos y responda cual/es de las siguientes afirmaciones son correctas:
- [x] El algoritmo SSTF puede causar inanición.
- [ ] No son conceptos que esten directamente relacionados.
- [ ] Todos los algoritmos de planificación de discos pueden causar inanición.

## 4 - Considere el sentido de giro de los algoritmos de planificacion de disco circulares y responda cual/es afirmaciones son verdaderas:
- [ ] Ningún algoritmo puede romper con su sentido de giro.
- [ ] Rompe el sentido de giro siempre que atiene un PF.
- [x] A veces rompen el sentido de giro cuando atiene un PF.
- [ ] Depende de la tecnología del hardware subyacente.

## 5 - Considere los conceptos de fallo de página y planificación de disco en indique cual/es afirmaciones son correctas:
- [x] Los planificadores de discos priorizan la atención de los PF.
- [ ] Son dos conceptos que no tienen relacion directa.
- [ ] Algunos planificadores de disco tratan a los PF como requerimientos ordinarios.

## 6 - El objetivo principal de la planificación de discos es:
- [ ] Atender el orden en que los procesos requieren de E/S a disco.
- [x] Minimizar el tiempo de seek.
- [x] Minimizar el tiempo de acceso al disco.

## 7 - Indique cual cree que es el orden evolutivo de las tecnicas de E/S.
- [ ] 1ro E/S por interrupciones, 2d DMA, 3ro E/S programada.
- [x] 1ro E/S programada, 2do E/S por interrupciones, 3ro DMA
- [ ] 1ro E/S por interrupciones, 2do E/S programada, 3ro DMA

## 8 - Suponga que cada I-NODO contiene 3 direcciones a bloques de datos organizados con 2 direccionamientos directos y 1 direccionamiento indirecto simple, donde cada bloque de datos es de 1 Kib (Kibibit) y cada dirección para referenciar un bloque es de 32 bits. Indique cuantas referencias (direcciones) a bloque puede contener esta estructura de I-NODO.
- [ ] 258
- [x] 34
- [ ] 256
- [ ] No tengo los datos suficientes.

## 9 - Suponga que cada I-NODO contiene 3 direcciones a bloques de datos organizados con 2 direccionamientos directos y 1 indirecto simple, donde cada bloque de datos es de 1 Kib (Kibibit) y cada dirección para referenciar un bloque es de 32 bits. Indique cual seria el tamaño máximo de un archivo.
- [ ] 256 KiB
- [x] 32 KiB
- [ ] 4 GiB
- [ ] 258 KiB

## 10 - Supongamos que un disco gira a 5400 RPM, cual seria el valor de latencia medio:
- [ ] 11 ms
- [ ] 9,2 ms
- [x] 5,5 ms
- [ ] 5,68 ms

## 11 - Supongamos un disco con 4 platos, con 2 caras útiles, 2000 pistas por cara y 600 sectores por pista de 512 bytes cada uno. ¿Cual(es) de las siguientes opciones refleja(n) el tamano total del disco?
- [ ] 4800 KiB
- [x] 4687.5 MiB
- [x] 4800000 KiB
- [ ] 4915200 MiB

## 12 - Si tengo que obtener un byte que se encuentra el nivel de indireccionamiento simple, ¿cuantos accesos a disco tengo se realizan?
**La respuesta correcta es:** 2

## 13 - Cuando se atienden requerimiento de un disco, los que corresponden a un PF son prioritarios
- [x] Verdadero 
- [ ] Falso

## 14 - La mayor degradación en el tiempo de acceso al disco corresponde al tiempo de latencia.
- [ ] Verdadero 
- [x] Falso

## 15 - Para obtener el INodo de un archivo el SO debe acceder al disco
- [ ] Verdadero 
- [x] Falso
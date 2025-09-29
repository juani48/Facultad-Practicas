## Esquema
MEDICION_AMBIENTAL(#medicion, #pozo, valor_medicion, #parametro, fecha_medicion, cuil_operario, #instrumento, nombre_parametro, valor_ref, descripcion_pozo, fecha_perforacion, apellido_operario, nombre_operario, fecha_nacimiento, marca_instrumento, modelo_instrumento, dominio_vehiculo, fecha_adquisicion)

### Donde:
- Cada medición es realizada por un operario en un pozo, en una fecha determinada. En ella se miden varios parámetros, y para cada uno se obtiene un valor. Notar que un mismo parámetro (#parametro) puede ser medido en diferentes mediciones. Independientemente de las mediciones, todo parámetro tiene un nombre y valor de referencia, y el #parametro es único en el sistema.
- En cada medición se utilizan varios instrumentos, independientemente de los parámetros medidos. De cada instrumento se conoce la marca y modelo.
- De cada operario se conoce su cuit, nombre, apellido y fecha de nacimiento.
- La empresa cuenta con vehículos, y de cada uno se conoce la fecha en la que fue adquirido. El dominio (patente) de cada vehículo es único en el sistema.
- Un pozo tiene una descripción y una fecha de perforación. El identificador #pozo es único en el sistema.

### DF
- df1: cuil_operario, #pozo, fecha_medicion -> #medicion
- df2: #medicion, #parametro -> nombre_parametro, valor_ref
- df3: #instrumento -> marca_instrumento, modelo_instrumento
- df4: cuil_operario -> apellido_operario, nombre_operario, fecha_nacimiento
- df5: dominio_vehiculo -> fecha_adquisicion
- df6: #pozo -> descripcion_pozo, fecha_perforacion
- df7: #medicion -> valor_medicion

### CC
cc1: (**cuil_operario, #pozo, fecha_medicion,  #parametro, #instrumento, dominio_vehiculo**)

## BCNF

El esquema MEDICION_AMBIENTAL no se encuentra en BCNF porque dada la df3 se cumple al menos que {#instrumento} no es superclave en el esquema.

- MA1 (**#instrumento**, marca_instrumento, modelo_instrumento)
- MA2 (#medicion, #pozo, valor_medicion, #parametro, fecha_medicion, cuil_operario, #instrumento, nombre_parametro, valor_ref, descripcion_pozo, fecha_perforacion, apellido_operario, nombre_operario, fecha_nacimiento, dominio_vehiculo, fecha_adquisicion)

No se pierde informacion porque MA1 interseccion MA2 es superclave en MA1 y no se pierden dependencias funcionales porque dada la df3 se cumple en MA1 y dada las df1, df7, df2, df4, df5 y df6 se cumplen en MA2.

MA1 se encuentra en BCNF porque dada la df3 se cumple que {#instrumento} es superclave en la particion.

MA2 no se encuentra en BCNF porque dada la df5 se cumple al menos que {dominio_vehiculo} no es superclave en la particion.

- MA3 (**dominio_vehiculo**, fecha_adquisicion)
- MA4 (#medicion, #pozo, valor_medicion, #parametro, fecha_medicion, cuil_operario, #instrumento, nombre_parametro, valor_ref, descripcion_pozo, fecha_perforacion, apellido_operario, nombre_operario, fecha_nacimiento, dominio_vehiculo)

No se pierde informacion porque MA3 interseccion MA4 es superclave en MA3 y no se pierden dependencias funcionales porque dada la df5 se cumple en MA3 y dada las df1, df7, df2, df4 y df6 se cumplen en MA4.

MA3 se encuentra en BCNF porque dada la df5 se cumple que {dominio_vehiculo} es superclave en la particion.

MA4 no se encuentra en BCNF porque dada la df4 no se cumple que {cuil_operario} es superclave en la particion.

- MA5 (**cuil_operario**, apellido_operario, nombre_operario, fecha_nacimiento)
- MA6 (#medicion, #pozo, valor_medicion, #parametro, fecha_medicion, cuil_operario, #instrumento, nombre_parametro, valor_ref, descripcion_pozo, fecha_perforacion, dominio_vehiculo)

No se pierde informacion porque MA5 interseccion MA6 es superclave en MA5 y no se pierden dependencias funcionales porque dada la df4 se cumple en MA5 y dada las df1, df7, df2 y df6 se cumplen en MA6.

MA5 se encuentra en BCNF porque dada la df4 {cuil_operario} es superclave en la particion.

MA6 no se encuentra en BCNF porque dada la df6 se cumple al menos que {#pozo} no es superclave en la particion.

- MA7 (**#pozo**, descripcion_pozo, fecha_perforacion)
- MA8 (#medicion, #pozo, valor_medicion, #parametro, fecha_medicion, cuil_operario, #instrumento, nombre_parametro, valor_ref, dominio_vehiculo)

No se pierde informacion porque MA7 interseccion MA8 es superclave en MA7 y no se pierden dependencias funcionales porque dada la df6 se cumple en MA7 y dada las df1, df7 y df2 se cumplen en MA8.

MA7 se encuentra en BCNF porque dada la df6 se cumple que {#pozo} es superclave en la particion.

MA8 no se encuentra en BCNF porque dada la df2 se cumple al menos que {#medicion, #parametro} no son superclave de la particion.

- MA9 (**#medicion, #parametro**, nombre_parametro, valor_ref)
- MA10 (#medicion, #pozo, valor_medicion, #parametro, fecha_medicion, cuil_operario, #instrumento, dominio_vehiculo)

No se pierde informacion porque MA9 interseccion MA10 es superclave MA9 y no se pierden dependencias funcionales porque dada la df2 se cumple en MA9 y dadas las df1 y df7 se cumple en MA10.

MA9 se encuentra en BCNF porque dada la df2 se cumple que {#medicion, #parametro} son superclave en la particion.

MA10 no se cuentra en BCNF porque dada la df7 se cumple al menos que {#medicion} no es superclave de la particion.

- MA11 (**#medicion**, valor_medicion)
- MA12 (#medicion, #pozo, #parametro, fecha_medicion, cuil_operario, #instrumento, dominio_vehiculo)

No se pierde informacion porque MA11 interseccion MA12 es superclave en MA11 y no se pierden dependencias funcionales porque dada la df7 se cumple en MA11 y dada la df1 se cumple en MA12

MA11 se encuntra en BCNF porque dada la df7 se cumple que {#medicion} es superclave en la particion.

MA12 no se encuentra en BCNF porque dada la df1 se cumple al menos que {cuil_operario, #pozo, fecha_medicion} no son superclave en la particion

- MA13 (**cuil_operario, #pozo, fecha_medicion**, #medicion)
- MA14 (**#pozo, #parametro, fecha_medicion, cuil_operario, #instrumento, dominio_vehiculo**)

No se pierde informacion porque MA13 interseccion MA14 es superclave en MA13 y no se pierden dependencias funcionales porque dada la df1 se cumple en MA13.

MA13 se encuntra en BCNF porque dada la df1 se cumple que {cuil_operario, #pozo, fecha_medicion} es superclave de la particion.

MA14 se encuntra en BCNF porque para los atributos de la particion la unica dependencia funcional es trivial.

## 4FN

Las particiones MA1, MA3, MA5, MA7, AM9, MA11, MA13 se encuntran en 4FN porque no presentan dependencias multivaludas.

### DM

En la particion MA14 se ecuntran las siguientes dependencias multivaluadas:
- dm1: cuil_operario, #pozo, fecha_medicion ->> #instrumento
- dm2: cuil_operario, #pozo, fecha_medicion ->> #parametro
- dm3: cuil_operario, #pozo, fecha_medicion ->> dominio_vehiculo

MA14 no se encuentra en 4FN porque dada la dm1 se cumple al menos que {cuil_operario, #pozo, fecha_medicion} multidetermina {#instrumento} y no es una dependencia multivaluada trival

- MA15 (**#pozo, fecha_medicion, cuil_operario, #instrumento**)
- MA16 (**#pozo, #parametro, fecha_medicion, cuil_operario, dominio_vehiculo**)

MA15 se encuentra en 4FN porque dada la dm1 se cumple que {cuil_operario, #pozo, fecha_medicion} multidetermina {#instrumento} y es una DM trivial

MA16 no se ecuentra en 4FN porque dada la dm2 se cumlpe al menos que {cuil_operario, #pozo, fecha_medicion} multidetermina {#parametro} y no es una DM trivial

- MA17 (**#pozo, fecha_medicion, cuil_operario, #parametro**)
- MA18 (**#pozo, fecha_medicion, cuil_operario, dominio_vehiculo**)

MA17 se encuentra en 4FN porque dada la dm2 se cumple que {cuil_operario, #pozo, fecha_medicion} multidetermina {#parametro} y es una DM trivial

MA18 se encuentra en 4FN porque dada la dm3 se cumple que {cuil_operario, #pozo, fecha_medicion} multidetermina {dominio_vehiculo} y es una DM trivial

## Esquema final
- MA1 (**#instrumento**, marca_instrumento, modelo_instrumento)
- MA3 (**dominio_vehiculo**, fecha_adquisicion)
- MA5 (**cuil_operario**, apellido_operario, nombre_operario, fecha_nacimiento)
- MA7 (**#pozo**, descripcion_pozo, fecha_perforacion)
- MA9 (**#medicion, #parametro**, nombre_parametro, valor_ref)
- MA11 (**#medicion**, valor_medicion)
- MA13 (**cuil_operario, #pozo, fecha_medicion**, #medicion)
- MA15 (**#pozo, fecha_medicion, cuil_operario, #instrumento**)
- MA17 (**#pozo, fecha_medicion, cuil_operario, #parametro**)
- MA18 (**#pozo, fecha_medicion, cuil_operario, dominio_vehiculo**)

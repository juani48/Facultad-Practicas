## Un atributo compuesto polivalente
1. [ ] Puede ser un atributo derivado.
2. [x] Puede contener atributos simples opcionales pero monovalentes.
3. [ ] Debe estar definido en una entidad del modelo conceptual.
4. [ ] Ningun de las anteriores es correcto.

## Una relacion ternaria sobre el modelo logico
1. [ ] Puede ser muchos a muchos, optativa y obligatoria segun el caso.
2. [ ] Debe ser una relacion muchos a muchos.
3. [ ] Puede contener atributos polivalentes.
4. [x] Ninguna de las anteriores.

## Una dependencia mutivaluada trivial
1. [ ] Define un tipo de dependencia que no afecta la normalizacion de la tabla.
2. [ ] La tabla que contiene dependencias de este tipo se encuentra necesariamente en 4TF (4ta forma normal).
3. [ ] Es una condición suficiente para indicar que la tabla cumple las reglas de normalización.
4. [x] Ninguna de las anteriores es correcta.

## Un lenguaje de consultas procedimental
1. [ ] Es más eficiente que un lenguaje no procedimental.
2. [x] Permite describir una consulta indicando la respuesta que se desea y los pasos necesarios para obtener el resultado.
3. [ ] Se aplica a cualquier base de datos independientemente del tipo que se trate.
4. [ ] Ninguna de las anteriores es correcta.

## El lenguaje de manipulación de datos de SQL
1. [x] Siempre incluye sentencias que indique sobre que tabla realizar la operación.
2. [ ] Puede filtrar con el operando HAVING a tuplas que satisfagan una determinada condición.
3. [ ] Está presente en algunos DMBS relacionales.
4. [ ] Ninguna de las anteriores es correcta.

## El protocolo de aseguramiento de atomicidad en transacciones conocido como doble dispersión
1. [ ] Es más eficiente en la recuperación de datos en caso de error que el protocolo de bitácora.
2. [ ] Manipula dos tablas una actual y una a la sombra.
3. [ ] Requiere dividir la BD en sectores o bloques lógicos y físicos.
4. [x] Ninguna de las anteriores es correcta.
> La doble dispercion solo ocurre en hashing. 1, 2 y 3 son sobre doble paginacion.

## La propiedad de durabilidad
1. [x] Solo tiene sentido de aplicarse en entornos concurrentes.
2. [ ] Puede generar graves inconvenientes en un entorno monousuario si no es tenida en cuenta.
3. [ ] Es la propiedad más importante cuando se manipulan transacciones.
4. [ ] Ninguna de las anteriores es correcta.

## Una operación de consulta sobre una BD (Base de Datos)
1. [x] Puede ser optimizada por el DBMS para realizarla más eficiente.
2. [ ] El DBMS genera índices temporales para resolver la consulta más eficiente.
3. [ ] Requiere realizar primero una operación de producto natural.
4. [ ] Requiere ser analizada por el DBA para mejorar su perfomance.
5. [ ] Ninguna de las anteriores es correcta
> El DMS puede generar indices temporales.

## Sea un ciclo entre tres entidades A, B y C, que a partir de $R_{1}$, $R_{2}$ y $R_{3}$. En los tres casos $R_{i}$ es una relación muchos a muchos
1. [ ] El ciclo puede atentar contra la minimalidad.
2. [ ] El ciclo atenta contra la minimalidad.
3. [x] El ciclo no representa problema alguno respet de la minimalidad.
4. [ ] No tengo datos suficientes para responder.
> 1 y 4 se anulan entre si.

## La integridad referencial existente entre dos tablas
1. [x] Utiliza necesariamente el concepto de clave foránea.
2. [ ] Indica que el borrado de un elemento en una tabla está imposibilitado en determinadas circunstancias.
3. [ ] Debe tener definido modificación en cascada cuando se altera una clave primaria de alguna de las tablas involucradas siendo esta un atributo autoincremental.
4. [ ] Ninguna de las anteriores es correcta.

## Un esquema físico que no tiene dependencias parciales esta en:
1. [ ] 3FN (3ra forma normal).
2. [ ] 5FN (5ta forma normal).
3. [ ] 2FN (2da forma normal).
4. [ ] 1FN (1ra forma normal).
5. [ ] 4FN (4ta forma normal).
6. [ ] BCNF (forma normal Boyce Codd).
7. [ ] Todas las anteriores.
8. [ ] Algunas de las anteriores.
9. [x] Ninguna de las anteriores.
> No se dice si el modelo se ecuntra en 1FN (1ra forma normal)

## Se tiene una jerarquía total exclusiva en el modelo conceptual. Al pasar dicho modelo al lógico se debe decidir qué hacer con la misma. Sabiendo que la cobertura es exclusiva, entonces:
1. [ ] Se puede dejar solo al padre.
2. [ ] Se puede dejar solo a los hijos.
3. [ ] Se puede dejar todas las entidades.
4. [x] Todas las anteriores son validas.
5. [ ] Algunas de las anteriores son validas.
6. [ ] No tengo datos suficientes para responder.
> Aunque fuera superpuestas la correcta es la 4.

> Si se trata de un cobertura *parcial* es la 5.

## En algebra relacional la expresión $A\ x\ B$ da el mismo resultado que:
1. [ ] $A\ x\ B$
2. [ ] $A\ x\ B$ Si entre las tablas A y B no hay atributo común.
3. [x] $B\ |x|\ A$
4. [ ] Todas las anteriores.
5. [ ] Algunas de las Anteriores
6. [ ] Ninguna de las anteriores.
> Otra respuesta pobile es la 5 = (2 y 3).

## Un checkpoint en ambientes concurrentes
1. [ ] Solo se genera si se utiliza el protocolo de HDE.
2. [ ] Solo se genera si se utiliza el protocolo de dos fases.
3. [ ] Se aplica en el protocolo de doble paginación.
4. [ ] Se coloca siempre entre dos transacciones, cuando ninguna esta activa.
5. [ ] Todas las anteriores.
6. [ ] Algunas de las anteriores.
7. [X] Ninguna de las anteriores

## Las funciones de agregación en una consulta SQL
1. [ ] Pueden ir en el SELECT.
2. [ ] Pueden ir en el WHERE.
3. [ ] Pueden ir en el HAVING.
4. [ ] Pueden aparecer sin otros atributos en el SELECT.
5. [ ] Todas son correctas.
6. [ ] 1, 2 y 4 son correctas.
7. [ ] 1, 2 y 3 son correctas.
8. [x] 1 y 3 son correctas.

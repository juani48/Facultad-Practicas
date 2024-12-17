## 1 - Un modelo conceptual
1. [x] Debe contener entidades y relaciones.
2. [ ] Debe contener jerarquías.
3. [ ] Debe contener atributos polivalentes.
4. [ ] Ninguna de las anteriores.

## 2 - Un atributo derivado
1. [ ] Puede ser identificador.
2. [ ] No puede pertenecer a una relación.
3. [x] Atenta contra la minimalidad del problema.
4. [ ] Si atenta contra la minimalidad, se quita en el modelo lógico.

## 3 - Un atributo polivalente sobre el modelo físico
1. [ ] Puede tener cardinalidad mínima 0.
2. [ ] Puede tener cardinalidad mínima 1.
3. [ ] Debe tener cardinalidad máxima N 
4. [x] Ninguna de las anteriores.

## 4 - Una clave candidata
1. [x] Puede transformarse en clave primaria.
2. [ ] Debe transformarse en clave primaria
3. [ ] Puede no ser identificador en el esquema físico.
4. [ ] Puede no ser identificador en el esquema lógico.

## 5 - Si una tabla se encuentra en BCNF
1. [ ] Puede estar primera, segunda y tercera FN.
2. [ ] Está en primera, segunda y cuarta FN.
3. [x] Puede estar en cuarta FN.
4. [ ] Tiene dependencias multivaluadas.

## 6 - Una relación recursiva sobre el modelo lógico
1. [ ] Debe ser muchos a muchos.
2. [ ] Debe ser obligatoria de al menos un lado.
3. [x] Debe tener definida cardinalidad.
4. [ ] Debe tener algún atributo.

## 7 - La integridad referencial entre dos tablas
1. [x] Controla el comportamiento de las tuplas de ambas tablas.
2. [ ] Borra en cascada los elementos de una tabla cuando se borra un elemento de la otra.
3. [ ] Bloquea el borrado de elementos de una tabla por estar relacionados con elementos de otra tabla.
4. [ ] Permite definir que una BD está normalizada.

## 8 - Una clave primaria de una tabla en el modelo físico
1. [ ] Debe ser autoincremental.
2. [ ] No debe ser autoincremental.
3. [ ] Debe ser un identificador del modelo conceptual o lógico.
4. [ ] Puede ser un atributo simple no obligatorio.
5. [x] Ninguna es correcta.

## 9 - Una jerarquia cuando se pasa del modelo conceptual al lógico relacional
1. [x] Debe quitarse.
2. [ ] Debe quitarse si la cobertura es (T,S).
3. [ ] Debe quitarse si la cobertura es (P,E).
4. [ ] No debe quitarse si la cobertura es (P,S).

## 10 Una consulta en algebra relacional
1. [ ] Debe utilizar al menos dos tablas.
2. [x] Siempre devuelve un resultado.
3. [ ] Debe necesariamente tener proyección de datos.
4. [ ] Puede utilizar tablas inexistentes.

## 11 - Las funciones de agregación
1. [ ] Deben aparecer en el SELECT.
2. [x] Trabajan sobre un conjunto de tuplas.
3. [ ] Deben aparecer en el HAVING.
4. [ ] Todas son verdaderas.

## 12 - La optimización de una consulta
1. [ ] A veces la realiza el DBA.
2. [ ] A veces la realiza el DBMS.
3. [x] La realiza el DBMS.
4. [ ] Depende enteramente del programador.

## 13 - Una transacción que alcanzada el estado de abortada
1. [ ] Alcanzo el estado de Parcialmente cometida.
2. [ ] Estuvo activa y desde ese estado aborto.
3. [x] Nunca alcanzo el estado de cometida.
4. [ ] Puede haber fallado.

## 14 - La modificación inmediata
1. [ ] Es más eficiente que la modificación diferida.
2. [ ] Es menos eficiente que la modificación diferida.
3. [ ] Es mejor que la doble paginación.
4. [x] No tengo datos suficientes para responder.

## 15 - Un checkpoint
1. [x] Puede ubicarse en cualquier lugar de la bitácora.
2. [ ] Debe contener una lista de transacciones activas.
3. [ ] Permite conservar la condición de idempotencia del esquema.
4. [ ] Asegura el tratamiento de deadlock en caso de que existiera.
5. [x] Ninguna de las anteriores
> Puede ser la 1 o la 5
## 12 - ​Comparar el código de PurchaseRepository de la Práctica 1 (con Session de Hibernate) con el nuevo PurchaseRepository de Spring Data JPA. ¿Cuántas líneas de código se eliminaron? ¿Qué operaciones ya no es necesario implementar manualmente?

Operaciones que ya no es necesario implementar manualmente
- save(), saveAll()
- findById(), findAll(), findAllById()
- delete(), deleteById(), deleteAll()
- existsById(), count()
- flush(), saveAndFlush()
- Gestión explícita de sesiones y transacciones (apertura, commit, rollback, cierre)
- Manejo manual de excepciones (Hibernate → JPA)
- Escritura de consultas JPQL/HQL para operaciones CRUD simples

## 13 - ​En la Práctica 1, los repositorios gestionaban internamente la Session. ¿Que recibe ahora un servicio que necesita usar un repositorio Spring Data? ¿Cómo se declara esa dependencia? ¿Dónde queda ahora la lógica de apertura y cierre de sesiones?

¿Qué recibe? Recibe una instancia (proxy) del repositorio que implementa la interfaz PurchaseRepository. Esta instancia es creada y gestionada por Spring (inyección de dependencias). No se recibe una Session ni un SessionFactory.

¿Cómo se declara? Mediante inyección de dependencias, típicamente por constructor o con @Autowired sobre el campo.

¿Dónde queda la lógica? Ya no está en el repositorio ni en el servicio. La delega completamente a Spring Data JPA (y al proveedor JPA, Hibernate).

## 14 - ​¿Cómo funciona la generación de consultas por nombre de método en Spring Data JPA? Describir las palabras clave principales que puede interpretar (findBy, existsBy, countBy, deleteBy) y cómo se combinan con los atributos de la entidad.

Spring Data JPA permite definir consultas automáticas a través del nombre del método en los repositorios. El mecanismo divide el nombre en dos partes: el sujeto (subject) y el predicado (predicate), separados por la palabra clave By

| Palabra clave             | Propósito                     | Tipo de retorno                        | Ejemplo                               |
| ------------------------- | ----------------------------- | -------------------------------------- | ------------------------------------- |
| `find…By`                 | Consulta / búsqueda           | Collection, Optional, Page, etc.       | `findByNombre(String nombre)`         |
| `read…By`                 | Consulta (sinónimo de findBy) | Collection, Optional, etc.             | `readByEmail(String email)`           |
| `get…By`                  | Consulta (sinónimo de findBy) | Collection, Optional, etc.             | `getById(Long id)`                    |
| `count…By`                | Contar registros              | `long` o `Long`                        | `countByEstado(String estado)`        |
| `exists…By`               | Verificar existencia          | `boolean`                              | `existsByEmail(String email)`         |
| `delete…By` / `remove…By` | Eliminar registros            | `void` o `long` (número de eliminados) | `deleteByEstado(String estado)`       |
| `…First<N>…` / `…Top<N>…` | Limitar resultados            | `T` (único) o `List<T>`                | `findTop3ByEdad()`                    |
| `…Distinct…`              | Resultados únicos             | `List<T>`                              | `findDistinctByNombre(String nombre)` |

Los atributos se concatenan en orden, pudiendo combinarse con operadores lógicos como And y Or. Para navegar propiedades anidadas, se usa _ o se concatenan directamente

## 15 - ​¿Cómo se pasan los parametros a un Query Method? ¿Cómo hace Spring Data JPA para asociar cada parámetro del método con la condición correspondiente en la consulta? ¿Qué ocurre si el orden de los parámetros no coincide con el orden de las condiciones en el nombre del método?

Por defecto, Spring Data JPA utiliza asociación posicional: cada parámetro del método se vincula a las condiciones en el orden en que aparecen en el nombre del método. Para evitar dependencias de orden, especialmente cuando hay muchos parámetros o se usa @Query, se recomienda usar @Param:
```java
@Query("SELECT u FROM Usuario u WHERE u.nombre = :nombre AND u.edad = :edad")
Usuario buscarPorNombreYEdad(@Param("nombre") String nombre, @Param("edad") Integer edad);
```
Si el orden de los parámetros no coincide con las condiciones del método derivado, la consulta generada será incorrecta en tiempo de ejecución, ya que asignará valores a condiciones equivocadas.

## 16 - ​Investigar y para cada uno de los siguientes requerimientos indicar si es posible resolverlo con un Query Method y escribir la firma del método correspondiente. Si no es posible, explicar por qué:
### A -​ Buscar todas las Purchase de un usuario dado su username.
```java
List<Purchase> findByUsuarioUsername(String username);
```

### B -​ Verificar si existe alguna Purchase para una Route dada.
```java
boolean existsByRoute(Route route);
// o también
boolean existsByRouteId(Long routeId);
```

### C - Contar cuantas Review tienen un rating mayor o igual a un valor dado.
```java
long countByRatingGreaterThanEqual(Integer rating);
```

### D -​ Obtener todas las Route cuyo precio sea menor a un valor dado, ordenadas por nombre.
```java
List<Route> findByPriceLessThanOrderByNameAsc(Double price);
```

### E -​ Buscar un User por su email.
```java
Optional<User> findByEmail(String email);
// o para retornar un solo resultado
User findByEmail(String email);
```

### F - Obtener los top 3 Route con mayor cantidad de Purchase.
No es posible con un Query Method estándar. Los métodos derivados basados en el nombre no permiten ordenar por el tamaño de una colección o por el número de elementos relacionados.
```java
@Query("SELECT r FROM Route r ORDER BY SIZE(r.purchases) DESC")
List<Route> findTop3ByPurchasesSize();
```

## 17 - ​Investigar cuales son las palabras clave (keywords) disponibles en Spring Data JPA para construir Query Methods. ¿Qué tipos de condiciones, comparaciones y operadores lógicos soporta?

| Palabra clave      | Operación               | Ejemplo (firma)                         | Fragmento JPQL generado                           |
| ------------------ | ----------------------- | --------------------------------------- | ------------------------------------------------- |
| `And`              | AND lógico              | `findByNombreAndApellido`               | `… WHERE x.nombre = ?1 AND x.apellido = ?2`       |
| `Or`               | OR lógico               | `findByNombreOrApellido`                | `… WHERE x.nombre = ?1 OR x.apellido = ?2`        |
| `Between`          | Rango                   | `findByEdadBetween`                     | `… WHERE x.edad BETWEEN ?1 AND ?2`                |
| `LessThan`         | Menor que               | `findByEdadLessThan`                    | `… WHERE x.edad < ?1`                             |
| `GreaterThan`      | Mayor que               | `findByEdadGreaterThan`                 | `… WHERE x.edad > ?1`                             |
| `LessThanEqual`    | Menor o igual           | `findByEdadLessThanEqual`               | `… WHERE x.edad <= ?1`                            |
| `GreaterThanEqual` | Mayor o igual           | `findByEdadGreaterThanEqual`            | `… WHERE x.edad >= ?1`                            |
| `Like`             | Coincidencia parcial    | `findByNombreLike`                      | `… WHERE x.nombre LIKE ?1`                        |
| `NotLike`          | No coincide parcial     | `findByNombreNotLike`                   | `… WHERE x.nombre NOT LIKE ?1`                    |
| `StartingWith`     | Empieza con             | `findByNombreStartingWith`              | `… WHERE x.nombre LIKE ?1` (con % al final)       |
| `EndingWith`       | Termina con             | `findByNombreEndingWith`                | `… WHERE x.nombre LIKE ?1` (con % al inicio)      |
| `Containing`       | Contiene                | `findByNombreContaining`                | `… WHERE x.nombre LIKE ?1` (con % en ambos lados) |
| `In`               | Dentro de lista         | `findByEdadIn`                          | `… WHERE x.edad IN (?1, ?2)`                      |
| `NotIn`            | Fuera de lista          | `findByEdadNotIn`                       | `… WHERE x.edad NOT IN (?1, ?2)`                  |
| `IsNull`           | Es nulo                 | `findByEmailIsNull`                     | `… WHERE x.email IS NULL`                         |
| `NotNull`          | No nulo                 | `findByEmailNotNull`                    | `… WHERE x.email IS NOT NULL`                     |
| `IsEmpty`          | Colección vacía         | `findByRolesIsEmpty`                    | `… WHERE x.roles IS EMPTY`                        |
| `IsNotEmpty`       | Colección no vacía      | `findByRolesIsNotEmpty`                 | `… WHERE x.roles IS NOT EMPTY`                    |
| `True`             | Valor booleano true     | `findByActivoTrue`                      | `… WHERE x.activo = true`                         |
| `False`            | Valor booleano false    | `findByActivoFalse`                     | `… WHERE x.activo = false`                        |
| `Is` / `Equals`    | Igualdad (implícito)    | `findByNombreIs` / `findByNombreEquals` | `… WHERE x.nombre = ?1`                           |
| `Not`              | Negación                | `findByNombreNot`                       | `… WHERE x.nombre <> ?1`                          |
| `After`            | Fecha posterior         | `findByFechaAfter`                      | `… WHERE x.fecha > ?1`                            |
| `Before`           | Fecha anterior          | `findByFechaBefore`                     | `… WHERE x.fecha < ?1`                            |
| `Exists`           | Subconsulta existencial | (JPA específico)                        | `… WHERE EXISTS (…)`                              |
| `Regex`            | Expresión regular       | (solo MongoDB)                          | Depende de la base de datos                       |

Modificadores adicionales

| Palabra clave              | Propósito                                       |
| -------------------------- | ----------------------------------------------- |
| `OrderBy` + `Asc` / `Desc` | Ordenación estática                             |
| `IgnoreCase`               | Ignorar mayúsculas/minúsculas en la comparación |
| `AllIgnoreCase`            | Ignorar mayúsculas para todos los atributos     |

## 18 - ​¿Qué limitaciones tienen los Query Methods?
Los Query Methods (como los definidos en Spring Data JPA o similares) son métodos de acceso a datos cuyo nombre describe la consulta a ejecutar (ej. findByNombreAndEdad). Son útiles para consultas simples, pero presentan limitaciones importantes:
- No manejan consultas dinámicas (con cantidad variable de condiciones).
- Se vuelven inmanejables con joins complejos o subconsultas.
- No soportan consultas de reporte con agregaciones, agrupamiento o proyecciones personalizadas.

## 19 - ​En la Práctica 1 se utilizaron consultas HQL (Hibernate Query Language). ¿Que diferencia hay entre HQL y JPQL (Java Persistence Query Language)? ¿Son intercambiables? ¿Cual de los dos acepta @Query por defecto?

HQL (Hibernate Query Language) es el lenguaje de consultas propio de Hibernate, mientras que JPQL (Java Persistence Query Language) es el estándar definido por JPA (Jakarta Persistence).
Principales diferencias:
- Portabilidad: JPQL es estándar y funciona con cualquier proveedor JPA (Hibernate, EclipseLink, OpenJPA). HQL incluye extensiones específicas de Hibernate (ej. LIMIT, OFFSET, funciones propias como current_date() o str()).
- Funcionalidad: HQL permite ciertas operaciones no estandarizadas, como consultas a colecciones con SOME, ALL, INDEX(), o cláusulas UPDATE/DELETE más flexibles.

No completamente intercambiables. Todo JPQL válido es también HQL válido (porque Hibernate implementa el estándar JPA). Pero un HQL que use extensiones propietarias (ej. INSERT ... SELECT) no es JPQL y, por tanto, no funcionará con otro proveedor JPA.

En Spring Data JPA, la anotación @Query espera por defecto JPQL (el estándar JPA). Sin embargo, como la implementación subyacente suele ser Hibernate, también se pueden escribir consultas HQL que contengan extensiones propias; el motor de Hibernate las interpretará igualmente, pero se pierde portabilidad.

## 20 - ​¿Que diferencia hay entre una consulta @Query con JPQL y una con nativeQuery = true? ¿Cuándo conviene cada una? Dar un ejemplo concreto del modelo para cada caso.

La principal diferencia radica en el lenguaje utilizado y el nivel de abstracción. Con nativeQuery = false se utiliza JPQL interactuando entidades JPA y sus campos, en cambio con nativeQuery = true se utiliza SQL específico del motor de base de datos interactuando con tablas y columnas reales de la BD.

Conviene utilizar JPQL para realizar consultas estándar, portables y donde el modelo orientado a objetos es suficiente. Conviene utilizar SQL cuando se necesitas optimizar una consulta compleja usando características específicas del motor de bases de datos.

## 22 - ​¿Qué es la interfaz Pageable? ¿Cómo se construye una instancia de Pageable? ¿Qué información encapsula (número de página, tamaño, ordenamiento)?

La interfaz Pageable de Spring Data es una abstracción que representa la información necesaria para solicitar una página de datos de forma paginada y ordenada. Se utiliza en los repositorios (por ejemplo, en métodos como findAll(Pageable pageable)) para especificar qué porción del conjunto total de resultados se desea obtener.

Se construye mediante la clase PageRequest, que implementa Pageable.
```java
Pageable pageable = PageRequest.of(0, 10);
```

Pageable encapsula:
- Número de página (page): índice de la página solicitada
- Tamaño de página (size): cantidad de elementos por página.
- Ordenamiento (sort): objeto Sort que define las direcciones (ascendente/descendente) y las propiedades por las que ordenar. Puede ser `Sort.unsorted()` si no se requiere orden.

Además, Pageable proporciona métodos útiles como `next()`, `previous()`, `first()`, `getOffset()` (para calcular el desplazamiento en la consulta SQL, por ejemplo) y `hasPrevious()`.

## 23 - ​¿Que diferencia hay entre los tipos de retorno Page<T> y Slice<T>? ¿Cuándo conviene cada uno? ¿Qué consulta adicional ejecuta Page<T> que Slice<T> no ejecuta?

`Page<T>` extiende a `Slice<T>` y añade información del total de elementos (`getTotalElements()`) y el total de páginas (`getTotalPages()`). Conviene utilizarlo cuando se necesita conocer el número exacto de resultados totales.

`Slice<T>` solo conoce el contenido de la página actual y si existe una página siguiente o anterior (métodos `hasNext()`, `hasPrevious()`). Para ello, el repositorio solicita una fila adicional (tamaño de página + 1) y, si aparece, indica que hay más elementos. Conviene utilizarlo  cuando no es necesario el total exacto o cuando la consulta de recuento es muy costosa.

Para calcular el total de elementos, Spring Data ejecuta una consulta de recuento adicional al utilizar `Page<T>` (ej: SELECT COUNT(*) FROM ...).

## 24 - ​Mostrar como se invocará desde la capa de servicio un método paginado para obtener la segunda página de compras de un usuario, con 10 resultados ordenados por fecha descendente.
```java
public Page<Compra> obtenerComprasPaginadas(Long usuarioId) {
    // Segunda página → page = 1 (base 0)
    // Tamaño = 10
    // Orden: fecha descendente
    Pageable pageable = PageRequest.of(1, 10, Sort.by("fecha").descending());
    
    return compraRepository.findByUsuarioId(usuarioId, pageable);
}
```
## 25 - ¿Cómo se agrega ordenamiento a un Query Method sin usar Pageable? ¿Qué palabra clave se usa en el nombre del método? Mostrar un ejemplo concreto con el modelo.

Para agregar ordenamiento a un Query Method en Spring Data JPA sin usar Pageable, se emplea la palabra clave `OrderBy` dentro del nombre del método. Esta palabra clave va seguida del nombre de la propiedad por la que se desea ordenar y, opcionalmente, la dirección (Asc o Desc).


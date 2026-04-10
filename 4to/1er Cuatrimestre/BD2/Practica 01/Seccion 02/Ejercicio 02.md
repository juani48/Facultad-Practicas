## 16 - ​Para la relación `Purchase` -> `ItemService` (composición uno-a-muchos):
### h -​ ¿Qué anotaciones se necesitan en cada lado?

- En la clase `Purchase`: `@OneToMany(mappedBy = "purchase")` sobre la colección de ItemService.

- En la clase `ItemService`: `@ManyToOne` y `@JoinColumn(name = "purchase_id", nullable = false)` sobre la referencia a Purchase.

### I -​ ¿Qué columna o tabla aparece en la base de datos para representar esta relación?

Aparece una columna de clave foránea en la tabla mapeada de `ItemService`. Dicha columna, se llamara purchase_id y almacena la clave primaria de `Purchase` y no puede ser nula. No se crea una tabla intermedia adicional.

### J - ¿Qué es mappedBy y en qué lado de la relación va? ¿Qué ocurre si se omite en ambos lados?

`mappedBy` es un atributo de `@OneToMany` que indica que el lado inverso (el lado `@ManyToOne`) es el propietario de la relación. Se coloca en el lado uno (`Purchase`).

Si se omite `mappedBy` en ambos lados (es decir, `@OneToMany` sin `mappedBy` y `@ManyToOne` sin `@JoinColumn` explícito), JPA tratará la relación como unidireccional desde `Purchase` y creará por defecto una tabla de unión (join table) en lugar de usar una clave foránea en `ItemService`. Si además se incluye `@ManyToOne`, pueden ocurrir conflictos o mapeos redundantes.

### K -​ ¿Es esta relación bidireccional o unidireccional según el diagrama? ¿Cómo se refleja en el código Java?

Es una relación de composición y se modela como bidireccional para facilitar la navegación desde el todo a las partes y viceversa.

## 17 - ​Para las relaciones `Route` <-> `DriverUser` y `Route` <-> `TourGuideUser` (muchos-a-muchos):
### L -​ ¿Qué anotaciones se usan?

En cada entidad se usa `@ManyToMany`. En el lado propietario (en este caso `Route`) se añade `@JoinTable` para definir la tabla intermedia. En el lado inverso (`DriverUser` y `TourGuideUser`) se usa `mappedBy` para indicar que el otro lado (`Route`) es el propietario.

### M - ¿Qué tabla adicional genera JPA? ¿Qué columnas tiene? Definirla explícitamente usando @JoinTable.

Para cada relación, JPA genera una tabla de unión (join table) independiente:

- Para `Route` - `DriverUser`: tabla `route_driver`
    - Columnas:
        - `route_id` (clave foránea a `route`)
        - `driver_user_id` (clave foránea a `driver_user`)
    - Definición explícita:
```java
@ManyToMany
@JoinTable(
    name = "route_driver",
    joinColumns = @JoinColumn(name = "route_id"),
    inverseJoinColumns = @JoinColumn(name = "driver_user_id")
)
private List<DriverUser> drivers;
```
- Para `Route` - `TourGuideUser`: tabla `route_tourguide`
    - Columnas:
        - `route_id` (clave foránea a `route`)
        - `tourguide_user_id` (clave foránea a `tourguide_user`)
    - Definición explícita:
```java
@ManyToMany
@JoinTable(
    name = "route_tourguide",
    joinColumns = @JoinColumn(name = "route_id"),
    inverseJoinColumns = @JoinColumn(name = "tourguide_user_id")
)
private List<TourGuideUser> tourGuides;
```
### N -​ ¿Pueden ambas relaciones compartir la misma tabla join? ¿Por qué?

No, no solo porque JPA no permita mapear dos asociaciones distintas sobre la misma tabla intermedia porque no sabría cómo distinguir qué fila pertenece a qué relación, sino porque generaria repeticion inecesaria de datos si se posee la misma route con el mismo tourguide_user y diferentes driver_user, repitiendo los id de los driver_user. 

## 18 - ​La relación Purchase -> Review es opcional (0..1). Implementar el mapeo de ambos lados. ¿Cómo se representa la opcionalidad en JPA?

Se representa medainte el atributo `optional = true` dentro de `@OneToOne`.


## 19 - ​ItemService referencia a Service (muchos-a-uno). Analizar el diagrama: ¿es navegable esta relación desde Service hacia ItemService? Justificar si conviene hacerla bidireccional o no.

Si, conviene hacerla bidireccional para poder conocer desde un Service todos sus ItemService y desde un ItemService conocer su Service a la hora de realizar consultas. Por ejemplo la navegacion podria comenzar desde un Supplier para conocer los Services que ofrece y conocer asi sus ItemService o podria pasar que desde un Purchase se desea conocer mediante los ItemService los Service que tiene asociado.

## 20 - ​Implementar el mapeo completo de las siguientes entidades con todas sus relaciones, siguiendo las anotaciones y decisiones discutidas: Supplier, Purchase, ItemService, Route, Stop y Review. Para cada relación bidireccional, incluir las anotaciones en ambos lados.

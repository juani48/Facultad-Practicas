## A - En este modelo cada período de exposición contiene múltiples cuadros en museos. ¿Qué parte del modelo indica esto? ¿Cómo la modificaría para que cada período fuese exclusivo de cada cuadro expuesto en un museo?

La parte del modelo que indica que cada período de exposición contiene múltiples cuadros en museos es la relacion entre la agregacion de `Cuadro` y `Museo` y la entidad `Periodo`, representada por la relacion `expuesto`.

Si se quisiera representar que cada período es exclusivo de cada cuadro expuesto en un museo se deberia modificar la cardinalidad de la entidad `Periodo` hacia la agregacion, pasando de `(1, N)` a `(1, 1)`.

## B - Si los cuadros se expusieran en un solo período dentro de cada museo ¿cómo ajustaría el modelo para reflejar esto?

Se deberia modificar la agregacion existente, eliminandola y creando una agregacion entre `Periodo` y `Museo` y relacionando `Cuadro` a dicha agregacion creada, las cadrinalidades seria:
- Un museo se expone en (1, N) periodos.
- Un periodo expone (1, N) museos.
- Un cuadro se expone en (1, N) museos dentro de un periodo.

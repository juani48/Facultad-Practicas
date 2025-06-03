## ¿Cómo se escribe un programa en un lenguaje lógico?

Un programa escrito en un lenguaje lógico es una secuencia de cláusulas. Las cláusulas pueden ser un Hecho o una Regla.
- Hecho: Expresan relaciones entre objetos, estas relaciones deben ser verdaderas. Son expresiones del tipo p(t1, t2, ..., tn). Ejemplos: `tiene(coche,ruedas)` representa el hecho que un coche tiene ruedas.
- Regla: Cláusula de Horn y tiene la forma de `conclusión :- condición`, siendo `:-` la sintaxis prologo dónde `:-` indica "Si". `conclusión` es un simple predicado y `condición` es una conjunción de predicados, separados por comas. Representan un AND lógico.
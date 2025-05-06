## ¿Qué problemas existen en el manejo de punteros? Ejemplificar.

- **Violación de tipos:** En memoria puede estar alocado el valor se un cierto tipo, si se define un puntero de otro tipo y se apunta a dicha dirección de memoria, se puede alterar el valor apuntado y cambiarlo al tipo del puntero.
- **Referencias sueltas (referencias dangling):** Si este objeto no esta alocado se dice que el puntero es peligroso (dangling). Una referencia suelta o dangling es un puntero que contiene una dirección de una variable dinámica que fue desalocada. Si luego se usa el puntero producirá error.
- **Punteros no inicializados:** Peligro de acceso descontrolado a posiciones de memoria, se debe realizar una verificación dinámica de la inicialización con un valor especial nulo. 
- **Punteros y uniones discriminadas:** Acceder a una posición de memoria usada para un tipo de dato unión.
Alias: Puede provocar referencias sueltas.
- **Liberación de memoria (objetos perdidos):** Las variables puntero se alocan como cualquier otra variable en la pila de registros de activación. Los objetos (apuntados) que se alocan a través de la primitiva new son alocados en la heap. La memoria disponible (heap) podría rápidamente agotarse a menos que de alguna forma se devuelva el almacenamiento alocado liberado. Si los objetos en el heap dejan de ser accesibles esa memoria podría liberarse.
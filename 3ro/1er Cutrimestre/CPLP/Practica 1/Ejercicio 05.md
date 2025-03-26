## Describa las características más relevantes de Ada, referida a:

# Tipos de datos

- Escalar:
  - Discreto:
    - Enteros: Integer, Natural, Positive.
    - Enumeraciones: Boolean, Character.
  - Real:
    - Coma flotante.
    - Coma fija.
- Compuesto:
  - Vector: Arrays, Strings.
  - Registros: record.
- Puntero: access.
  - Punteros a objetos
  - Punteros a subprogramas
- Privados: private.
- Tareas: task.

Definicion de variables ::= type < var > is < type > ;

# Tipos abstractos de datos – paquetes

Un TAD es una colección de valores y de operaciones definidos mediante una espeficación independiente de cualquier representación. La programación con TADs requiere dos pasos:
1. **Definición del tipo:** Establecer los valores que puede tomar el tipo y las operaciones necesarias para manipular los valores y especificar su interfaz.
2. **Implementación del tipo:** Elegir la representación de los valores e implementar las operaciones.

En Ada, los TADs se pueden definir utilizando paquetes, que permiten separar la especificación (lo que hace la función o procedimiento) de la implementación (las instrucciones concretas que lo hacen). Esto facilita la reutilización de algoritmos y permite cambiar la implementación en el futuro sin afectar a los programas que utilizan el TAD, siempre y cuando se mantenga la interfaz.

# Estructuras de datos

En Ada, los punteros se denominan "accesos" y se utilizan para crear estructuras de datos dinámicas.
```ada
type TPersona is record
   Nombre : string(1..20);
   Apellido1 : string(1..20);
   Apellido2 : string(1..20);
end record;

type TP_Persona is access TPersona; -- Tipo de los punteros a TPersona dinámicos
```
Además, se puede imponer una restricción de lectura a un puntero para que no se pueda modificar el objeto al que apunta. Esto permite referenciar una constante o una variable de forma segura, garantizando que no podrá modificarse a través del puntero.

# Manejo de excepciones

Los manejadores de excepciones en Ada comienzan con la cláusula when seguida de la lista de excepciones a las que responde y las instrucciones a ejecutar.
```ada
begin
  -- Código que puede generar excepciones
exception
  when Constraint_Error =>
    Put ("Error de rango.");
  when Program_Error | Tasking_Error =>
    Put ("Error de flujo.");
  when others =>
    Put ("Otro error.");
end;
```

En Ada también se pueden declarar nuevas excepciones para indicar distintos tipos de error. 
```ada
Error: exception;
```
# Manejo de concurrencia

En Ada se emplea una programación concurrente distribuida (transferencia de mensajes entre los procesos o threads) y la principal forma de sincronizar las unidades de ejecución, conocidas como tareas, son los puntos de entrada a la tarea o citas.


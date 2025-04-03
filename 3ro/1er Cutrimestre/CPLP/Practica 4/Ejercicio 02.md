## A - Indique cuales son las diferentes formas de inicializar una variable en el momento de la declaración de la misma.

- Inicializacion por defecto.
- Inicializacion de la declaracion.
- Tomar lo que hay en memoria (basura).

## B - Analice en los lenguajes: Java, C, Phyton y Ruby las diferentes formas de inicialización de variables que poseen. Realice un cuadro comparativo de esta característica.

| Lenguaje      | Inicialización por Defecto   | Inicialización en la Declaración | Toma Valores Basura (Memoria) |
| ------------- | ------------- | ----------- | ------ |
| Java          | Las varaibles de instancia pueden tomar valores por defecto | Las variables locales si requieren inicialización explícita | No (locales no se usan sin inicializar; variables de clase tienen valores por defecto).
| C             | Las variables globales/estáticas toman valores por defecto | Sí, en cualquier ámbito | Sí (locales no inicializadas contienen valores basura). |
| Python        | No existe, todas las variables deben inicializarse explícitamente  | La declaración implica inicialización | No (las variables no existen hasta que se asignan). |
| Ruby          | Las varaibles de instancia pueden tomar valores por defecto  | Las variables locales si requieren inicialización explícita | No (locales no se usan sin inicializar; variables de clase tienen valores por defecto). |
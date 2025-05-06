## Definir y contrastar las definiciones de un sistema de tipos fuerte y débil (probablemente en la bibliografía se encuentren dos definiciones posibles. Volcar ambas en la respuesta). Ejemplificar con al menos 2 lenguajes para cada uno de ellos y justificar.

- **Sistema de tipos fuerte:** 
  - Se dice que el sistema de tipos es fuerte cuando especifica restricciones sobre como las operaciones que involucran valores de diferentes tipos pueden operarse. 
  - Un lenguaje se dice fuertemente tipado (type safety) si el sistema de tipos impone restricciones que aseguran que no se producirán errores de tipo en ejecución.
  - Java y Python dado que en ambos no es posible realizar un concatenacion de un entero con un string, si realizar un casteo del entero a string.
- **Sistema de tipos debil:** Se dice que un sistema de tipos de debil si no especifica restricciones sobre como las operaciones que involucran valores de diferentes tipos. 
  - C y JavaScript dado que C no controla las operaciones que realizar los puntos y en JavaScript es posible inferir a errores durante la ejecucion.
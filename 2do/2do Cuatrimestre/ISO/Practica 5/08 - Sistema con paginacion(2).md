## Considere  un espacio lógico de 8 paginas de 1024 bytes cada una, mapeadas en una memoria física de 32 marcos. 

### A - ¿Cuantos bits son necesarios para representar una dirección lógica? 

bits para # pagina: $\ Log_{2}8 = 3 $

bits para desplazamiento por pagina: $\ Log_{2}1024 = 10 $

bits necesarios para represnetar una direccion logica: $\ 10 + 2 = 13 $

### B - ¿Cuantos bits son necesarios para representar una dirección física?

bits para # marco: $\ Log_{2}32 = 5 $

bits para desplazamiento por marco: $\ Log_{2}1024 = 10 $

bits necesarios para represnetar una direccion fisica: $\ 10 + 5 = 15 $

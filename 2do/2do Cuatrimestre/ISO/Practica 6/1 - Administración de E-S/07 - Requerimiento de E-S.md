## A - Describa mediante un ejemplo los pasos mínimos que se suceden desde que un proceso genera un requerimiento de E/S hasta que el mismo llega al dispositivo

Consideremos la lectura sobre un archivo en un disco: 
1. Determinar el dispositivo que almacena los datos. 
  - Traducir el nombre del archivo en la representación del dispositivo.
2. Traducir requerimiento abstracto en bloques de disco (Filesystem). 
3. Realizar la lectura física de los datos (bloques) en la memoria. 
4. Marcar los datos como disponibles al proceso que realizo el requerimiento.  
5. Retornar el control al proceso. 
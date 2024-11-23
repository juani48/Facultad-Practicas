## A - Al trabajar con particiones se pueden considerar 2 métodos (independientes entre si): Particiones Fijas y Particiones Dinámicas 

### 1. Explique como trabajan estos 2 métodos. Cite diferencias, ventajas y desventajas.  

- Particiones Fijas: La memoria se divide en particiones o regiones de tamaño fijo al bootear el sistema. Cada partición aloja un único proceso y cada proceso se coloca en alguna partición de acuerdo a algún criterio: First Fit, Best Fit, Worst Fit, Next Fit.
  - Ventajas: 
    - Fácil de implementar y gestionar, ya que las particiones se definen una vez y no cambian.
    - Menor sobrecarga en tiempo de ejecución, ya que las particiones son predefinidas.
    - El sistema puede calcular con antelación cuántos procesos puede alojar.
  - Desventajas: 
    - Si el proceso no utiliza todo el espacio de su partición, el espacio restante se desperdicia (Fragmentacion interna).
    - No se adapta bien a procesos de tamaños variables.
    - Los procesos más grandes que la partición no pueden cargarse, incluso si hay suficiente memoria libre en total.

- Particiones Dinámicas: Las particiones varan en tamaño y numero. Cada partición aloja un único proceso. Cada partición se genera en forma dinámica del tamaño justo que necesita el proceso. 
- Ventajas: 
    - Evita la fragmentación interna porque el bloque asignado coincide con el tamaño requerido.
    - Se adapta mejor a procesos de tamaños variados.
    - Puede cargar procesos grandes siempre que haya suficiente memoria contigua.
  - Desventajas: 
    - Aunque hay suficiente memoria total disponible, puede estar dividida en fragmentos pequeños que no pueden satisfacer las solicitudes de procesos grandes (Fragmentacion externa).
    - El sistema operativo debe realizar un seguimiento continuo de las áreas libres y ocupadas.
    - A veces se requiere compactar la memoria para reducir la fragmentación, lo cual consume tiempo de procesamiento.

### 2. ¿Qué información debe disponer el SO para poder administrar la memoria con estos métodos? 

Una tabla de particones, con la direcciones de inicio y fin para cada bloque.

### 3. Realice un gráfico indicado como realiza el SO la transformación de direcciones lógicas a direcciones físicas.  

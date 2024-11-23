## A -  Al trabajar con particiones fijas, los tamaños de las mismas se pueden considerar:  Particiones de igual tamaño o Particiones de diferente tamaño. Cite ventajas y desventajas de estos 2 métodos.  

- **Particiones de Igual Tamaño:** La memoria se divide en bloques de tamaño uniforme. Todos los procesos deben ajustarse a estas particiones, sin importar su tamaño real.
  - Ventajas:
    - Es fácil implementar y mantener este esquema porque todas las particiones tienen las mismas características.
    - No es necesario comparar tamaños de procesos con las particiones; cualquier proceso que quepa en una partición se asigna inmediatamente.
    - Se eliminan decisiones complejas al asignar procesos a particiones.
  - Desventajas:
    - Si el proceso es más pequeño que la partición, el espacio sobrante no se puede reutilizar.
    - No se adapta bien a procesos de diferentes tamaños; procesos grandes que excedan el tamaño de la partición no se pueden cargar.
    - Este esquema es poco eficiente si la carga de trabajo incluye procesos muy grandes o muy pequeños.

- **Particiones de Diferente Tamaño:** La memoria se divide en bloques de distintos tamaños. Cada partición puede alojar un proceso cuyo tamaño sea igual o menor al de la partición.
  - Ventajas:
    - Procesos pequeños pueden ser asignados a particiones pequeñas, mientras que procesos más grandes pueden ser alojados en particiones más grandes.
    - Al asignar procesos pequeños a particiones pequeñas, se desperdicia menos espacio en comparación con particiones uniformes.
    - Este esquema acomoda una variedad más amplia de tamaños de procesos.
  - Desventajas:
    - Es necesario realizar un seguimiento de las particiones de diferentes tamaños y sus asignaciones.
    - Si los procesos no encajan perfectamente en las particiones disponibles, puede quedar memoria inutilizable entre bloques.
    - El sistema operativo debe buscar la partición más adecuada para cada proceso, lo que puede aumentar el tiempo de asignación.
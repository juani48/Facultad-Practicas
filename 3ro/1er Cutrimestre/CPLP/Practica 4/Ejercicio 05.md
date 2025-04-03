## A - En Ada hay dos tipos de constantes, las numéricas y las comunes. Indique a que se debe dicha clasificación.

**Constantes numericas:** Son valores numéricos universales que se definen sin un tipo explícito y se evalúan en tiempo de compilación (Pueden ser universal_integer o universal_real, lo que les permite adaptarse al contexto sin restricciones de tipo específico), ideales para constantes matemáticas o valores que requieren precisión en cálculos numéricos.
**Constantes comunes:** Son valores fijos con un tipo de dato explícito y se inicializan durante la ejecución (Deben declararse con un tipo específico que puede no ser numerico), ideales para valores que dependen de un contexto específico o que no son puramente numéricos.

- Optimización de rendimiento: Las constantes numericas se procesan en tiempo de compilación, reduciendo la carga en tiempo de ejecución. Las constantes comunes permiten gestionar valores que podrían requerir inicialización dinámica.
- Claridad y mantenibilidad: Usar constantes numericas evita errores al reemplazar literales numéricos críticos (ej: 3.14159 por Pi), mejorando la legibilidad. Las constantes comunes facilitan la gestión de valores específicos de un tipo o módulo.
- Diferencias en el tipado: Las constantes numericas son universales, mientras que las constantes comunes están fuertemente tipadas, lo que previene errores de compatibilidad

## B - En base a lo respondido en el punto A, determine el momento de ligadura de las constantes del siguiente código:
```ada
H: constant Float:= 3,5;
I: constant:= 2;
K: constant float:= H*I;
```

- H se liga de forma dinamica en ejecucion.
- I se liga en tiempo de compilacion de foma estatica.
- K es determinada en tiempo de ejecucion de forma dinamica.
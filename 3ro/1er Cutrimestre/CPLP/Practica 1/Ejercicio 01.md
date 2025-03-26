## Indique para cada uno de los períodos presentados cuales son las características nuevas que se incorporan y cual de ellos la incorpora.

# - 1951 - 1955: Lenguajes tipo assembly

A diferencia de los lenguajes de alto nivel, aquí hay usualmente una correspondencia 1 a 1 entre las instrucciones simples del ensamblador y el lenguaje de máquina. Esto permite un mayor control de recursos (memoria) e instrucciones mas precisas sobre lo que un microcontrolador debe realizar. Un típico lenguaje ensamblador consiste en 3 tipos de sentencias de instrucción que son usadas para definir las operaciones del programa:

- **Mnemónicos de opcode/extendidos**: Generalmente, un mnemónico es un nombre simbólico para una sola instrucción en lenguaje de máquina ejecutable (un opcode o código de operación), y hay por lo menos un mnemónico de opcode definido para cada instrucción en lenguaje de máquina. Cada instrucción consiste típicamente en una operación u opcode más cero o más operandos. La mayoría de las instrucciones refieren a un solo valor, o a un par de valores. Los operandos pueden ser inmediatos (típicamente valores de un byte, codificados en la propia instrucción), registros especificados en la instrucción, implícitos o las direcciones de los datos localizados en otra parte de la memoria. Esto está determinado por la arquitectura subyacente del procesador, el ensamblador simplemente refleja cómo trabaja esta arquitectura. Los mnemónicos extendidos son frecuentemente usados para especificar una combinación de un opcode con un operando específico.

- **Secciones de datos**: Hay instrucciones usadas para definir elementos de datos para manejar datos y variables. Definen el tipo de dato, la longitud y la alineación de los datos. Estas instrucciones también pueden definir si los datos están disponibles para programas exteriores (programas ensamblados separadamente) o solamente para el programa en el cual la sección de datos está definida. 

- **Directivas de ensamblador**: Las directivas del ensamblador, también llamadas pseudo opcodes, pseudo-operaciones o pseudo-ops, son instrucciones que son ejecutadas por un ensamblador en el tiempo de ensamblado, no por la CPU en tiempo de ejecución. Pueden hacer al ensamblado del programa dependiente de parámetros especificados por el programador, de modo que un programa pueda ser ensamblado de diferentes maneras, quizás para diversas aplicaciones. También pueden ser usadas para manipular la presentación de un programa para hacerlo más fácil de leer y mantener.


  
# - 1956 - 1960: FORTRAN, ALGOL 58, ALGOL 60, LISP

Como muchos “primeros” en la historia, el primer lenguaje de programación moderno es difícil de identificar. Desde un inicio, las restricciones de hardware definían el lenguaje. Las tarjetas perforadas permitían 80 columnas, pero algunas de estas serían utilizadas para una clasificación de cada tarjeta. FORTRAN incluía algunas palabras reservadas provenientes del Inglés, como “IF”, “GOTO” (go to) y “CONTINUE”. El uso del tambor magnético para la memoria implicaba que los programas informáticos tuvieran que estar intercalados con las rotaciones del tambor. Por lo tanto los programas eran muy dependientes del hardware.

- **FORTRAN**: El lenguaje fue diseñado teniendo en cuenta que los programas serían escritos en tarjetas perforadas de 80 columnas. Así por ejemplo, las líneas debían ser numeradas y la única alteración posible en el orden de ejecución era producida con la instrucción goto.
- **LIPS**: Fue en Lisp donde nacieron muchas ideas de las ciencias de la computación, incluyendo la estructura de dato de árbol, recolección automática de basura, tipado dinámico, condicionales, funciones de orden superior como map y reduce, recursividad, el compilador autocontenido y el REPL. Lisp fue el primer lenguaje de programación homoicónico: todo el código fuente del programa es al mismo tiempo una estructura de datos del lenguaje (listas anidadas o árboles).

# - 1961 - 1965: COBOL, ALGOL 60, SNOBOL, JOVIAL

El Reporte de ALGOL 60 ("ALGOrithmic Language") consolidó muchas ideas que estaban circulando en aquel entonces, y proporcionó dos innovaciones importantes para los lenguajes de programación:

1. Estructuras de bloques anidadas: las secuencias de código y las declaraciones asociadas se pueden agrupar en bloques sin tener que pertenecer explícitamente a procedimientos separados.
2. Ámbito léxico: un bloque puede tener sus propias variables, procedimientos y funciones, invisible al código fuera de dicho bloque, por ejemplo, ocultamiento de información.

Otra innovación, relacionada con esto, fue cómo el lenguaje fue descrito; una notación matemática exacta, Backus-Naur Form (BNF), fue utilizada para describir la sintaxis del lenguaje. Todos los subsecuentes lenguajes de programación han utilizado una variante de BNF para describir la porción libre del contexto de su sintaxis.

La sintaxis y la semántica se hizo aún más ortogonal, con rutinas anónimas, un sistema de tipificación recursiva con funciones de orden superior, son algunas de las ideas fundamentales de Algol.

# - 1966 - 1970: APL, FORTRAN 66, BASIC, PL/I, SIMULA 67, ALGOL-W

- **PL/I**: Este lenguaje tenía muchas de las características que más adelante adoptaría el lenguaje C y algunas de C++ como multiprocesamiento, recursión, estructuras de control modernas, asignación dinámica de espacio para estructuras de datos y procedimientos genéricos.
- **APL**: Utiliza operadores parametrizables, por lo que es muy conciso. Su sintaxis está basada en pocos "operadores" y utiliza un conjunto especial de caracteres que no están presentes en el código ASCII. El conjunto de operaciones se fundamenta en álgebra lineal abstracta, por lo que es un lenguaje idóneo para trabajar con vectores y matrices. Cuenta con un repertorio de operadores que le permite componer nuevas operaciones lógicas o matemáticas.
- **SIMULA**: Fue el primer lenguaje diseñado para apoyar la programación orientada a objetos.

# - 1971 - 1975: Pascal, C, Scheme, Prolog

En los años 60 y 70 también suscitó un debate considerable sobre los méritos de la "programación estructurada", que esencialmente significaba programación sin el uso de GOTO. Este debate estaba estrechamente relacionado con el diseño del lenguaje: algunos lenguajes no incluían GOTO, lo que obligó a la programación estructurada en el programador. Como resultado de ello, se considero una mala práctica de programación usar leguajes que ofrecen GOTO y las generaciones posteriores de diseñadores de lenguajes han encontrado el debate sobre programación estructurada tedioso e incluso desconcertante.

- **Prolog**: Fue el primer lenguaje de programación lógica.
- **Pascal**: Su objetivo era crear un lenguaje que facilitara el aprendizaje de programación a sus alumnos, utilizando la programación estructurada y estructuración de datos. Pascal se caracteriza por ser un lenguaje de programación fuertemente tipado. Esto implica que, por un lado, el código está dividido en porciones fácilmente legibles llamadas funciones o procedimientos, lo que facilita la utilización de la programación estructurada en oposición al antiguo estilo de la programación monolítica; y, por otro, que el tipo de dato de todas las variables debe ser declarado previamente para que su uso quede habilitado.
- **C**: Se trata de un lenguaje del tipo datos estáticos, débilmente tipado, que dispone de las estructuras típicas de los lenguajes de alto nivel, pero, a su vez, dispone de construcciones del lenguaje que permiten un control a bajo nivel, lo que lo convierte en un lenguaje de nivel medio. Los compiladores suelen ofrecer extensiones al lenguaje que posibilitan mezclar código en ensamblador con código C o acceder directamente a memoria o dispositivos periféricos. Uno de los objetivos de diseño del lenguaje C es que solo sean necesarias pocas instrucciones en lenguaje máquina para traducir cada elemento del lenguaje, sin que haga falta un soporte intenso en tiempo de ejecución. Es muy posible escribir C a bajo nivel de abstracción; de hecho, C se usó como intermediario entre diferentes lenguajes.
En parte, a causa de ser de relativamente bajo nivel y de tener un modesto conjunto de características, se pueden desarrollar compiladores de C fácilmente. En consecuencia, el lenguaje C está disponible en un amplio abanico de plataformas (más que cualquier otro lenguaje). Además, a pesar de su naturaleza de nivel medio, el lenguaje se desarrolló para incentivar la programación independiente de la máquina. Un programa escrito cumpliendo los estándares e intentando que sea portátil puede compilarse en muchos computadores.

# - 1976 - 1980: Smalltalk, Ada, FORTRAN 77, ML

En esta época la programación orientada a objetos es donde obtuvo mas fuerza gracias al desarrollo de smalltalk y ada.

- **Smalltalk**: Smalltalk es considerado el primero de los lenguajes orientados a objetos, aunque en realidad el primero en implementar programación orientada a objetos fue Simula. En Smalltalk todo es un objeto, incluidos los números reales o el propio entorno Smalltalk. Smalltalk ha tenido gran influencia sobre otros lenguajes como Java o Ruby, y de su entorno han surgido muchas de las prácticas y herramientas de desarrollo promulgadas actualmente por las metodologías ágiles (refactorización, desarrollo incremental, desarrollo dirigido por tests, etc.). Por sus características, Smalltalk puede ser considerado también como un entorno de objetos, donde incluso el propio sistema es un objeto.

- **Ada**: Es un lenguaje multipropósito, orientado a objetos y concurrente, pudiendo llegar desde la facilidad de Pascal hasta la flexibilidad de C++.

- **ML**: Entre las características de ML se incluyen evaluación por valor, álgebra de funciones, manejo automatizado de memoria por medio de recolección de basura, polimorfismo parametrizado, análisis de estático de tipos, inferencia de tipos, tipos de datos algebraicos, llamada por patrones y manejo de excepciones. Esta combinación particular de conceptos hace que sea posible producir una de los mejores compiladores actualmente disponibles

# - 1981 - 1985: Smalltalk 80, Turbo Pascal, Postscript
# - 1986 - 1990: FORTRAN 90, C++, SML
# - 1991 - 1995: TCL, PERL, HTML
# - 1996 - 2000: Java, Javascript, XML

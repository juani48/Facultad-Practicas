## Estudiantes y carreras
- ESTUDIANTE ( #legajo, nombreCompleto, nacionalidad, añoDeIngreso, códigoDeCarrera )
- CARRERA ( códigoDeCarrera, nombre )
- INSCRIPCIONA_MATERIA ( #legajo, códigoDeMateria)
- MATERIA (códigoDeMateria, nombre)

### A - Obtener el nombre de los estudiantes que ingresaron en 2023.
$$
INGRESANTES\_2023\ ←\ σ_{(añoDeIngreso\ >=\ 01/01/2023)\ AND\ (añoDeIngreso <= 31/12/2023)}(ESTUDIANTE)
\\
RES\ ←\ Π_{nombreCompleto}INGRESANTES\_2023
$$

### B - Obtener el nombre de los estudiantes con nacionalidad “Argentina” que NO estén en la carrera con código “LI07”
$$
ALUMNOS\_\LI07\ ←\ Π_{\#legajo}(ESTUDIANTE\ |x|\ σ_{códigoDeCarrera\ ==\ "LI07"}CARRERA)
\\
ALUMNOS\_NO_\LI07\ ←\ (Π_{\#legajo}ESTUDIANTE - ALUMNOS\_\LI07)
\\
RES\ ←\ Π_{nombreCompleto}(σ_{nacionalidad\ ==\ "Argentina"}ESTUDIANTE\ |X|\ ALUMNOS\_NO_\LI07)
$$

### C - Obtener el legajo de los estudiantes que se hayan anotado en TODAS las materias.
$$
E\_\IM\_M\ ←\ Π_{\#legajo, códigoDeMateria}(ESTUDIANTE\ |X|\ INSCRIPCIONA\_MATERIA\ |X|\ MATERIA)
\\
RES\ ←\ Π_{\#legajo}(E\_IM\_M\ \%\ Π_{códigoDeMateria}MATERIA)
$$
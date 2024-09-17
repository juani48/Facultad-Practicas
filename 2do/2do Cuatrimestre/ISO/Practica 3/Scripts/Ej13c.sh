# !/bin/bash

# Crear un script que reciba como parámetro el nombre de un archivo e informe si el
# mismo existe o no, y en caso afirmativo indique si es un directorio o un archivo. En
# caso de que no exista el archivo/directorio cree un directorio con el nombre recibido
# como parámetro.

path_test="D:\1Teoria y Trabajos de la facultad\Facultad\2do\2do Cuatrimestre"

if test $# -eq 1 ; then
    if test $(find $path_test -name "ISO" | ls) -eq 1; then
    echo "Existe"
    else
    echo "No existe"
    fi
    exit 0
else
    echo "No se enviaron los parametros necesarios."
    echo "El parametro debe ser un nombre de archivo o directorio."
    exit 1
fi
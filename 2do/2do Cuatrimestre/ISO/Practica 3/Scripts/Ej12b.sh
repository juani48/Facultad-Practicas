# !/bin/bash

# Modificar el script creado en el inciso anterior (12a) para que los números sean recibidos
# como parámetros. El script debe controlar que los dos parámetros sean enviados.

if test $# -eq 2
then
    echo "Suma: $(expr $1 + $2)"
    echo "Resta: $(expr $1 - $2)"
    echo "Mutiplicacion: $(expr $1 \* $2)"
    echo "Division: $(expr $1 / $2)"
    if test $1 -ge $2
    then
        echo "El primer parametro es mas grande"
    else
        echo "El segundo parametro es mas grande"
    fi
else
    echo "No se enviaron la canitdad de parametros necesarios"
    exit 1
fi
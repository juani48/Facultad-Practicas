# !/bin/bash/

# Renombrando Archivos: haga un script que renombre solo archivos de un directorio pasado como parametro agregandole una CADENA, contemplando las opciones:
# “-a CADENA”: renombra el fichero concatenando CADENA al final del nombre del archivo
# “-b CADENA”: renombra el fichero concantenado CADENA al principio del nombre del archivo

if [ $# -ne 3 ] ; then
    echo "La cantidad de parametros no se respeta."
    exit 1
else
    if [ -d $1 ]; then
        array=($(ls $1))
        if [ $2 -eq "-a" ]; then
            for i in ${array[*]} ; do
                mv ${i} "$3$i"
            done
        elif [ $2 -eq "-b" ]; then
            for i in ${array[*]} ; do
                mv ${i} "$i$3"
            done
        fi
    fi
    echo "Parametros incorrectos."
    echo "Formato: <directorio> <-a o -b> <cadena>."
    exit 1
fi
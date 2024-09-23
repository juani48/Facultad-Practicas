# !/bin/bash/

# Renombrando Archivos: haga un script que renombre solo archivos de un directorio pasado como parametro agregandole una CADENA, contemplando las opciones:
# “-a CADENA”: renombra el fichero concatenando CADENA al final del nombre del archivo
# “-b CADENA”: renombra el fichero concantenado CADENA al principio del nombre del archivo

function rename(){ 
    # $1 = path archvio
    # $2 = operacion
    if [ $2 = "-a" ] ; then
        mv ${directory}${1} ${directory}${1}${string}
    elif [ $2 = "-b" ]; then
        mv ${directory}${1} ${directory}${string}$1 
    fi
}

if [ $# -ne 3 ] ; then
    echo "La cantidad de parametros no se respeta."
    echo "Formato: <directorio> <-a | -b> <cadena>."
    exit 1
else

    if [ -d ${1} ]; then
        directory=${1}
        operation=${2}
        string=${3}

        array=$(ls $directory)

        for i in ${array[*]}; do
            if [ -f "$directory/$i" ]; then
                rename $i $operation
            fi
        done
        exit 0
    else
    echo "Parametros incorrectos."
    echo "Formato: <directorio> <-a o -b> <cadena>."
    exit 2
    fi 
fi
# !/bin/bash

# Crear un script que reciba como parámetro el nombre de un archivo e informe si el
# mismo existe o no, y en caso afirmativo indique si es un directorio o un archivo. En
# caso de que no exista el archivo/directorio cree un directorio con el nombre recibido
# como parámetro.


if [ $# -eq 1 ] ; then
	if [ -e "$1" ]; then
		if [ -d "$1" ]; then
			echo "El directorio existe."
		elif [ -f "$1" ]; then
			echo "El archvio existe."
		else
			echo "Ocurrio un error."
			exit 1
		fi
	else
		echo "El direcotrio/archivo no existe."
		mkdir -p "$1" 
	fi
else
    echo "No se enviaron los parametros necesarios."
    echo "El parametro debe ser un nombre de archivo o directorio."
    exit 1
fi


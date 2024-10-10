# !/bin/bash

if [ $# -le 0 ];then
	echo "Error de forma: <opcion1> <opcion2> <...>"
	exit 1
fi
ARRAY=($*)
inex=0
for (( i=1; i<${#ARRAY[*]}; i=$i+2 ));do
	if [ -d ${ARRAY[$i]} ]; then
		echo "${ARRAY[$i]} es un directorio."
	elif [ -f ${ARRAY[$i]} ]; then
		echo "${ARRAY[$i]} es un archivo"
	else
		echo "${ARRAY[$i]} no existe."
		inex=$(expr $inex + 1)
	fi	
done

echo "Total de archivos inexistentes: $inex"


# !/bin/bash

for i in $(ls /home | grep ".doc");do
	ARRAY=( ${ARRAY[*]} $i )
done

function verArchivo(){
	if [ $# -eq 1 ]; then
		for (( i=0; i < ${#ARRAY[*]}; i++ )); do
			if [ ${ARRAY[$i]} == $1 ]; then
				echo "$1"
				return 0
			fi	
		done
		echo "Archivo no econtrado."
		return 5
	fi
	return 1
}

function cantidadArchivos(){
	echo ${#ARRAY[*]}
	echo ${ARRAY[*]}
}

function borrarArchivo(){
	if [ $# -eq 1 ]; then

		for (( i=0; i < ${#ARRAY[*]}; i++));do

				if [ ${ARRAY[$i]} == $1 ];then

				echo "Eliminar logicamente"
				read option
				if [[ $option == "si" || $option == "" ]]; then
					unset ARRAY[$i]
					echo "Archivo eliminado logicamente"
					return 0
				elif [ $option == "no" ]; then
					sudo rm "/home/$1"
					unset ARRAY[$i]
					echo "Archivo elimando fisicamente"
					return 0
				else
					echo "Error de respuesta"
					return 2
				fi
			fi
		done
		echo "Archivo no encontrado"
		return 10
	fi
	echo "Error de parametros"
	return 1
}
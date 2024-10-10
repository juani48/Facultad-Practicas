# !/bin/bash

export ARRAY=()
	
for i in $(users);do
	ARRAY=(${ARRA[*]} $i)
done
case $# in
1)
	case $1 in 
	"-l")
		echo ${#ARRAY[*]}
	;;
	"-i")
		echo ${ARRAY[*]}
	;;
	*)
		echo "Error de formato: <opcion> <cantidad>"
		echo "-b n : Retorna el elemento en la posicion n."
		echo "-l : Retorna la longitud del arreglo."
		echo "-i : Retorna todos los elementos del arreglo."
		exit 1
	;;
	esac
;;
2)
	if [ $1 != "-b" ];then
		echo "Error de formato: <opcion> <cantidad>"
		echo "-b n : Retorna el elemento en la posicion n."
		echo "-l : Retorna la longitud del arreglo."
		echo "-i : Retorna todos los elementos del arreglo."
		exit 1
	elif [ $(expr $2 - 1) -gt ${#ARRAY[*]} || $2 -le 0 ];then
		echo "Error por tamaño excedido"
		exit 2
	else
		echo "${ARRAY[$(expr $2 - 1)]}"
	fi
;;
*)
	echo "Error de formato: <opcion> <cantidad>"
	echo "-b n : Retorna el elemento en la posicion n."
	echo "-l : Retorna la logitud del arreglo."
	echo "-i : Retorna todos los elementos del arreglo."
	exit 1
;;
esac

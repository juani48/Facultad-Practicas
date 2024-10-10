# !/bin/bash

function Init(){
	if [ $# -eq 0 ]; then
		ARRAY=()
	elif [ $# -eq 2 ];then
		for (( i=0; i<$1; i++ ));do
			ARRAY=(${ARRAY[*]} $2)
		done
	else [ $# -ne 0 ]
		echo "Error de parametros"
		return 1
	fi
}

function add(){
	if [ $# -eq 1 ]; then
	ARRAY=(${ARRAY[*]} $1)
	else
		echo "Error de parametros"
		return 1
	fi
}

function delet(){
	if [ $# -ne 1 ]; then
		echo "Error de parametros"
		return 1
	fi
	if [ $1 -lt 0 ] && [ $1 -gt ${#ARRAY[*]} ];then
		echo "Error de index"
		return 2
	fi
	unset ARRAY[$1]
}

function length(){
	echo ${#ARRAY[*]}
}

function count(){
	echo ${ARRAY[*]}
}
echo "Creo arreglo"
Init 2 1
echo "Elemens"
count
echo "Tam"
length
echo "Add"
add 1
echo "count"
count
echo "tam"
length
delet 1
echo "tam"
length

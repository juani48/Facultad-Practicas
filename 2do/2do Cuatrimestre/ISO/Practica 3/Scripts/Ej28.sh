# !/bin/bash

function recorrer(){
	ARRAY=$(ls $1)
	for i in ${ARRAY[*]}; do
		aux="$1/$i"
		if [  ];then

		fi
	done
}

if [ $# -ne 1 ];then
	echo "Error de formato"
	exit 1
fi
if [ ! -d $1 ];then 
	echo "Error"
	exit 4
fi

recorrer


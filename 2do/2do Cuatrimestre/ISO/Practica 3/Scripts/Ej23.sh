# !/bin/bash

export ARRAY=(1 2 3 4 5 6 7 8 9 10)
echo ${ARRAY[*]}
aux=0
for i in ${ARRAY[*]}; do
	if [ $(expr $i % 2) -eq 0 ];then
		echo "Numero par $i"
	else
		aux=$(expr $aux + $i)	
	fi	
done
echo "Suma de impares: $aux"



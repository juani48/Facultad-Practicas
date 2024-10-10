# !/bin/bash

export vector1=( 01 80 65 35 02)
export vector2=( 05 98 03 41 08)


length=${#vector1[*]}

for ((i=0; i < $length;i++))do
	echo "La suma de los elementos de la posicion $i d los ectores es: $(expr ${vector1[$i]} + ${vector2[$i]})"
done

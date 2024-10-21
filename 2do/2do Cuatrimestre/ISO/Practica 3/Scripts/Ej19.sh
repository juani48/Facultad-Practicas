# !/bin/bash


while [ true ]; do 
	
	ARRAY=()
	for i in $(ls); do
		ARRAY=( ${ARRAY[*]} $i)
	done	
	
	echo "MENU DE SCRIPTS"
	for (( i=0; i<= ${#ARRAY[*]}; i++ )); do
		if [ $i -eq ${#ARRAY[*]} ]; then
			echo "$i - Salir"
		else
			echo "$i - ${ARRAY[$i]}"
		fi
	done

	read -p "Ingrese la opcion a ejecutar: " OPTION; 

	echo "--------------------"; echo ""

	if [ $OPTION -lt ${#ARRAY[*]} ]; then
		aux="./${ARRAY[$OPTION]}"
		bash $aux
	elif [ $OPTION -eq ${#ARRAY[*]} ]; then
		echo "Saliendo..."
		exit 0
	else
		echo "Opcion incorecta"
	fi

	echo ""; echo "---------------------"; echo ""
done

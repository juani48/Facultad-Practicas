# !/bin/bash 

export STACK=()

function push(){
	STACK=(${STACK[*]} $1)
}

function pop(){
	count=${#STACK[*]}
	if [ $count -gt 0 ]; then
		unset STACK[$(expr $count -  1)] 
	else 
		echo "Pila vacia"
	fi
}

function length(){
	echo ${#STACK[*]}
}

function print(){
	echo ${STACK[*]}
}

echo "Antes de cargar"
length
print

for ((i=1; i <= 10;i++));do
	push $i
done
echo "Despues de cargar"
length
print

for ((i=0;i<3;i++))do
	pop
done

echo "Despues de pop"
length
print


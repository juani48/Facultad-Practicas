#!/bin/bash
# Realizar un script que le solicite al usuario 2 números, los lea de la entrada Standard 
# e imprima la multiplicación, suma, resta y cual es el mayor de los números leídos.

echo "Ingrese el primer numero"
read num1

echo "Ingrese el segundo numero"
read num2

echo "La suma de los dos numeros es: $(expr $num1 + $num2)"

echo "La resta de los dos numeroes es: $(expr $num1 - $num2)"

echo "La multiplicacion de los dos numeros es: $(expr $num1 \* $num2)"

echo "La division de los dos numeros es: $(expr $num1 / $num2)"

if test $num1 -gt $num2
then
    echo "El primer numero ( ${num1} ) es el mas grande de los dos"
else 
    echo "El segundo numero ( ${num2} ) es el mas grande de los dos"
fi
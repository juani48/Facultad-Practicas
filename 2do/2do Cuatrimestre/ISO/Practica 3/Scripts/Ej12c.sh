#! /bin/bash

# Realizar una calculadora que ejecute las 4 operaciones básicas: +, - ,*, %.
# Esta calculadora debe funcionar recibiendo la operación y los números como parámetros.

function evaluar(){
    if test $1 -eq 2; then
        echo "No se pueden introducir dos operaciones"
        exit 1
    fi
}

if test $# -eq 3
then
    case $2 in
        "+")
        echo "Suma: $(expr $1 + $3)"
        ;;
        "-")
        echo "Resta: $(expr $1 - $3)"
        ;;
        "*")
        echo "Multiplicacion: $(expr $1 \* $3)"
        ;;
        "/")
        echo "Division: $(expr $1 / $3)"
        ;;
        *)
        echo "No se ingresaron parametros validos."
        echo "Respete el fomarto: (numero) (operador) (numero)."
        echo "Para multiplicar ingrese: \*"
        exit 1
        ;;
    esac
else
    echo "No se enviaron los parametros necesarios."
    echo "Respete el fomarto: (numero) (operador) (numero)."
    echo "Para multiplicar ingrese: \*"
    exit 1
fi
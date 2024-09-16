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
    count_exit=0
    oper="N"
    parm_array=($*)
    num_array=()
    for i in ${parm_array[*]}; do
        case $i in
        "+")
        count_exit=$(expr $count_exit + 1)
        evaluar $count_exit
        oper="+"
        ;;
        "-")
        count_exit=$(expr $count_exit + 1)
        evaluar $count_exit
        oper="-"
        ;;
        "*")
        count_exit=$(expr $count_exit + 1)
        evaluar $count_exit
        oper="*"
        ;;
        "/")
        count_exit=$(expr $count_exit + 1)
        evaluar $count_exit
         oper="/"
        ;;
        *)
        num_array=(${num_array[*]} $i)
        esac
    done
    resul=$(expr ${num_arrray[0]} ${oper} ${num_arrray[1]})
    echo "Resultado de ${num_arrray[0]} ${oper} ${num_arrray[1]} = ${resut}"
else
    echo "No se enviaron los parametros necesarios. Se enviarion ${$#}."
    exit 1
fi
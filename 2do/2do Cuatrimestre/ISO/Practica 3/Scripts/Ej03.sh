#!/bin/bash

echo "Introduzca su nombre y apellido:"
read nombre apellido
echo "Fecha y hora actual: $(date)"
echo "Su apellido es ${apellido} y nombre es ${nombre}"
echo "Su usuario es: `whoami`"
echo "Su directorio actual es: $(pwd)"
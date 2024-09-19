# !/bin/bash

# Crear un script que muestre 3 opciones al usuario: Listar, DondeEstoy y QuienEsta.
# Según la opción elegida se le debe mostrar:
# Listar: lista el contenido del directoria actual.
# DondeEstoy: muestra el directorio donde me encuentro ubicado.
# QuienEsta: muestra los usuarios conectados al sistema

if test $# -eq 0 ; then

opci="1"
echo "Bienvenido al sistema."
while test $opci -gt 0 && test $opci -lt 4; do
    echo "-------------" ; echo "Ingrese:"
    echo "- 1 : Listar."
    echo "- 2 : DondeEstoy."
    echo "- 3 : QuienEsta."
    read opci

    case $opci in
    "1")
    	echo $(ls)
    ;;
    "2")
    	echo $(pwd)
    ;;
    "3")
	echo $(users)
    ;;
    *)
    break
    ;;
    esac
done
echo "Saliendo del sistema."
exit 0
else
	exit 1
if

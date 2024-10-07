# !/bin/bash
# Cada 10 seg saber si un usuario esta logeado, una vez logeado mostrarlo y salir

if [ $# -ne 1 ]; then
	echo "Error de formato"
	echo "Formato: <nombre_usuario>"
	exit 1
fi
while [ true ]; do
	echo "Buscando..."
	sleep 5s
	aux=$( who | cut -d " " -f1)
	for i in ${aux[*]}; do
		if [ $i == $1 ]; then
			echo "Usuario $1 logueado en el sistema"
			exit 0
		fi
	done
done

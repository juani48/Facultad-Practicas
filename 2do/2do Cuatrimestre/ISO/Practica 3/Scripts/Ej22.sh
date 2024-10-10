# !/bin/bahs

export num=(10 3 5 7 9 3 5 4)

function productoria(){
	aux=1
	for i in ${num[*]};do
		aux=$(expr $aux \* $i)
	done
	echo $aux
}

productoria

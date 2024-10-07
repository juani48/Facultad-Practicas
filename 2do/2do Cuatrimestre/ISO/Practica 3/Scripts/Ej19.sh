# !/bin/bash


while [ true ]; do
    ARRAY=$(ls)

    echo ${ARRAY[*]}

    exit 0
done

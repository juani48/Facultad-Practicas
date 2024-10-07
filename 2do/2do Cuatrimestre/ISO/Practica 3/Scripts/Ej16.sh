# !/bin/bash/

array=$(ls -l | grep "$1" | wc -l)
echo "$(whoami) $array"
exit 0


# !/bin/bash

echo $( ls | tr "[:lower:][:upper:]" "[:upper:][:lower:]" | tr -d "aA")

exit 0



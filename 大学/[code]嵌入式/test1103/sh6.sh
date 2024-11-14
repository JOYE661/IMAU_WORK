#!/bin/bash
num=-1
answer=$((RANDOM % 101))
read -p "plz enter num range(0-100)"
while [ $num != $answer ]
do
    if [ $num -lt $answer ]
    then
        echo "smal "
    elif [ $num -gt $answer ]
    then
        echo "big"
    fi
        read num
done
echo "RIGHT"

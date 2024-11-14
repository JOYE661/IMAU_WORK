#!/bin/bash
for i in {1..10}
do
    mkdir "dir${i}"
    for j in {1..10}
    do
        filename="./dir${i}/dir${i}file${j}"
        touch $filename
        chmod 755 $filename
    done
done

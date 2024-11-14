#!/bin/bash
read -p "plz enter num " num
for i in `ls dir${num}/*`
do
    mv ${i} ${i}.bak
done

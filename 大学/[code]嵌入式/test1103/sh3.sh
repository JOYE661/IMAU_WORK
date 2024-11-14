#!/bin/bash
count=0
function fun1(){
    for file in /*;do
        if [ -f "&file" ];then
            echo "$file"
            count++
        elif [ -d "$file" ];
        then
            fun1 "$file"
        fi
    done
}

fun1 /home/tarena
echo " the number of file is $count"



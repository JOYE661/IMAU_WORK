#!/bin/bash
read -p "plz enter name:" filename
if [ -z "$filename" ]; then
    echo "enter name is null"
else
    if [! -e "$filename" ];
    then
        echo "file dont exist"
    else
        if [ -f "$filename" ];
        then
            echo "file is ordinary"
        elif [ -d "$filename" ];
        then
            echo "file is d"
        else
            echo "file is other"
        fi
    fi
fi

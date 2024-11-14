#!/bin/bash
mkdir /home/tarena/test1103/test/backup
for file in `ls /home/tarena/test1103/dir1/`
do
    cp/home/tarena/test1103/test/dir1/$file /home/tarena/test1103/test/backup/$file-dir1-`date +%F`
done

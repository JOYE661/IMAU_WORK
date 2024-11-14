#include<stdio.h>
#include"stu.h"
void sort_grade(stu s[]){
    int i,j;
    stu temp;
    for(i=0;i<4;i++){
        for(j=0;j<4-i;j++){
            if(s[j].grade>s[j+1].grade){
                temp=s[j];
                s[j]=s[j+1];
                s[j+1]=temp;
            }
        }
    }
}


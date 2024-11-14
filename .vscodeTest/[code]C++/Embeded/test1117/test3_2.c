#include<stdio.h>
#include"stu.h"
void display(stu s[]){
    int i;
    for(i=0;i<5;i++){
        if(s[i].grade<60){
            printf("%d ,%s ,%d \n",s[i].sno,s[i].name,s[i].grade);
        }
    }
}

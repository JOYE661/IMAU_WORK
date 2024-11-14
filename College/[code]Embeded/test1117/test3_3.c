#include<stdio.h>
#include"stu.h"
int main(){
    stu s[5]={{1,"jo1",30},{2,"jo2",100},{3,"jo3",66},{4,"jo4",87},{5,"jo5",59}};
    sort_grade(s);
    int i;
    for(i=0;i<5;i++){
        printf("%d ,%s ,%d \n",s[i].sno,s[i].name,s[i].grade);
    }
    printf("show students who under 60\n");
    display(s);
    return 0;
}


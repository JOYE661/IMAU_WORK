#include<stdio.h>
typedef struct{
    int num;
    char name[20];
    int grade;
}stu;
int main(){
    stu sl={202101,"jo1",60};
    stu s[2]={{202102,"jo2",70},{202103,"jo3",80}};
    stu *p1=&sl;
    stu *p2;
    printf("%d,%s,%d\n",p1->num,p1->name,p1->grade);
    int i=0;
    for(i=0;i<2;i++){
    p2=s+i;
    printf("%d,%s,%d\n",p2->num,p2->name,p2->grade);
    }
    return 0;
}



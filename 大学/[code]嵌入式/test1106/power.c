#include<stdio.h>
#include"computer.h"
int main(){
    printf("plz enter two numbers\n");
    int a,b,he;
    scanf("%d",&a);
    scanf("%d",&b);
    he=sum(a,b);
    printf("a+b=%d",he);
    return 0;
}


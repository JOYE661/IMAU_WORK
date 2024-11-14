#include<stdio.h>
#include"mj.h"
#include"zc.h"
int main(void)
{
    float r,l,s;
    printf("please enter r:\n");
    scanf("%f",&r);
    l=zc(r);
    s=mj(r);
    printf("zc=%f,mj=%f",l,s);
    return 0;
}


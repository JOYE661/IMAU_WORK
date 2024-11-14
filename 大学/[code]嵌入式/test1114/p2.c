#include<stdio.h>
void swap(int *x,int *y)
{
    int temp;
    temp=*x;
    *x=*y;
    *y=temp;
}
int main(){
    int a,b;
    int *p_x,*p_y;
    printf("plz input a and b:\n");
    scanf("%d %d",&a,&b);
    p_x=&a;
    p_y=&b;
    swap(p_x,p_y);
    printf("a=%d,b=%d",a,b);
}



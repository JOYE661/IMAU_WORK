#include<stdio.h>
double funpi(double e)
{
    double item,sum=0;
    int flag=1,k;
    item=1;
    while(fabs(item)>=e)
    {
        item=flag*1.0/k;
        sum=sum+item;
        k=k+2;
        flag=-flag;
    }
    return sum*4;
}
int main()
{
    double e,Pl;
    scanf("%lf",&e);
    Pl=funpi(e);
    printf("%f",Pl);
    return 0;
}

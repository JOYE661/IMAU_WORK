#include<stdio.h>
double BMI(double x,double y)
{
    double z;
    z=x/(y*y);
    return z;
}
int main()
{
    double weight,height,bm;
    scanf("%lf%lf",&weight,&height);
    bm=BMI(weight,height);
    printf("bm=%f",bm);
    return 0;
}

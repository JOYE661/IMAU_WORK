#include<stdio.h>
double cy(double r,double h)
{
   double v;
   v=3.14*r*r*h;
   return v;
}
int main()
{
    double a,b;
    scanf("%lf%lf",&a,&b);
    double z;
    z=cy(a,b);
    printf("z=%f",z);
    return 0;
}

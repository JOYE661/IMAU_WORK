#include<stdio.h>
//#include<math.h>
//int pow(int a,)
double mypow(double x,int y)
{
    double z=1.0;
    for(int i=1;i<=y;i++)
    {
        z=z*x;
    }
    return z;
}
int main()
{
    //double x,z=1.0;
    //int y;
    double a,c;
    int b;
    scanf("%lf%d",&a,&b );
    //z=pow(x,y);
    c=mypow(a,b);
    printf("c=%f",c);
    return 0;
}

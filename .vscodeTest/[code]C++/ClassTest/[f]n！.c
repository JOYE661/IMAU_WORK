//输出a!+b!+c!
#include<stdio.h>
int fun(int x)
{
    int y=1;
    for(int i=1;i<=x;i++)
    {
        y=y*i;
    }
    return y;
}
int main()
{
    int a,b,n,m;
    scanf("%d%d%d",&a,&n,&m);
    b=fun(a)+fun(n)+fun(m);
    printf("a!+b!+c!=%d",b);
    return 0;
}

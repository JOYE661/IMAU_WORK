#include<stdio.h>
int main()
{
    int a[10],i,count=0;
    a[0]=a[1]=1;

    for(i=2;i<10;i++)
    {
       a[i]=a[i-1]+a[i-2];
    }
    for(i=0;i<10;i++)
    {
        printf("%5d",a[i]);
        count++;
        if(count%5==0)
        {
            printf("\n");
        }
    }
    return 0;
}

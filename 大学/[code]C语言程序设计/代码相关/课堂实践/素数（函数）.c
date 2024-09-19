#include<stdio.h>
#include<math.h>
int prime(int m)
{
    for(int i=2;i<=sqrt(m);i++)
    {
        if(m%i==0)
        return 0;
    }
     return 1;
}
int main()
{
    int m,bool,count=0;
    for(m=2;m<=100;m++)
    {
        bool=prime(m);
        if(bool==1)
        {
            printf("%d ",m);
            count++;
            if(count%5==0)
                printf("\n");
        }
    }
    return 0;
}

#include<stdio.h>

int main()
{
    void py(int n);
    int n;
    scanf("%d",&n);
    py(n);

    return 0;
}
void py(int n)
{
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=n-i;j++)
        {
            printf(" ");
        }
        for(int j=1;j<=i;j++)
        {
            printf("%d ",i);
        }
        printf("\n");
    }
}

#include<stdio.h>
int main()
{
    for(int i=1;i<=10;i++)
    {
        if(i<=5){
        for(int j=1;j<=2*i-1;j++)
        {
            printf("*");
        }
        printf("\n");
        }
        else{
        for(int j=1;j<=7-(i-6)*2;j++)
        {
            printf("*");
        }
        printf("\n");
        }
    }
    return 0;
}





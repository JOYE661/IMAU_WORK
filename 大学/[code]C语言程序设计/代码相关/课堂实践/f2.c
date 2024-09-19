#include<stdio.h>
void myprint(int n)
{
    for(int i=1;i<=n;i++)
   {
    printf("*");
    printf("\n");
   }
}
int main()
{
   int n;
   scanf("%d",&n);
   myprint(n);

   return 0;
}

#include<stdio.h>
int main()
{
int i,j,max;
scanf("%d",&max);
printf("\n");
for(i=1;i<max;i++)
{
for(j=1;j<=max-i;j+=1)
printf(" ");
for(j=2;j<i*2+1;j+=1)
printf("* ");
printf("\n");
}
for(i=max-1;i>0;i-=1)
{
for(j=1;j<=max-i;j+=1)
printf(" ");
for(j=2;j<i*2+1;j=j+1)
printf("* ");
printf("\n");
}
}

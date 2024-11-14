#include<stdio.h>
int day_of_year(int year,int mouth,int day)
{
    int k,leap;
    int tab[2][13]={{0,31,28,31,30,31,30,31,31,30,31,30,31},{0,31,29,31,30,31,30,31,31,30,31,30,31}};
    leap=(year%4==0&&year%100!=0)||year%400==0;
    for(k=1;k<mouth;k++)
        day=day+tab[leap][k];
    return day;
}
int main()
{
    int year,mouth,day,n;
    scanf("%d%d%d",&year,&mouth,&day);
    n=day_of_year(year,mouth,day);
    printf("%d",n);
    return 0;
}

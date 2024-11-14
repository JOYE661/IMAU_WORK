#include<stdio.h>
int main()
{
    int i;
    char **p;
    char *week[]={"Monday","Tuseday","Wensday","Thursday","Friday","Saturday","Sunday"};
    for(i=0;i<7;i++)
    {
        p=week+i;
        printf("%s\n",*p);
    }
    return 0;
}


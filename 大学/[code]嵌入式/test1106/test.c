#include<stdio.h>
extern void fun(void);
int main(void)
{
    printf("hello\n");
    fun();
    printf("hi--\n");
    return 0;
}


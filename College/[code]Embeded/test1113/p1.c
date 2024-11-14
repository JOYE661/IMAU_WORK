#include<stdio.h>
int main(){
    long i;
    long *p;
    p=&i;
    printf("plz enter a num:\n");
    scanf("%ld",&i);
    printf("result1=%ld\n",&*p);
    printf("result2=%ld\n",&i);
    return 0;
}


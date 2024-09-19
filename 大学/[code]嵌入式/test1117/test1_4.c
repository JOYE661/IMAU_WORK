#include<stdio.h>
int main(){
    char a[20]={"hello world"};
    char *p;
    p=a;
    int i;
    for(i=6;i<11;i++){
        p=a+i;
        printf("%c",*p);
    }
    printf("\n");
    return 0;
}


#include<stdio.h>
#include<string.h>
void *ad(char *c1,char *c2){
    char *p1,*p2;
    int i;
    p1=c1;
    p2=c2;
    for(i=0;i<5;i++){
        printf("%c",*(p1+i));
    }
    for(i=2;i<strlen(c2);i++){
        printf("%c",*(p2+i));
    }
    printf("\n");
}
int main(){
    char c1[30]={"hello student"};
    char c2[30]={"my embedded homework"};

    void *p,*ad();
    p=ad(c1,c2);
    return 0;
}


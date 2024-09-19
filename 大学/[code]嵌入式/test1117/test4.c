#include<stdio.h>
int main(int argc,char *argv[]){
    int i;
    int a=atoi(argv[1]);
    char c=argv[2][0];
    int b=atoi(argv[3]);
    double result;
    switch(c){
        case '+':
            result=a+b;
            printf("%d+%d=%lf\n",a,b,result);
            break;
        case '-':
            result=a-b;
            printf("%d-%d=%lf\n",a,b,result);
            break;
        case '*':
            result=a/b;
            printf("%d*%d=%lf\n",a,b,result);
            break;
        case '/':
            result=a/b;
            printf("%d/%d=%lf\n",a,b,result);
            break;
        default:
            printf("error\n");
            break;
    }
    return 0;
}


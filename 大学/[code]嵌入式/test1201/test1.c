#include<stdio.h>
float add(float a,float b){
    return a+b;
}
float sub(float a,float b){
    return a-b;
}
float mul(float a,float b){
    return a*b;
}
float div(float a,float b){
    return a/b;
}
int main(){
    float a=10;
    float b=2;
    float (*p)(float a,float b);
    p=add;
    printf("a+b=%f\n",(*p)(a,b));
    p=sub;
    printf("a-b=%f\n",(*p)(a,b));
    p=mul;
    printf("a*b=%f\n",(*p)(a,b));
    p=div;
    printf("a/b=%f\n",(*p)(a,b));
    return 0;
}



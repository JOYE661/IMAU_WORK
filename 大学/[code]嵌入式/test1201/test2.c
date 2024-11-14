#include<stdio.h>
void early(){
    printf("now is early time\n");
}
void middly(){
    printf("now is middly time\n");
}
void lately(){
    printf("now is lately time\n");
}
int main(){
    int data;
    void (*p)();
    printf("plz enter num");
    scanf("%d",&data);
    if(data<=1000){
        p=early;
        (*p)();
    }
    else if(data>1000&&data<=5000){
        p=middly;
        (*p)();
    }
    else{
        p=lately;
        (*p)();
    }
    return 0;
}


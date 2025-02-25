//顺序表递增有序，插入元素x,仍然递增有序
#include<stdio.h>
#define MAXSIZE 5
typedef struct{
    int date[MAXSIZE];
    int length;
}SqList;

int main(){
    SqList L;
    
    for(int i=0;i<MAXSIZE;i++){
        int date=0;
        scanf("%d\n",&date);
        L.date[i]=date;
    }
    for(int i=0;i<MAXSIZE;i++){
        printf("%d\n",L.date[i]);
    }
    return 0;
}
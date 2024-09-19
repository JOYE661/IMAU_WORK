#include<stdio.h>
#include"inputNum.h"
void readNums(int arr[],int n){
    printf("plz enter num for %d \n",n);
    int i;
    for(i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
}


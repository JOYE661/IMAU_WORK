#include<stdio.h>
#include"Caculator.h"
int sumNums(int arr[],int n){
    int sum=0;
    int i;
    for(i=0;i<n;i++){
        sum+=arr[i];
    }
    return sum;
}


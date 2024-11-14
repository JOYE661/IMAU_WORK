#include<stdio.h>
int main(){
    int *pt;
    int arr[5]={1,2,3,4,5};
    int i;
    for(i=0;i<5;i++){
        pt=arr+i;
        printf("%d",*pt);
    }
    return 0;
}


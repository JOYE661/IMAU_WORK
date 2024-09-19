#include<stdio.h>
void *sort(int *arr,int len){
    int i,j,temp;
    for(i=0;i<len-1;i++){
        for(j=0;j<len-i-1;j++){
            if(arr[j]>arr[j+1]){
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
    }
}
int main(){
    int arr[5]={0,6,9,5,1};
    void *p,*sort();
    int i;
    int len=(int)sizeof(arr)/sizeof(arr[0]);
    p=sort(arr,len);
    for(i=0;i<len;i++){
        printf("%d",arr[i]);
    }
    printf("\n");
    return 0;
}


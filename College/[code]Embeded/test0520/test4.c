#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
int sum=0;
void* thread1(){
    int c;
    for(c=0;c<=10;c++){
        sum=sum+c;
    }
    printf("sum=%d\n",sum);
}
int main(){
    int i,ret;
    pthread_t id;
    ret=pthread_create(&id,NULL,thread1,NULL);
    if(ret!=0){
        printf("fail\n");
    }
    pthread_join(id,NULL);
    
    printf("线程结束,返回主线程\n");
    return 0;
}



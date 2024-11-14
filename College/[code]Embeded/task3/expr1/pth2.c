#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
void* thread1(){
    int i;
    printf("this thread id is %lu\n",pthread_self());
    while(1){
        printf("this is thread1\n");
    }
}
int main(){
    int i,ret;
    pthread_t id;
    ret=pthread_create(&id,NULL,thread1,NULL);
    if(ret!=0){
        printf("fail\n");
    }
    printf("main thread id is %lu\n",pthread_self());
   // pthread_join(id,NULL);
    pthread_cancel(id);
    for(i=0;i<5;i++){
        printf("this is main\n");
    }
    return 0;
}

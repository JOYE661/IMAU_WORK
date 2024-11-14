#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
void* thread1(void *arg){
    int i;
    int *val=arg;
    printf("this thread id is %lu\n",pthread_self());
    for(i=0;i<5;i++){
        printf("this is thread1 argment is%d\n",*val);
    }
}
int main(){
    int i,ret,t_arg=100;
    pthread_t id;
    ret=pthread_create(&id,NULL,thread1,&t_arg);
    if(ret!=0){
        printf("fail\n");
    }
    printf("main thread id is %lu\n",pthread_self());
    pthread_join(id,NULL);
    for(i=0;i<5;i++){
        printf("this is main\n");
    }
    return 0;
}

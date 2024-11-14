#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
void* thread1(){
    int i;
    printf("this thread id is %lu\n",pthread_self());
    for(i=0;i<5;i++){
        printf("this is thread1\n");
    }
}
void* thread2(){
    int i;
    printf("this thread id is %lu\n",pthread_self());
    for(i=0;i<5;i++){
        printf("this is thread2\n");
    }
    sleep(1);
}
int main(){
    int i,ret1,ret2;
    pthread_t id1,id2;
    ret1=pthread_create(&id1,NULL,thread1,NULL);
    if(ret1!=0){
        printf("fail\n");
    }
    ret2=pthread_create(&id2,NULL,thread2,NULL);
    if(ret2!=0){
        printf("fail\n");
    }
    printf("main thread id is %lu\n",pthread_self());
//    pthread_join(id1,NULL);
//    pthread_join(id2,NULL);
    sleep(3);
    for(i=0;i<5;i++){
        printf("this is main\n");
    }
    return 0;
}

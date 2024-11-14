#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
pthread_mutex_t mutex;
pthread_cond_t cond;
void* thread1(){
    pthread_mutex_lock(&mutex);
    int i;
    printf("this thread id is %lu\n",pthread_self());
    for(i=0;i<5;i++){
        printf("this is thread1\n");
    }
    pthread_cond_signal(&cond);
    pthread_mutex_unlock(&mutex);
}
void* thread2(){
    pthread_mutex_lock(&mutex);
    pthread_cond_wait(&cond,&mutex);
    int i;
    printf("this thread id is %lu\n",pthread_self());
    for(i=0;i<5;i++){
        printf("this is thread2\n");
    }
    sleep(1);
    pthread_mutex_unlock(&mutex);
}
int main(){
    pthread_mutex_init(&mutex,NULL);
    pthread_cond_init(&cond,NULL);
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
    pthread_cond_destroy(&cond);
    pthread_mutex_destroy(&mutex);
    return 0;
}

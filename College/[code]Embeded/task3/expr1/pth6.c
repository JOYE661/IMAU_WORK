#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<semaphore.h>
pthread_mutex_t mutex;
sem_t sem;
void* thread1(){
//    pthread_mutex_lock(&mutex);
    sem_wait(&sem);
    int i;
    printf("this thread id is %lu\n",pthread_self());
    for(i=0;i<5;i++){
        printf("this is thread1\n");
    }
    sem_post(&sem);
//    pthread_mutex_unlock(&mutex);
}
void* thread2(){
//    pthread_mutex_lock(&mutex);
    sem_wait(&sem);
    int i;
    printf("this thread id is %lu\n",pthread_self());
    for(i=0;i<5;i++){
        printf("this is thread2\n");
    }
    sleep(1);
    sem_post(&sem);
//    pthread_mutex_unlock(&mutex);
}
int main(){
    pthread_mutex_init(&mutex,NULL);
    sem_init(&sem,0,1);
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
    pthread_mutex_destroy(&mutex);
    return 0;
}

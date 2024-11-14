#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<semaphore.h>
pthread_mutex_t mutex;
pthread_cond_t cond;
sem_t semaphore;
void* thread1(){
//    pthread_mutex_lock(&mutex);
    sem_wait(&semaphore);
    int i;
    printf("this thread id is %lu\n",pthread_self());
    for(i=0;i<2;i++){
        printf("this is thread1\n");
    }
//    pthread_cond_signal(&cond);
    sleep(2);
    sem_post(&semaphore);
//    pthread_mutex_unlock(&mutex);
}
void* thread2(){
//    pthread_mutex_lock(&mutex);
//    pthread_cond_wait(&cond,&mutex);
    sem_wait(&semaphore);
    int i;
    printf("this thread id is %lu\n",pthread_self());
    for(i=0;i<3;i++){
        printf("this is thread2\n");
    }
    sleep(2);
    sem_post(&semaphore);
//    pthread_mutex_unlock(&mutex);
}
void* thread3(){
//    pthread_mutex_lock(&mutex);
//    pthread_cond_wait(&cond,&mutex);
    sem_wait(&semaphore);
    int i;
    printf("this thread id is %lu\n",pthread_self());
    for(i=0;i<4;i++){
        printf("this is thread3\n");
    }
    sleep(2);
    sem_post(&semaphore);
//    pthread_mutex_unlock(&mutex);
}
int main(){
    pthread_mutex_init(&mutex,NULL);
//    pthread_cond_init(&cond,NULL);
    sem_init(&semaphore,0,2);
    int ret1,ret2,ret3;
    pthread_t id1,id2,id3;
    ret1=pthread_create(&id1,NULL,thread1,NULL);
    if(ret1!=0){
        printf("fail\n");
    }
    ret2=pthread_create(&id2,NULL,thread2,NULL);
    if(ret2!=0){
        printf("fail\n");
    }
    ret3=pthread_create(&id3,NULL,thread3,NULL);
    if(ret3!=0){
        printf("fail\n");
    }
//    printf("main thread id is %lu\n",pthread_self());
//    pthread_join(id1,NULL);
//    pthread_join(id2,NULL);
//    pthread_join(id3,NULL);
    sleep(3);
//    pthread_cond_destroy(&cond);
    sem_destroy(&semaphore);
    pthread_mutex_destroy(&mutex);
    return 0;
}

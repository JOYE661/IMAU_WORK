#include<stdio.h>
#include<pthread.h>
#include<semaphore.h>
#include<stdlib.h>
#include<time.h>
sem_t sem;
void *task(void *p){
    int i=(int)p;
    printf("第%d 个线程申请连接\n",i);
    sem_wait(&sem);
    printf("第%d个线程申请成功\n",i);
    srand(time(0));
    int r=rand()%10+1;
    sleep(r);
    printf("第%d个线程释放连接\n",i);
    sem_post(&sem);
}
int main(){
    sem_init(&sem,0,5);
    int i;
    for(i=0;i<20;i++){
        pthread_t id;
        pthread_create(&id,0,task,(void*)(i+1));
    }
    pause();
}

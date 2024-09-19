#include<stdio.h>
#include<pthread.h>
char str[20];
int count=0;
pthread_mutex_t mutex;

void *run1()
{
    while(1)
    {
        pthread_mutex_lock(&mutex);
        sprintf(str,"run-----1");
        printf("%s,count=%d\n",str,count);
        sleep(5);
        pthread_mutex_unlock(&mutex);
        usleep(1);
    }

}
void *run2()
{
    while(1)
    {
        pthread_mutex_lock(&mutex);
        sprintf(str,"run-----2");
        printf("%s,count=%d\n",str,count);
        sleep(2);
        pthread_mutex_unlock(&mutex);
        usleep(1);
    }

}

int main(int argc,char *argv[]){
    pthread_mutex_init(&mutex,NULL);
    pthread_t tid1,tid2;
    int ret1,ret2;
    ret1=pthread_create(&tid1,NULL,run1,NULL);
    if(ret1!=0)
        printf("thread create failed\n");
    ret2=pthread_create(&tid2,NULL,run2,NULL);
    if(ret2!=0)
        printf("thread create failed\n");
    pthread_join(tid1,NULL);
    pthread_join(tid2,NULL);
    pthread_mutex_destroy(&mutex);

    return 0;
}


#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
void* func()
{
    int i;
    printf("my id is %lu\n",pthread_self());
    for(i=0;i<5;i++){
        printf("I am pthread!\n");
    }
}
int main()
{
    int i,ret;
    pthread_t id;
    ret= pthread_create(&id,NULL,func,NULL);
    if(ret!=0)
        printf("Fail!\n");
    printf("pthread id is %lu,this pthread id is%lu.\n",id,pthread_self());
   // sleep(1);
    pthread_join(id,NULL);
    for(i=0;i<5;i++){
        printf("I am main\n");
    }
    return 0;
}

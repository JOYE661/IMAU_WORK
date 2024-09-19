#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
void* func()
{
    int i;
    while(1){
    for(i=0;i<5;i++){
        printf("I am pthread!\n");
    }
    }
}
int main()
{
    int i,ret;
    pthread_t id;
    ret= pthread_create(&id,NULL,func,NULL);
    if(ret!=0)
        printf("Fail!\n");
    pthread_cancel(id);
    sleep(1);
    for(i=0;i<5;i++){
        printf("I am main\n");
    }
    return 0;
}

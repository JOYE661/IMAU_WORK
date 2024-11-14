#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
void* func()
{
    int i;
    for(i=0;i<5;i++){
        printf("i=%d\n",i);
        if(i==3)
            pthread_exit((void*)i);
    }
}
int main()
{
    int i,ret;
    pthread_t id;
    ret= pthread_create(&id,NULL,func,NULL);
    if(ret!=0)
        printf("Fail!\n");
    pthread_join(id,(void**)&res);
    printf("res=%d\n");
    for(i=0;i<5;i++){
        printf("I am main\n");
    }
    return 0;
}

#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
void* func(void *arg)
{
    int *val=arg;
    int i;
    for(i=0;i<5;i++){
        printf("I am pthread!the argment is%d.\n"*val);
    }
}
int main()
{
    int i,ret,t_arg=100;
    pthread_t id;
    ret= pthread_create(&id,NULL,func,&t_arg);
    if(ret!=0)
        printf("Fail!\n");
    sleep(1);
    for(i=0;i<5;i++){
        printf("I am main\n");
    }
    return 0;
}

#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
void* func1()
{
    int i;
    for(i=0;i<5;i++){
        printf("I am pthread1!\n");
    }
    sleep(1);
}
void* func2()
{
    int i;
    for(i=0;i<5;i++){
        printf("I am pthread2!\n");
    }
    sleep(1);
}
int main()
{
    int i,ret1,ret2;
    pthread_t id1,id2;
    ret1= pthread_create(&id1,NULL,func1,NULL);
    ret2= pthread_create(&id2,NULL,func2,NULL);
    if(ret1!=0)
        printf("pt1 Fail!\n");
    if(ret2!=0)
        printf("pt2 Fail!\n");
    sleep(3);
    for(i=0;i<5;i++){
        printf("I am main\n");
    }
    return 0;
}

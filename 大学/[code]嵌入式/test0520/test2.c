#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
void* thread1(){
    char c;
    for(c='A';c<='F';c++){
        printf("%c\n",c);
    }
}
int main(){
    int i,ret;
    pthread_t id;
    ret=pthread_create(&id,NULL,thread1,NULL);
    if(ret!=0){
        printf("fail\n");
    }
    pthread_join(id,NULL);
    for(i=1;i<=5;i++){
        printf("%d\n",i);
    }
    return 0;
}

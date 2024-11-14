#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
#include<errno.h>
int main(int argc,char *argv[])
{
    char buf[256];
    pid_t pid;
    pid=fork();
    if(pid<0){
        return 0;
    }
    else if(pid==0)
    {
        strcpy(buf,"我是子进程")；
        int i,a=5;
        for(i=0;i<5;i++){
            printf("I am son, i=%d\n",i);
            sleep(1);
        }

    }
    else
    {
        strcpy(buf,"我是父进程");
        int i,a=10;
        for(i=5;i<a;i++){
            printf("I am parent,i=%d\n",i);
            sleep(3);
        }
    }
    printf("%S,my pid id %d\n",buf,getpid());

    return 0;
}


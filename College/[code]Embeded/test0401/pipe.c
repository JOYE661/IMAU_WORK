#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<unistd.h>
#include<sys/wait.h>

int main(int argc,char *argv[])
{
    int fd[2];
    int err=pipe(fd);
    if(err==-1){
        printf("pipe error!\n");
        exit(0);
    }
    pid_t pid=fork();
    if(pid==-1)exit(0);
    else if(pid==0){
        close(fd[1]);
        char buf[256]={0};
        int size=read(fd[0],buf,256);
        if(size>0)
            printf("son read is %s\n",buf);
        else
            printf("read failed!\n");
        close(fd[0]);
        exit(0);
    }
    else if(pid>0)
    {
        close(fd[0]);
        char *str="abcdefgh";
        int size=write(fd[1],str,strlen(str));
        sleep(5);
        close(fd[1]);
        wait(NULL);
        exit(0);
    }
    return 0;


 }

    

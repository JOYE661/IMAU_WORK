#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
int main(){
    int fd[2];
    char buff[80];
    pipe(fd);
    if(fork()>0){
        close(fd[0]);
        char s[]="123456\n";
        printf("父进程写入%s",s);
        write(fd[1],s,sizeof(s));
    }
    else{
        close(fd[1]);
        read(fd[0],buff,sizeof(buff));
        printf("子进程读出%s",buff);
    }
    return 0;
}

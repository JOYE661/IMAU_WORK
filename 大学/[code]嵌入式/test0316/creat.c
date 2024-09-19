#include<stdio.h>
#include<fcntl.h>
#include<errno.h>

int main(int argc,char *argv[])
{
    int fd;
    fd= creat(argv[1],666);
    if(fd<0){
        printf("create failed !%s\n",strerror(errno));
    }
    else{
        printf("create success! fd=%d\n",fd);
    }
     return 0;
}


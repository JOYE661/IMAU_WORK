#include<stdio.h>
#include<string.h>
#include<unistd.h>
#include<stdio.h>
#include<fcntl.h>
#include<errno.h>

int main(int argc,char *argv[])
{
    int fd,err;
    err= access(argv[1],666);
    printf("err=%d,seestr=%s\n",errno,strerror(errno));
    fd= open(argv[1],O_CREAT|O_RDWR,666);
    if(fd<0)
        printf("open failed!\n");
    else
        printf("open success,fd=%d\n",fd);
    close(fd);
     return 0;
}


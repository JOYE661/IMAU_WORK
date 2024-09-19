#include<stdio.h>
#include<string.h>
#include<unistd.h>
#include<stdio.h>
#include<fcntl.h>
#include<errno.h>

int main(int argc,char *argv[])
{
    int fd,err;
    char *buf="abcdefghjijklmn";
    char buf1[256];
    err= access(argv[1],666);
    printf("err=%d,seestr=%s\n",errno,strerror(errno));
    fd= open(argv[1],O_CREAT|O_RDWR,666);
    if(fd<0)
        printf("open failed!\n");
    else
        printf("open success,fd=%d\n",fd);
    int ret,ret1;
    ret=write(fd,buf,10);
    printf("write %d byte to file %s\n",ret,argv[1]);
    lseek(fd,0,SEEK_SET);
    ret1=read(fd,buf1,5);
    printf("read result is %s\n",buf1);
    close(fd);
    return 0;
}


#include<stdio.h>
#include<sys/stat.h>
#include<errno.h>

int main(int argc,char *argv[])
{
    int err;
    err= mkdir(argv[1],666);
    if(err==-1)
        printf("Dir create failed,error no=%d,err info:%s\n",errno,strerror(errno));
    else
        printf("Dir create successs!");

    return 0;
}


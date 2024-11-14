#include<stdio.h>
#include<unistd.h>
#include<errno.h>
#include<string.h>
#include<sys/types.h>
#include<sys/stat.h>
int main(int argc,char *argv[])
{
    struct stat aa;
    int err=stat(argv[1],&aa);
    if(err==-1)return -1;
    if(S_ISDIR(aa.st_mode))
        printf("is dir\n");
    else if(S_ISREG(aa.st_mode))
        printf("is file\n");
    return 0;
}


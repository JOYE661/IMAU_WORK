#include<stdio.h>
#include<sys/stat.h>
#include<sys/types.h>
#include<string.h>
#include<fcntl.h>
#include<unistd.h>
int main(){
    int fd=open("/tmp/myfifo",O_RDONLY);
    if(fd==-1){
        printf("open error!\n");
        return 0;
    }
    char buf[256];
    while(1){
        bzero(buf,256);
        int size=read(fd,buf,256);
        printf("read size=%d,buf=%s",size,buf);
        if(strcmp(buf,"q")==0)break;
    }
    close(fd);
    return 0;
}


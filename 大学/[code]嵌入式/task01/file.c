#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<unistd.h>
#include<fcntl.h>
int main(){
    char *file="myfile";
    char *word="Hello world";
    int fd=open(file,O_CREAT|O_WRONLY,0666);
    write(fd,word,strlen(word));
    close(fd);
    char buff[1024];
    fd=open(file,O_RDONLY);
    ssize_t bytesRead=read(fd,buff,sizeof(buff));
    printf("Read bytes:%s\n",buff);
    close(fd);
    char buf[1024];
    off_t offset=6;
    fd=open(file,O_RDONLY);
    lseek(fd,offset,0);
    bytesRead=read(fd,buf,sizeof(buf));
    printf("Read bytes:%s\n",buf);
    return 0;
}

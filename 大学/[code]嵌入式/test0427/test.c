#include<stdio.h>
#include<string.h>
#include<fcntl.h>
#include<sys/types.h>
#include<sys/stat.h>
int main(){
    int fp;
    char buf1[]="我有一头小猫";
    char buf2[100];
    open("/dev/wanger",O_RDWR);
    if(fp<0){
        printf("device open failed\n");
        return -1;
    }
    else
        printf("devie open success!\n");
    printf("Begin write to wanger\n");
    write(fp,&buf1,strlen(buf1));
    printf("Writer over!\n");
    printf("Begin read from wanger\n");
    read(fp,&buf2,15);
    printf("read finish, the result is %s\n",buf2);
    close(fp);
    return 0;
}


#include <sys/types.h>
#include <sys/stat.h>
#include <string.h>
#include <stdio.h>
#include <fcntl.h>

int main(void)
{   int fp,i;
    char buf1[]="abcdefghijklmnopqrstuvwxyz01234567890123456789";
    char buf2[50];
    for(i=0;i<50;i++){
        buf2[i]=0;
                      }
    fp=open("/dev/my_char",O_RDWR);
    if(fp<0){
         printf("open device failed!\n");
         return -1;
              }
         printf("Begin to write [%s] to my_device.\n",buf1);
         write(fp,&buf1,strlen(buf1));
         printf("Write finished!\n");
         printf("Begin to read 30 bytes from my_device.\n");
         read(fp,&buf2,30);
         printf("Read finished!\n");
         printf("The message from my_device is [%s].\n",buf2);
         close(fp);
         return 0;
}    

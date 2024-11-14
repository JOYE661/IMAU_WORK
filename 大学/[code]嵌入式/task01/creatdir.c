#include<stdio.h>
#include<sys/stat.h>
#include<errno.h>
int main(int argc,char **argv){
   int err= mkdir(argv[1],0666);
   if(err==-1){
       printf("creat error");
   }
   return 0;
}


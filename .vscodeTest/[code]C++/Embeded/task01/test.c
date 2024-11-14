#include<stdio.h>
#include<sys/stat.h>
#include<sys/stat.h>
#include<stdlib.h>
#include<dirent.h>
int main(int argc,char **argv){
   char dirname[100];
   printf("plz enter dir name");
   scanf("%s",dirname);
   mkdir(dirname,0666);
   char current_dir[100];
   getcwd(current_dir,100);
   printf("curent dirpath is:%s\n",current_dir);

   DIR *dir=opendir(".");
   struct stat dir_stat;
   stat(dirname,&dir_stat);
   if(S_ISDIR(dir_stat.st_mode)){
       printf("当前目录是一个目录\n");
    }
   else if(S_ISREG(dir_stat.st_mode)){
       printf("当前目录是一个文件\n");
   }
   struct dirent *entry;
   while((entry=readdir(dir))!=NULL){
       printf("目录名称-%s\n",entry->d_name);
   }

   return 0;
}

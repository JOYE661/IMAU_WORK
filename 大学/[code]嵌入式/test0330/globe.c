#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<linux/wait.h>
int A=1;
int main(int argc,char *argv[]){
    int i=0;
    pid_t pid =fork();
    if(pid==-1)return 0;
    else if(pid==0){
        printf("son pid=%d\n",getpid());
        printf("father's pid =%d\n",getppid());
        A=10;
        while(1){
            printf("som--,i=%d,A-%d\n",i,A);
            sleep(1);
            A++;
            i++;
            if(i==5){
                return 111;
            }
        }
        printf("son is over\n");
    }
    else if(pid>0){
        printf("parent pid =%d\n",getpid());
        int a;
        for(a=0;a<5;a++){
            printf("I am father,A=%d\n",A);
            A++;
            sleep(2);
        }
    }
    for(i=0;i<3;i++)
    {
        printf("i am main,A=%d\n",A);
        A++;
        sleep(1);
    }

    return 0;
}

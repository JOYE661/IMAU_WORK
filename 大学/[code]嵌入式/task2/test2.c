#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
void child(int id){
    printf("son %d runing,id=%d\n",id,getpid());
    if(id==1){
        sleep(3);
        printf("正常结束\n");
        exit(id);
    }
    else if(id==2){
        sleep(3);
        printf("异常结束\n");
        abort();
    }
}

int main(int argc, char**argv){
    pid_t pid;
    int i;
    for(i=1;i<3;i++){
        pid=fork();
        if(pid==-1){
            return 0;
        }
        else if(pid==0){
            child(i);
        }
    }
    int a;
    wait(&a);
    printf("---a=%d\n",a>>8);
    return 0;
}


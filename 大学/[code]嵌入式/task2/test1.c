#include<stdio.h>
#include<unistd.h>
int global=0;
int main(int argc,char**argv){
    pid_t pid=fork();
    if(pid==-1){
        return 0;
    }
    else if(pid==0){
        int i;
        for(i=0;i<3;i++){
            global++;
            printf("in son global++, global=%d\n",global);
        }
    }
    else if(pid>0){
        int i;
        for(i=0;i<6;i++){
            global++;
            printf("in father global++, global=%d\n",global);
        }
    }
    int i;
    for(i=0;i<4;i++){
        global++;
        printf("in main global++, global=%d\n",global);
    }

    return 0;
}


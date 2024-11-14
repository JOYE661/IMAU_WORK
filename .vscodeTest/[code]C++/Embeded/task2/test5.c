#include<stdio.h>
#include<stdlib.h>
#include<sys/ipc.h>
#include<unistd.h>
#include<sys/shm.h>
#include<sys/types.h>
int main(){
    int shm_id;
    shm_id=shmget(IPC_PRIVATE,1024,0666);
    if(shm_id==-1){
        perror("shmget");
        exit(1);
    }
    char *p;
    p=shmat(shm_id,0,0);
    sprintf(p,"Share me\n");
    printf(" Data in Shared memory:%s\n",p);
    shmdt(p);
    shmctl(shm_id,IPC_RMID,0);
    return 0;

}

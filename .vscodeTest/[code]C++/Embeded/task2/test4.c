#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<errno.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/ipc.h>
#include<sys/msg.h>
struct my_msg_st
{
    long int my_msg_type;
    char some_text[512];
};
int main(){
    struct my_msg_st some_data;
    int msgid;
    char buff[512];
    msgid=msgget((key_t)1234,0666|IPC_CREAT);
    some_data.my_msg_type=1;
    sprintf(some_data.some_text,"hello world");
    msgsnd(msgid,(void*)&some_data,512,0);
    return 0;
}
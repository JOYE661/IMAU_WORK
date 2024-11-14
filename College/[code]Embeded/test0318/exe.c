#include<unistd.h>
#include<stdio.h>

int main()
{
    execl("/bin/ls","ls","-l","-a","-i",NULL);
    return 0;
}


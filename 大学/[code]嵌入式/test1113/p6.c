#include<stdio.h>
int main(int argc,char* argv[]){
    int n,i,s=0;
    n=atoi(argv[1]);
    if(argc<2)
        return 0;
    for(i=0;i<=n;i++)
        s+=i;
    printf("sum=%d\n",s);
    return 0;
}


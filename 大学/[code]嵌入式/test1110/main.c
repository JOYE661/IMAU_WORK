#include<stdio.h>
#include"myDisplay.h"
#include"inputNum.h"
int main(){
    int a[5];

    readNums(a,5);
    display(a,5);

    return 0;
}



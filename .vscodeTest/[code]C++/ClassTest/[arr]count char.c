//输入一个以回车结束的字符串（少于80个字符），统计其中数字字符。
#include<stdio.h>
int main()
{
    int count,i;
    char str[80];
    printf("Enter a string:");
    i=0;
    while((str[i]=getchar())!='\n')
        i++;
    str[i]='\0';
    count=0;
    for(i=0;str[i]!='\0';i++)
    if(str[i]<='9'&&str[i]>='0')
        count++;
    printf("count=%d\n",count);
    return 0;
}

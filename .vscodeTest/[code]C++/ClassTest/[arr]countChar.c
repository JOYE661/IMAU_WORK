//����һ���Իس��������ַ���������80���ַ�����ͳ�����������ַ���
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

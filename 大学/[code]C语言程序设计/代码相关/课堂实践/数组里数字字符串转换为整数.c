#include<stdio.h>
int main()
{
    int i,n;
    char s[10];
    //�����ַ���
    printf("Enter a string:");
    i=0;
    while((s[i]=getchar())!='\n')
        i++;
    s[i]='\0';
    //���ַ���ת��Ϊ����
    n=0;
    for(i=0;s[i]!='\0';i++)
        if(s[i]<='9'&&s[i]>='0')
            n=n*10+(s[i]-'0');
        else
            break;
        printf("digit=%d\n",n);
        return 0;
}

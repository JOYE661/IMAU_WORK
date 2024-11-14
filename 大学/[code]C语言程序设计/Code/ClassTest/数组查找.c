//输出5个互异的整数，将它们存入数组a中，再输入一个整数x，在数组中查找x,找到输出下标，否则输入not found
#include<stdio.h>
int main()
{
    //输入数组和需查找数
    int a[5],flag=0,x;
    for(int i=0;i<5;i++) scanf("%d",&a[i]);
    printf("input:");
    scanf("%d",&x);
    printf("\n");
    //查找
    for(int i=0;i<5;i++)
    {
        if(x==a[i])
        {
            printf("下标值=%d\n",i);
            flag=1;
            break;
        }
    }
    //找不到
    if(flag==0)
    {
        printf("not found");
    }
    return 0;
}

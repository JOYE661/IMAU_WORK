//���5������������������Ǵ�������a�У�������һ������x���������в���x,�ҵ�����±꣬��������not found
#include<stdio.h>
int main()
{
    //����������������
    int a[5],flag=0,x;
    for(int i=0;i<5;i++) scanf("%d",&a[i]);
    printf("input:");
    scanf("%d",&x);
    printf("\n");
    //����
    for(int i=0;i<5;i++)
    {
        if(x==a[i])
        {
            printf("�±�ֵ=%d\n",i);
            flag=1;
            break;
        }
    }
    //�Ҳ���
    if(flag==0)
    {
        printf("not found");
    }
    return 0;
}

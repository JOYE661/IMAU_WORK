#include<stdio.h>
int main()
{
    int i=0,j=0,k=0,temp=0,a[10];
    for(i=0;i<10;i++)
    scanf("%d",&a[i]);
    printf("\n");
    //����10������
    for(i=0;i<=8;i++)
    {
        k=i;
        for(j=k+1;j<10;j++)
        {
            if(a[k]>a[j])
                k=j;
            temp=a[i];a[i]=a[k];a[k]=temp;
        }
    }
    //ѡ������
    for(i=0;i<10;i++)
    printf("%4d ",a[i]);
    //���
    return 0;
}

#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
typedef struct node
{
    int data;
    struct node*next;
}Node;
void ysflb(int n,int k)//��n�ˣ�����k����
{   //����ͷ���
    Node *head=NULL,*p=NULL,*r=NULL;
    head=(Node*)malloc(sizeof(Node));
    if(head==NULL)
    {
        printf("error");
        return;
    }
    head->data=0;
    head->next=NULL;
    p=head;
    //β�巨��������
    for(int i=1;i<n;i++)
    {
        r=(Node*)malloc(sizeof(Node));
        r->data=i;
        r->next=NULL;
        p->next=r;
        p=r;
    }
    p->next=head;//����ѭ������
    p=head;
    while(p->next!=p)//ֱ��ʣ�����һ��ֹͣ
    {
        for(int i=1;i<k;i++)
        {
            r=p;
            p=p->next;//pΪ���ֽ�������
        }
        printf("%d ",p->data);
        r->next=p->next;//ɾ�����ֽ��
        p=p->next;
    }
    printf("%d",p->data);
}
int main()
{
    int n,m;
    scanf("%d%d",&n,&m);
    ysflb(n,m);
    return 0;
}


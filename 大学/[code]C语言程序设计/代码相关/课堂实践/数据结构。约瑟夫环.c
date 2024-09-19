#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
typedef struct node
{
    int data;
    struct node*next;
}Node;
void ysflb(int n,int k)//共n人，报道k出局
{   //创建头结点
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
    //尾插法创建链表
    for(int i=1;i<n;i++)
    {
        r=(Node*)malloc(sizeof(Node));
        r->data=i;
        r->next=NULL;
        p->next=r;
        p=r;
    }
    p->next=head;//创建循环链表
    p=head;
    while(p->next!=p)//直到剩下最后一个停止
    {
        for(int i=1;i<k;i++)
        {
            r=p;
            p=p->next;//p为出局结点的坐标
        }
        printf("%d ",p->data);
        r->next=p->next;//删除出局结点
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


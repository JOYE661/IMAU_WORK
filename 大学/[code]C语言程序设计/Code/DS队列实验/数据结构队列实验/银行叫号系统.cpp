#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
/*�������еĴ洢�ṹ����͸�����������ŵ�����*/

static int id = 0;

typedef int DataType;               /*�������Ԫ�ص��������ͣ�����Ϊint��*/
typedef struct Node                 /*���������еĽ��ṹ*/
{
	DataType data;
	struct Node *next;
} Node;
typedef struct                       /*����������*/
{
	Node *front, *rear;

} LinkQueue;
void InitQueue(LinkQueue *Q)
{
	Node *s = (Node *)malloc(sizeof(Node)); s->next = NULL;
	Q->front = Q->rear = s;            /*��ͷָ��Ͷ�βָ���ָ��ͷ���*/

}

void DestroyQueue(LinkQueue *Q)
{
	Node *p = Q->front, *ptrtemp;
	while (p != NULL)                     /*�����ͷ������еĽ��*/
	{
		ptrtemp = p->next;
		free(p);
		p = ptrtemp;
	}
}
void EnQueue(LinkQueue *Q, DataType x)
{
	Node *s = (Node *)malloc(sizeof(Node));
	s->data = x; s->next = NULL;        /*����һ��������Ϊx�Ľ��s*/
	Q->rear->next = s; Q->rear = s;       /*�����s���뵽��β*/
	id++;
}
int DeQueue(LinkQueue *Q, DataType *ptr)
{
	Node *p;
	if (Q->rear == Q->front) { printf("�������ɾ��ʧ��\n"); return 0; }
	p = Q->front->next; *ptr = p->data;        /*�洢��ͷԪ��*/
	Q->front->next = p->next;               /*����ͷԪ�����ڽ��ժ��*/
	if (p->next == NULL)                  /*�жϳ���ǰ���г����Ƿ�Ϊ1*/
		Q->rear = Q->front;
	free(p);

	return 1;
}
int GetHead(LinkQueue *Q, DataType *ptr)
{
	Node *p = NULL;
	if (Q->rear == Q->front) { printf("�������ȡ��ͷʧ��\n"); return 0; }
	p = Q->front->next;
	*ptr = p->data;
	return 1;
}
int Empty(LinkQueue *Q)
{
	if (Q->rear == Q->front) return 1;              /*����Ϊ�շ���1*/
	else return 0;
}

void PrintQueue(LinkQueue *Q)
{
	Node *p = Q->front->next;
	while (p != NULL)
	{
		printf("%d, ", p->data);
		p = p->next;
	}
	printf("\n");
}
int WaitNum(LinkQueue *Q)      //����е�Ԫ�ظ���
{
	Node *p = Q->front->next;
	int length = 0;
	while (p != NULL)                     /*�����ͷ������еĽ��*/
	{
		length++;
		p = p->next;
	}

	return length;

}

void getnumber(LinkQueue *Q)
{
	EnQueue(Q, id);
	if (id != 0)
	{
		printf("����id��%d��ǰ�滹��%d�����Ŷӣ�\n", id, WaitNum(Q) - 1);
	}
	else
	{
		printf("ȡ��ʧ�ܣ�\n");
	}


}

void callnumber(LinkQueue *Q)
{
	int x;
	GetHead(&Q, &x);
	if (x != 0)
	{
		printf("���%d�ſͻ������ڰ���,����%d�����Ŷӣ�\n", x, WaitNum(Q));
	}
	else
	{
		printf("��������û�пͻ���\n");
	}
}

//int main( )
//{
// DataType x;
//LinkQueue Q;                   /*����ṹ�����QΪ����������*/
// InitQueue(&Q);                  /*��ʼ��������Q*/
// printf("��5��8ִ����Ӳ�����");
//EnQueue(&Q, 5);
//EnQueue(&Q, 8);
//printf("\n");
//PrintQueue(&Q);

//if (GetHead(&Q, &x) == 1)
// printf("��ǰ��ͷԪ��Ϊ��%d\n", x);              /*�����ǰ��ͷԪ��5*/
//if (DeQueue(&Q, &x) == 1)
//  printf("ִ��һ�γ��Ӳ���������Ԫ���ǣ�%d\n", x);   /*�������Ԫ��5*/
//if (GetHead(&Q, &x) == 1)
//  printf("��ǰ��ͷԪ��Ϊ��%d\n", x);             /*�����ǰ��ͷԪ��8*/
// printf("���������Ԫ�أ�");
// scanf("%d", &x);
//EnQueue(&Q, 5);
// if (Empty(&Q) == 1)
// printf("����Ϊ��\n");
//else
// printf("���зǿ�\n");             /*������2��Ԫ�أ�������зǿ�*/
// DestroyQueue(&Q);
//return 0;
//}

int main()
{

	LinkQueue Q;       /*����ṹ�����QΪ����������*/
	InitQueue(&Q);          /*��ʼ��������Q*/
	printf("��1-4�ſͻ�ִ����Ӳ�����");
	for (int i = 1; i <= 4; i++)
	{
		EnQueue(&Q, i);
	}
	printf("\n");
	PrintQueue(&Q);
	printf("��ǰ��%d���ͻ�׼������ҵ��\n", WaitNum(&Q));

	int s;
	printf("1.���¿ͻ����ȡ��\n");
	printf("2.�д��ڿ��У��к�\n");
	printf("3.�˳�ϵͳ\n");
	while (1)
	{
		scanf("%d", &s);
		switch (s)
		{
		case 1: getnumber(&Q); break;
		case 2: callnumber(&Q); break;
		case 3: exit(0);
		}
	}

}

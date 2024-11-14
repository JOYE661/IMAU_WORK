#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
/*将链队列的存储结构定义和各个函数定义放到这里*/

static int id = 0;

typedef int DataType;               /*定义队列元素的数据类型，假设为int型*/
typedef struct Node                 /*定义链队列的结点结构*/
{
	DataType data;
	struct Node *next;
} Node;
typedef struct                       /*定义链队列*/
{
	Node *front, *rear;

} LinkQueue;
void InitQueue(LinkQueue *Q)
{
	Node *s = (Node *)malloc(sizeof(Node)); s->next = NULL;
	Q->front = Q->rear = s;            /*队头指针和队尾指针均指向头结点*/

}

void DestroyQueue(LinkQueue *Q)
{
	Node *p = Q->front, *ptrtemp;
	while (p != NULL)                     /*依次释放链队列的结点*/
	{
		ptrtemp = p->next;
		free(p);
		p = ptrtemp;
	}
}
void EnQueue(LinkQueue *Q, DataType x)
{
	Node *s = (Node *)malloc(sizeof(Node));
	s->data = x; s->next = NULL;        /*申请一个数据域为x的结点s*/
	Q->rear->next = s; Q->rear = s;       /*将结点s插入到队尾*/
	id++;
}
int DeQueue(LinkQueue *Q, DataType *ptr)
{
	Node *p;
	if (Q->rear == Q->front) { printf("下溢错误，删除失败\n"); return 0; }
	p = Q->front->next; *ptr = p->data;        /*存储队头元素*/
	Q->front->next = p->next;               /*将队头元素所在结点摘链*/
	if (p->next == NULL)                  /*判断出队前队列长度是否为1*/
		Q->rear = Q->front;
	free(p);

	return 1;
}
int GetHead(LinkQueue *Q, DataType *ptr)
{
	Node *p = NULL;
	if (Q->rear == Q->front) { printf("下溢错误，取队头失败\n"); return 0; }
	p = Q->front->next;
	*ptr = p->data;
	return 1;
}
int Empty(LinkQueue *Q)
{
	if (Q->rear == Q->front) return 1;              /*队列为空返回1*/
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
int WaitNum(LinkQueue *Q)      //求对列的元素个数
{
	Node *p = Q->front->next;
	int length = 0;
	while (p != NULL)                     /*依次释放链队列的结点*/
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
		printf("您的id是%d，前面还有%d人在排队！\n", id, WaitNum(Q) - 1);
	}
	else
	{
		printf("取号失败！\n");
	}


}

void callnumber(LinkQueue *Q)
{
	int x;
	GetHead(&Q, &x);
	if (x != 0)
	{
		printf("请第%d号客户到窗口办理,还有%d人在排队！\n", x, WaitNum(Q));
	}
	else
	{
		printf("队列中已没有客户！\n");
	}
}

//int main( )
//{
// DataType x;
//LinkQueue Q;                   /*定义结构体变量Q为链队列类型*/
// InitQueue(&Q);                  /*初始化链队列Q*/
// printf("对5和8执行入队操作，");
//EnQueue(&Q, 5);
//EnQueue(&Q, 8);
//printf("\n");
//PrintQueue(&Q);

//if (GetHead(&Q, &x) == 1)
// printf("当前队头元素为：%d\n", x);              /*输出当前队头元素5*/
//if (DeQueue(&Q, &x) == 1)
//  printf("执行一次出队操作，出队元素是：%d\n", x);   /*输出出队元素5*/
//if (GetHead(&Q, &x) == 1)
//  printf("当前队头元素为：%d\n", x);             /*输出当前队头元素8*/
// printf("请输入入队元素：");
// scanf("%d", &x);
//EnQueue(&Q, 5);
// if (Empty(&Q) == 1)
// printf("队列为空\n");
//else
// printf("队列非空\n");             /*队列有2个元素，输出队列非空*/
// DestroyQueue(&Q);
//return 0;
//}

int main()
{

	LinkQueue Q;       /*定义结构体变量Q为链队列类型*/
	InitQueue(&Q);          /*初始化链队列Q*/
	printf("对1-4号客户执行入队操作，");
	for (int i = 1; i <= 4; i++)
	{
		EnQueue(&Q, i);
	}
	printf("\n");
	PrintQueue(&Q);
	printf("当前有%d名客户准备办理业务\n", WaitNum(&Q));

	int s;
	printf("1.有新客户到达，取号\n");
	printf("2.有窗口空闲，叫号\n");
	printf("3.退出系统\n");
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

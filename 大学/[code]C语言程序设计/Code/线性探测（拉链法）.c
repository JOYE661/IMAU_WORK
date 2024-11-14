#include<stdio.h>
#include<stdlib.h>
typedef int DataType;          /*定义线性表的数据类型，假设为int型*/
typedef struct Node            /*定义单链表的结点类型*/
{
	DataType data;
	struct Node *next;
} Node;
int HashSearch2(Node *ht[], int m, int k, Node *pos);
void HashDelete2(Node *ht[], int m, int k);
void Print(Node *ht[],int m);
int H(int k);


int main()
{
	int k, i;
	Node index;
	int r[] = { 47, 7, 29, 11, 16, 92, 22, 8, 3 };
	Node *ht[11] = { NULL };
	for (i = 0; i < 9; i++)
	{
		HashSearch2(ht, 11, r[i], &index);
		printf("元素%d的存储地址是%X\n", r[i], index);
	}
	Print(ht,11);
	printf("输入要删除的元素：");
	scanf("%d", &k);
	HashDelete2(ht, 11, k);
	Print(ht,11);
	getchar(); getchar();
	return 0;
}
int HashSearch2(Node *ht[], int m, int k, Node *pos)
{
	int j = H(k);                       /*计算散列地址*/
	Node *p = ht[j], *q;                 /*工作指针p初始化为ht[j]的表头*/
	while ((p != NULL) && (p->data != k))
		p = p->next;
	if (p != NULL && p->data == k) {
		pos = p; return 1;                      /*查找成功*/
	}
	else {                                 /*查找失败，则插入*/
		q = (Node *)malloc(sizeof(Node)); q->data = k;
		q->next = ht[j]; ht[j] = q;                /*插在ht[j]的表头*/
		pos = q; return 0;
	}
}
void HashDelete2(Node *ht[], int m, int k)
{
	int j = H(k);                        /*计算散列地址*/
	Node *p = NULL, *pre = NULL;       /*设置两个工作指针pre和p*/
	if (ht[j]->data == k) {                /*处理表头的特殊情况*/
		p = ht[j]; ht[j] = p->next; free(p);
		return;
	}
	pre = ht[j]; p = pre->next;             /*工作指针初始化*/
	while ((p != NULL) && (p->data != k))
	{
		pre = p; p = p->next;
	}
	if (p->data == k) {                  /*查找成功，执行删除操作*/
		pre->next = p->next; free(p);
	}
}

int H(int k)
{
	return k % 11;
}

void Print(Node *ht[],int m)
{
	int i;
	for (i = 0; i < m; i++)
	{

		Node *p = ht[i];
		printf("下标%d的元素是： ", i);
		if (p == NULL) printf("没有\n");
		else {
			while (p != NULL)
			{
				printf("%d ", p->data);
				p = p->next;
			}
			printf("\n");
		}
	}
}

#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <malloc.h>

typedef struct Node
{
	int data;
	struct Node *next;
} Node;

Node *Creat(int n);
void Joseph(Node *rear, int a[]);

int main()
{
	int n, m;
	Node *rear = NULL;
	printf("������Լɪ�򻷵ĳ��ȣ�");
	scanf("%d", &n);
	int a[n + 1];
	printf("���������룺");
	scanf("%d", &m);
	a[0] = m;
	printf("��������˵����룺");
	for (int i = 1; i<n + 1; i++){
		scanf("%d", &a[i]);
	}
	rear = Creat(n);
	Joseph(rear, a);
	return 0;
}

Node *Creat(int n)
{
	Node *rear = NULL, *s;
	int i;
	rear = (Node *)malloc(sizeof(Node));
	rear->data = 1;
	rear->next = rear;
	for (i = 2; i <= n; i++)
	{
		s = (Node *)malloc(sizeof(Node));
		s->data = i;
		s->next = rear->next;
		rear->next = s;
		rear = s;
	}
	return rear;
}
void Joseph(Node *rear, int a[])
{
	Node *pre = rear, *p = rear->next;
	int count = 1;
	printf("������˳���ǣ�");
	int flog = 0;
	while (p->next != p)
	{
		if (count < a[flog]) {
			pre = p; p = p->next;
			count++;
		}
		else {
			printf("%-3d", p->data);
			flog = p->data;
			pre->next = p->next;
			free(p);
			p = pre->next;
			count = 1;
		}
	}
	printf("%-3d\n", p->data);
	free(p);
}




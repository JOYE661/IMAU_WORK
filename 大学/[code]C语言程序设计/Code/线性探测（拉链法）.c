#include<stdio.h>
#include<stdlib.h>
typedef int DataType;          /*�������Ա���������ͣ�����Ϊint��*/
typedef struct Node            /*���嵥����Ľ������*/
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
		printf("Ԫ��%d�Ĵ洢��ַ��%X\n", r[i], index);
	}
	Print(ht,11);
	printf("����Ҫɾ����Ԫ�أ�");
	scanf("%d", &k);
	HashDelete2(ht, 11, k);
	Print(ht,11);
	getchar(); getchar();
	return 0;
}
int HashSearch2(Node *ht[], int m, int k, Node *pos)
{
	int j = H(k);                       /*����ɢ�е�ַ*/
	Node *p = ht[j], *q;                 /*����ָ��p��ʼ��Ϊht[j]�ı�ͷ*/
	while ((p != NULL) && (p->data != k))
		p = p->next;
	if (p != NULL && p->data == k) {
		pos = p; return 1;                      /*���ҳɹ�*/
	}
	else {                                 /*����ʧ�ܣ������*/
		q = (Node *)malloc(sizeof(Node)); q->data = k;
		q->next = ht[j]; ht[j] = q;                /*����ht[j]�ı�ͷ*/
		pos = q; return 0;
	}
}
void HashDelete2(Node *ht[], int m, int k)
{
	int j = H(k);                        /*����ɢ�е�ַ*/
	Node *p = NULL, *pre = NULL;       /*������������ָ��pre��p*/
	if (ht[j]->data == k) {                /*�����ͷ���������*/
		p = ht[j]; ht[j] = p->next; free(p);
		return;
	}
	pre = ht[j]; p = pre->next;             /*����ָ���ʼ��*/
	while ((p != NULL) && (p->data != k))
	{
		pre = p; p = p->next;
	}
	if (p->data == k) {                  /*���ҳɹ���ִ��ɾ������*/
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
		printf("�±�%d��Ԫ���ǣ� ", i);
		if (p == NULL) printf("û��\n");
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

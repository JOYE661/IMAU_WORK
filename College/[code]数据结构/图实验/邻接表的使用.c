#include <stdio.h>
#include<malloc.h>
/*���ڽӱ�Ĵ洢�ṹ����͸�����������ŵ�����*/
#define MaxSize 10                 /*ͼ����󶥵���*/
int visited[MaxSize] = { 0 };
typedef char DataType;              /*����ͼ�ж�����������ͣ�����Ϊchar��*/
typedef struct EdgeNode              /*����߱���*/
{
	int adjvex;
	struct EdgeNode *next;
} EdgeNode;
typedef struct                      /*���嶥�����*/
{
	DataType vertex;
	EdgeNode *first;
} VertexNode;
typedef struct                      /*�����ڽӱ�洢�ṹ*/
{
	VertexNode adjlist[MaxSize];      /*��Ŷ���������*/
	int vertexNum, edgeNum;         /*ͼ�Ķ������ͱ���*/
} ALGraph;
void CreatGraph(ALGraph *G, DataType a[], int n, int e)
{
	int i, j, k;
	EdgeNode *s = NULL;
	G->vertexNum = n; G->edgeNum = e;
	for (i = 0; i < G->vertexNum; i++)
	{
		G->adjlist[i].vertex = a[i];          /*�洢������Ϣ*/
		G->adjlist[i].first = NULL;         /*��ʼ���߱��ͷָ��*/
	}
	for (k = 0; k < G->edgeNum; k++)
	{
		printf("������������Ķ�����:\n");
		scanf("%d%d", &i, &j);           /*������������Ķ�����*/
		s = (EdgeNode *)malloc(sizeof(EdgeNode));
		s->adjvex = j;
		s->next = G->adjlist[i].first;        /*��s���뵽��i���߱�ı�ͷ*/
		G->adjlist[i].first = s;
	}
}
void DFTraverse(ALGraph *G, int v)
{
	EdgeNode *p = NULL;
	int j;
	printf("%c ", G->adjlist[v].vertex);  visited[v] = 1;
	p = G->adjlist[v].first;             /*����ָ��pָ�򶥵�v�ı߱�*/
	while (p != NULL)                /*������������v���ڽӵ�j*/
	{
		j = p->adjvex;
		if (visited[j] == 0) DFTraverse(G, j);
		p = p->next;
	}
}
void BFTraverse(ALGraph *G, int v)
{
	EdgeNode *p = NULL;
	int Q[MaxSize], front =-1, rear = -1, j;      /*���в���˳��洢*/
	printf("%c ", G->adjlist[v].vertex); visited[v] = 1; Q[++rear] = v;
	while (front != rear)                   /*�����зǿ�ʱ*/
	{
		v = Q[++front];
		p = G->adjlist[v].first;              /*����ָ��pָ�򶥵�v�ı߱�*/
		while (p != NULL)
		{
			j = p->adjvex;                 /* jΪ����v���ڽӵ�*/
			if (visited[j] == 0) {
				printf("%c ", G->adjlist[j].vertex); visited[j] = 1; Q[++rear] = j;
			}
			p = p->next;
		}
	}
}
void DestroyGraph(ALGraph *G)
{
	int i;
	EdgeNode *p = NULL, *q = NULL;
	for (i = 0; i < G->vertexNum; i++)
	{
		p = q = G->adjlist[i].first;
		while (p != NULL)
		{
			p = p->next;
			free(q); q = p;
		}
	}
}

int main()
{
	char ch[] = { 'A', 'B', 'C', 'D', 'E' };
	int i;
	ALGraph ALG;
		CreatGraph(&ALG, ch, 5, 6);        /*��������5������6���ߵ�����ͼ*/
	for (i = 0; i < MaxSize; i++)
		visited[i] = 0;
	printf("������ȱ��������ǣ�");
	DFTraverse(&ALG, 0);           /*�Ӷ���0��������������ȱ���*/
	for (i = 0; i < MaxSize; i++)
		visited[i] = 0;
	printf("������ȱ��������ǣ�");
	BFTraverse(&ALG, 0);           /*�Ӷ���0�������й�����ȱ���*/
	DestroyGraph(&ALG);
	getchar();
	getchar();
	return 0;
}

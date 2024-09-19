#include <stdio.h>
#include<malloc.h>
/*把邻接表的存储结构定义和各个函数定义放到这里*/
#define MaxSize 10                 /*图的最大顶点数*/
int visited[MaxSize] = { 0 };
typedef char DataType;              /*定义图中顶点的数据类型，假设为char型*/
typedef struct EdgeNode              /*定义边表结点*/
{
	int adjvex;
	struct EdgeNode *next;
} EdgeNode;
typedef struct                      /*定义顶点表结点*/
{
	DataType vertex;
	EdgeNode *first;
} VertexNode;
typedef struct                      /*定义邻接表存储结构*/
{
	VertexNode adjlist[MaxSize];      /*存放顶点表的数组*/
	int vertexNum, edgeNum;         /*图的顶点数和边数*/
} ALGraph;
void CreatGraph(ALGraph *G, DataType a[], int n, int e)
{
	int i, j, k;
	EdgeNode *s = NULL;
	G->vertexNum = n; G->edgeNum = e;
	for (i = 0; i < G->vertexNum; i++)
	{
		G->adjlist[i].vertex = a[i];          /*存储顶点信息*/
		G->adjlist[i].first = NULL;         /*初始化边表的头指针*/
	}
	for (k = 0; k < G->edgeNum; k++)
	{
		printf("输入边所依附的顶点编号:\n");
		scanf("%d%d", &i, &j);           /*输入边所依附的顶点编号*/
		s = (EdgeNode *)malloc(sizeof(EdgeNode));
		s->adjvex = j;
		s->next = G->adjlist[i].first;        /*将s插入到第i个边表的表头*/
		G->adjlist[i].first = s;
	}
}
void DFTraverse(ALGraph *G, int v)
{
	EdgeNode *p = NULL;
	int j;
	printf("%c ", G->adjlist[v].vertex);  visited[v] = 1;
	p = G->adjlist[v].first;             /*工作指针p指向顶点v的边表*/
	while (p != NULL)                /*依次搜索顶点v的邻接点j*/
	{
		j = p->adjvex;
		if (visited[j] == 0) DFTraverse(G, j);
		p = p->next;
	}
}
void BFTraverse(ALGraph *G, int v)
{
	EdgeNode *p = NULL;
	int Q[MaxSize], front =-1, rear = -1, j;      /*队列采用顺序存储*/
	printf("%c ", G->adjlist[v].vertex); visited[v] = 1; Q[++rear] = v;
	while (front != rear)                   /*当队列非空时*/
	{
		v = Q[++front];
		p = G->adjlist[v].first;              /*工作指针p指向顶点v的边表*/
		while (p != NULL)
		{
			j = p->adjvex;                 /* j为顶点v的邻接点*/
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
		CreatGraph(&ALG, ch, 5, 6);        /*建立具有5个顶点6条边的有向图*/
	for (i = 0; i < MaxSize; i++)
		visited[i] = 0;
	printf("深度优先遍历序列是：");
	DFTraverse(&ALG, 0);           /*从顶点0出发进行深度优先遍历*/
	for (i = 0; i < MaxSize; i++)
		visited[i] = 0;
	printf("广度优先遍历序列是：");
	BFTraverse(&ALG, 0);           /*从顶点0出发进行广度优先遍历*/
	DestroyGraph(&ALG);
	getchar();
	getchar();
	return 0;
}

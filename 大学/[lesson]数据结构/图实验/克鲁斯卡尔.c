#include<stdio.h>
#include<stdlib.h>
#define MaxVertex 10                /*图中最多顶点数*/
#define MaxEdge 100                /*图中最多边数*/
typedef char DataType;               /*定义顶点的数据类型，假设为char型*/
typedef struct                       /*定义边集数组的元素类型*/
{
	int from, to;
	int weight;                       /*假设权值为整数*/
} EdgeType;
typedef struct                       /*定义边集数组存储结构*/
{
	DataType vertex[MaxVertex];
	EdgeType edge[MaxEdge];
	int vertexNum, edgeNum;
} EdgeGraph;
void Kruskal(EdgeGraph *G);
int FindRoot(int parent[], int v);
void sort(EdgeGraph *G);
void InitGraph(EdgeGraph *G);
int main()
{
	EdgeGraph G;
	InitGraph(&G);
	sort(&G);
	printf("最小生成树为：\n");
	Kruskal(&G);
	getchar(); getchar();
	return 0;
}
void InitGraph(EdgeGraph *G)
{
	int i;
	G->edge[MaxEdge];
	//G->edge[MaxEdge] = {0};
	G->vertex[MaxVertex] ;
	printf("请输入顶点的个数：\n");
	scanf("%d", &G->vertexNum);
	printf("请输入顶点：\n");
	for (i = 0; i < G->vertexNum; i++)
	{
		scanf("%c", &G->vertex[i]);
	}
	printf("请输入边的条数：\n");
	fflush(stdin);
	scanf("%d", &G->edgeNum);
	printf("请输入两个顶点及权重：\n");
	for (i = 0; i < G->edgeNum; i++)
	{
		scanf("%d%d%d", &G->edge[i].from, &G->edge[i].to, &G->edge[i].weight);
	}
}
void sort(EdgeGraph *G)
{
	int i, j, tempfrom, tempto, tempweight;
	for (i = 0; i < G->edgeNum; i++)
	{
		for (j = i; j < G->edgeNum; j++)
		{
			if (G->edge[i].weight>G->edge[j].weight)
			{
				tempfrom = G->edge[i].from; tempto = G->edge[i].to; tempweight = G->edge[i].weight;
				G->edge[i].from = G->edge[j].from; G->edge[i].to = G->edge[j].to; G->edge[i].weight = G->edge[j].weight;
				G->edge[j].from = tempfrom; G->edge[j].to = tempto; G->edge[j].weight = tempweight;
			}
		}
	}
}
void Kruskal(EdgeGraph *G)
{
	int num = 0, vex1, vex2, i;
	int parent[MaxVertex];// = { -1, -1, -1, -1, -1, -1 };           /*初始化n个只有根结点的集合*/
	for (i = 0; i < G->vertexNum; i++)
		parent[i] = -1;
	for (num = 0, i = 0; i < G->vertexNum; i++)    /*依次考察最短边*/
	{
		vex1 = FindRoot(parent, G->edge[i].from);
		vex2 = FindRoot(parent, G->edge[i].to);
		if (vex1 != vex2) {                         /*位于不同的集合*/
			printf("(%d, %d)%d ", G->edge[i].from, G->edge[i].to, G->edge[i].weight);
			parent[vex2] = vex1;                      /*合并集合*/
			num++;
		}
	}
}

int FindRoot(int parent[], int v)           /*求顶点v所在集合的根*/
{
	int t = 0;
	t=v;
	while (parent[t] > -1)                 /*求顶点t的双亲一直到根*/
		t = parent[t];
	return t;
}


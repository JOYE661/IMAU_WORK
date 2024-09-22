#include<stdio.h>
#include<stdlib.h>
#define MaxVertex 10                /*ͼ����ඥ����*/
#define MaxEdge 100                /*ͼ��������*/
typedef char DataType;               /*���嶥����������ͣ�����Ϊchar��*/
typedef struct                       /*����߼������Ԫ������*/
{
	int from, to;
	int weight;                       /*����ȨֵΪ����*/
} EdgeType;
typedef struct                       /*����߼�����洢�ṹ*/
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
	printf("��С������Ϊ��\n");
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
	printf("�����붥��ĸ�����\n");
	scanf("%d", &G->vertexNum);
	printf("�����붥�㣺\n");
	for (i = 0; i < G->vertexNum; i++)
	{
		scanf("%c", &G->vertex[i]);
	}
	printf("������ߵ�������\n");
	fflush(stdin);
	scanf("%d", &G->edgeNum);
	printf("�������������㼰Ȩ�أ�\n");
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
	int parent[MaxVertex];// = { -1, -1, -1, -1, -1, -1 };           /*��ʼ��n��ֻ�и����ļ���*/
	for (i = 0; i < G->vertexNum; i++)
		parent[i] = -1;
	for (num = 0, i = 0; i < G->vertexNum; i++)    /*���ο�����̱�*/
	{
		vex1 = FindRoot(parent, G->edge[i].from);
		vex2 = FindRoot(parent, G->edge[i].to);
		if (vex1 != vex2) {                         /*λ�ڲ�ͬ�ļ���*/
			printf("(%d, %d)%d ", G->edge[i].from, G->edge[i].to, G->edge[i].weight);
			parent[vex2] = vex1;                      /*�ϲ�����*/
			num++;
		}
	}
}

int FindRoot(int parent[], int v)           /*�󶥵�v���ڼ��ϵĸ�*/
{
	int t = 0;
	t=v;
	while (parent[t] > -1)                 /*�󶥵�t��˫��һֱ����*/
		t = parent[t];
	return t;
}


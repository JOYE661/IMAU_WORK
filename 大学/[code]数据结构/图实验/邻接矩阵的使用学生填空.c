
#include <stdio.h>
#include <stdlib.h>
#define MaxSize 10      /*����ͼ����ඥ�����*/
int visited[MaxSize]={0};     /*ȫ���������visited��ʼ��*/
/*���ڽӾ���Ĵ洢�ṹ����͸�����������ŵ�����*/

typedef char DataType;                /*ͼ�ж�����������ͣ�����Ϊchar��*/
typedef struct                        /*�����ڽӾ���洢�ṹ*/
{
  DataType vertex[MaxSize];           /*��Ŷ����һά����*/
  int edge[MaxSize][MaxSize];          /*��űߵĶ�ά����*/
  int vertexNum, edgeNum;             /*ͼ�Ķ������ͱ���*/
} MGraph;

void CreatGraph(MGraph *G, DataType a[ ], int n, int e)
{
   int i, j, k;
   G->vertexNum = n; G->edgeNum = e;
   for (i = 0; i < G->vertexNum; i++)         /*�洢������Ϣ*/
   G->vertex[i] = a[i];
   for (i = 0; i < G->vertexNum; i++)         /*��ʼ���ڽӾ���*/
     for (j = 0; j < G->vertexNum; j++)
       G->edge[i][j] = 0;
   for (k = 0; k < G->edgeNum; k++)         /*��������ÿһ����*/
   {
      printf("����������Ķ�����:");
      scanf("%d%d", &i, &j);                /*����������Ķ�����*/
      G->edge[i][j] = 1;      /*���б߱�־ */
   }
}
void DFTraverse(MGraph *G, int v)  /*ȫ���������visited[n]�ѳ�ʼ��Ϊ0*/
{
    int j;
    printf("%c ", G->vertex[v]);
    visited[v] = 1;
    for (j = 0; j < G->vertexNum; j++)
      if (G->edge[v][j] == 1 && visited[j] == 0)
         DFTraverse(G, j);
  }
void BFTraverse(MGraph *G, int v)  /*ȫ���������visited[n]�ѳ�ʼ��Ϊ0*/
{
   int i, j, Q[MaxSize];                /*����˳����У��洢������*/
   int front =-1;
   int rear = -1;                /*��ʼ��˳�����*/
   printf("%c ", G->vertex[v]); visited[v] = 1;  Q[++rear] = v;
   while (front != rear)                              /*�����зǿ�ʱ*/
   {
     i = Q[++front];                 /*����ͷԪ�س��Ӳ��͵�v��*/
     for (j = 0; j < G->vertexNum; j++)
        if (G->edge[i][j] == 1 && visited[j] == 0 ) {
          printf("%c ", G->vertex[j]); visited[j] = 1; Q[++rear] = j;
    }
   }
}


void Degree(MGraph *G)
{
	int ind, outd, du,i,j;
	for (i=0;i<G->vertexNum;i++)
	{
		   //���
		 //����
		for(j=0;j<G->vertexNum;j++)
		{
			//
			//
		}

		//
		printf("\nVertex:%c indegree:%d, outdegree:%d ,Degree:%d\n",G->vertex[i],ind,outd,du);
	}
}



int main( )
{
    int i;
    char ch[ ]={'A','B','C','D','E'};
    MGraph MG;
    printf("Now create the graph...\n");
    CreatGraph(&MG, ch, 5, 7);            /*��������5������7���ߵ�����ͼ*/
    Degree(&MG);
    for (i = 0; i < MaxSize; i++)
       visited[i] = 0;
    printf("\n������ȱ��������ǣ�");
    DFTraverse(&MG, 0);                /*�Ӷ���0��������������ȱ���*/
    for (i = 0; i < MaxSize; i++)
	visited[i] = 0;
    printf("\n������ȱ��������ǣ�");      /*�Ӷ���0�������й�����ȱ���*/
    BFTraverse(&MG, 0);
    return 0;
}


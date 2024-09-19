
#include <stdio.h>
#include <stdlib.h>
#define MaxSize 10      /*假设图中最多顶点个数*/
int visited[MaxSize]={0};     /*全局数组变量visited初始化*/
/*把邻接矩阵的存储结构定义和各个函数定义放到这里*/

typedef char DataType;                /*图中顶点的数据类型，假设为char型*/
typedef struct                        /*定义邻接矩阵存储结构*/
{
  DataType vertex[MaxSize];           /*存放顶点的一维数组*/
  int edge[MaxSize][MaxSize];          /*存放边的二维数组*/
  int vertexNum, edgeNum;             /*图的顶点数和边数*/
} MGraph;

void CreatGraph(MGraph *G, DataType a[ ], int n, int e)
{
   int i, j, k;
   G->vertexNum = n; G->edgeNum = e;
   for (i = 0; i < G->vertexNum; i++)         /*存储顶点信息*/
   G->vertex[i] = a[i];
   for (i = 0; i < G->vertexNum; i++)         /*初始化邻接矩阵*/
     for (j = 0; j < G->vertexNum; j++)
       G->edge[i][j] = 0;
   for (k = 0; k < G->edgeNum; k++)         /*依次输入每一条边*/
   {
      printf("输入边依附的顶点编号:");
      scanf("%d%d", &i, &j);                /*输入边依附的顶点编号*/
      G->edge[i][j] = 1;      /*置有边标志 */
   }
}
void DFTraverse(MGraph *G, int v)  /*全局数组变量visited[n]已初始化为0*/
{
    int j;
    printf("%c ", G->vertex[v]);
    visited[v] = 1;
    for (j = 0; j < G->vertexNum; j++)
      if (G->edge[v][j] == 1 && visited[j] == 0)
         DFTraverse(G, j);
  }
void BFTraverse(MGraph *G, int v)  /*全局数组变量visited[n]已初始化为0*/
{
   int i, j, Q[MaxSize];                /*采用顺序队列，存储顶点编号*/
   int front =-1;
   int rear = -1;                /*初始化顺序队列*/
   printf("%c ", G->vertex[v]); visited[v] = 1;  Q[++rear] = v;
   while (front != rear)                              /*当队列非空时*/
   {
     i = Q[++front];                 /*将队头元素出队并送到v中*/
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
		   //入度
		 //出度
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
    CreatGraph(&MG, ch, 5, 7);            /*建立具有5个顶点7条边的无向图*/
    Degree(&MG);
    for (i = 0; i < MaxSize; i++)
       visited[i] = 0;
    printf("\n深度优先遍历序列是：");
    DFTraverse(&MG, 0);                /*从顶点0出发进行深度优先遍历*/
    for (i = 0; i < MaxSize; i++)
	visited[i] = 0;
    printf("\n广度优先遍历序列是：");      /*从顶点0出发进行广度优先遍历*/
    BFTraverse(&MG, 0);
    return 0;
}


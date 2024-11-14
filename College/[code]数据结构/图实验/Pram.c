#include<stdio.h>
#include<stdlib.h>
#define MaxSize 10                   /*假设图中最多顶点个数*/
typedef char DataType;                /*图中顶点的数据类型，假设为char型*/
typedef struct                        /*定义邻接矩阵存储结构*/
{
  DataType vertex[MaxSize];           /*存放顶点的一维数组*/
  int edge[MaxSize][MaxSize];          /*存放边的二维数组*/
  int vertexNum, edgeNum;             /*图的顶点数和边数*/
} MGraph;

void Prim(MGraph *G, int v)               /*假设从顶点v出发*/
{   
	int i, j, k;
	int adjvex[MaxSize], lowcost[MaxSize];
    for (i = 0; i < G->vertexNum; i++)         /*初始化辅助数组shortEdge*/
	{
		lowcost[i] = G->edge[v][i]; 
		adjvex[i] = v;
	}
	lowcost[v] = 0;                         /*将顶点v加入集合U*/
	for (k = 0; k < G->vertexNum; k++)         /*迭代n-1次*/
	{
	
		j = MinEdge(lowcost, G->vertexNum);    /*寻找最短边的邻接点j*/
        
		  printf("(%d, %d)%d ",adjvex[j] ,j , lowcost[j]); 
      	lowcost[j] = 0;                        /*将顶点j加入集合U*/
      	for (i = 0; i < G->vertexNum; i++)        /*调整数组shortEdge[n]*/
        	if (G->edge[i][j] < lowcost[i]) 
			{
				lowcost[i] = G->edge[i][j]; 
				adjvex[i] = j;
        	}
    }
  }
  int MinEdge( int lowcost[MaxSize], int vertexNum)
  {
		int min = 10000 ;
  		int temp = 0, k;
  		for(k = 0 ; k <vertexNum; k++)
  		{
  			if(lowcost[k] < min && lowcost[k] !=0)
			{
				min = lowcost[k];
				temp = k;
			}
	 	 }
	 	 return temp;
  }
  void CreatGraph(MGraph *G)
  {
  	int i, j, k, w;
  	int a[MaxSize][MaxSize] = {0};
  	printf("请输入树的顶点的个数:");
  	scanf("%d", &G->vertexNum);
  	printf("请输入树的顶点:");
  	for(i = 0; i < G->vertexNum; i++)
  		scanf("%c", &G->vertex[i]);
  	printf("请输入树的边的条数:");
  	fflush(stdin);
  	scanf("%d", &G->edgeNum);
  	 printf("请输入边的权值是:");  
   	for(i = 0; i<G->vertexNum; i++)
  		for(j = 0; j<G->vertexNum; j++) 
   	   	{
			scanf("%d%d%d", &i, &j, &w);
	        G->edge[i][j]= w; 
	   }
  }
  void JuZhen(MGraph *G)
  {
  	int i ,j ;
  	for(i = 0; i<G->vertexNum; i++){
  		for(j = 0; j<G->vertexNum; j++)
  		printf("%d\t",G->edge[i][j]);
  		printf("\n");	
	  }
  		
  }
  int main()
  {
  	int i,j;
  	MGraph  G;
  	CreatGraph(&G);
  	printf("矩阵是:\n");
  	JuZhen(&G);
  	printf("\n最小生成树是:");
  	Prim(&G,0);
  	return 0;
  }


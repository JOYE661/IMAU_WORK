#include<stdio.h>
#include<stdlib.h>
#define MaxSize 10                   /*����ͼ����ඥ�����*/
typedef char DataType;                /*ͼ�ж�����������ͣ�����Ϊchar��*/
typedef struct                        /*�����ڽӾ���洢�ṹ*/
{
  DataType vertex[MaxSize];           /*��Ŷ����һά����*/
  int edge[MaxSize][MaxSize];          /*��űߵĶ�ά����*/
  int vertexNum, edgeNum;             /*ͼ�Ķ������ͱ���*/
} MGraph;

void Prim(MGraph *G, int v)               /*����Ӷ���v����*/
{   
	int i, j, k;
	int adjvex[MaxSize], lowcost[MaxSize];
    for (i = 0; i < G->vertexNum; i++)         /*��ʼ����������shortEdge*/
	{
		lowcost[i] = G->edge[v][i]; 
		adjvex[i] = v;
	}
	lowcost[v] = 0;                         /*������v���뼯��U*/
	for (k = 0; k < G->vertexNum; k++)         /*����n-1��*/
	{
	
		j = MinEdge(lowcost, G->vertexNum);    /*Ѱ����̱ߵ��ڽӵ�j*/
        
		  printf("(%d, %d)%d ",adjvex[j] ,j , lowcost[j]); 
      	lowcost[j] = 0;                        /*������j���뼯��U*/
      	for (i = 0; i < G->vertexNum; i++)        /*��������shortEdge[n]*/
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
  	printf("���������Ķ���ĸ���:");
  	scanf("%d", &G->vertexNum);
  	printf("���������Ķ���:");
  	for(i = 0; i < G->vertexNum; i++)
  		scanf("%c", &G->vertex[i]);
  	printf("���������ıߵ�����:");
  	fflush(stdin);
  	scanf("%d", &G->edgeNum);
  	 printf("������ߵ�Ȩֵ��:");  
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
  	printf("������:\n");
  	JuZhen(&G);
  	printf("\n��С��������:");
  	Prim(&G,0);
  	return 0;
  }


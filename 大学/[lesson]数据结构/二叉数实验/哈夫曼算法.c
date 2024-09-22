#include <stdio.h>           
#define n 5                           /*�����ַ�������5���ַ�*/
typedef struct                         /*������������Ľ��ṹ*/
{
  int weight;                         /*�ٶ�ȨֵΪ����*/
  int parent, lchild, rchild;
} ElemType;
char ch[n] = {'A', 'B', 'C', 'D', 'E'};         /*�����ַ���*/
int w[n] = {35, 25, 15, 15, 10};           /*ÿ���ַ����ֵ�Ƶ��*/
void HuffmanTree(ElemType huffTree[ ]);              /*��������������������*/
void Select(ElemType huffTree[ ], int k, int *i1, int *i2);   /*��������Сֵ*/
void HuffmanCode(ElemType huffTree[ ]);               /*�����������*/
                                               
int main( )
{
	ElemType huffTree[2 * n - 1];        /*����huffTree�洢��������*/
	HuffmanTree(huffTree);           /*���ú���HuffmanTree���������*/
	HuffmanCode(huffTree);          /*���ú���HuffmanCode�����������*/
	return 0;                    
}
                                    
void HuffmanTree(ElemType huffTree[ ]) 
{         /*������������β�������huffTree[2 * n - 1]������n�Ƿ��ų���*/
    int i, k, i1, i2;           
	for (i = 0; i < 2 * n - 1; i++)       /*��ʼ�������н���û��˫�׺ͺ���*/
     {
		 huffTree[i].parent = -1;
		 huffTree[i].lchild = -1;
		 huffTree[i].rchild = -1;
     }
	 for (i = 0; i < n; i++)         /*��ʼ��������n��ֻ���и����Ķ�����*/
		 huffTree[i].weight = w[i];
	 for (k = n; k < 2 * n - 1; k++)        /*����n-1�κϲ�*/
	 {      
		 Select(huffTree, k, &i1, &i2);  /*����Ȩֵ��С����������㣬�±�Ϊi1��i2*/
		 huffTree[k].weight = huffTree[i1].weight + huffTree[i2].weight;
		 huffTree[i1].parent = k; huffTree[i2].parent = k; 
		 huffTree[k].lchild = i1; huffTree[k].rchild = i2;
	}
}
void Select(ElemType huffTree[ ], int k, int *i1, int *i2)
{                       /*����Ȩֵ��С����������㣬�β�i1��i2Ϊ������*/
	int min1 = 100;
	int min2 = 100;
	int i;                  /*��ʼ��������Ƶ�ʾ�С��100*/
	for (i = 0; i < k; i++)                  /*����Ȩֵ��С�����������*/
	{
		if (huffTree[i].parent == -1) {                  /*���i�Ǹ����*/
			if (huffTree[i].weight < min1) {            /*С����Сֵ*/
				min2 = min1; *i2 = *i1; 
min1 = huffTree[i].weight; *i1 = i;
			}
			else if (huffTree[i].weight < min2) {        /*С�ڴ���Сֵ*/
                	min2 = huffTree[i].weight; *i2 = i;
               }
		}
	}	
}
void HuffmanCode(ElemType huffTree[ ])     /*�����������*/
{         
	int i, j, k;
	int S[n], top = -1;                     /*˳��ջS�����õĹ���������*/
	for (i = 0; i < n; i++)                   /*��ÿһ��Ҷ�ӽ��Ĺ���������*/
	{
		printf("�ַ�%c�ı����ǣ�", ch[i]);
		k = i;                   
		while (huffTree[k].parent != -1)      /*����k��˫�ף�ֱ�������*/
		{
			j = huffTree[k].parent;          /* jΪ���k��˫��*/
			if (huffTree[j].lchild == k)
				S[++top] = 0;             /*���֧����Ϊ0*/
			else
				S[++top] = 1;             /*�ҷ�֧����Ϊ1*/
			k = j;
		}
		while (top != -1)                  /*�������ջS�еı���*/
			printf("%d", S[top--]);
		printf("\n");
	}
}


#include <stdio.h>
#define N 8                           /*�����ַ�������8���ַ�*/
 /*������������Ľ��ṹ
 ���ṹ���˵��
 ���������Ĺ�����Ҷ�ӽ�㿪ʼ���ϵع����µĸ�������Խ����Ӧ����ָ�򸸽���ָ��
 ʹ�ù�������ʱ�Ǵ�������ʼ���������еĽ�㣬�����Ҫָ�����Ӻ��Һ��ӵ�ָ��

 */
typedef struct
{
  int weight;                         /*�ٶ�ȨֵΪ����*/
  int parent, lchild, rchild;
} ElemType;

char ch[N] = {'A', 'B', 'C', 'D', 'E','F','G','H'};         /*�����ַ���*/
int w[N] = {7, 11, 24, 16, 30,4,7,1};           /*ÿ���ַ����ֵ�Ƶ��*/
void HuffmanTree(ElemType huffTree[ ]);              /*��������������������*/
void Select(ElemType huffTree[ ], int k, int *i1, int *i2);   /*��������Сֵ*/
void HuffmanCode(ElemType huffTree[ ]);               /*�����������*/

int main( )
{
	ElemType huffTree[2 * N - 1];
	/*����huffTree�洢��������
	���Ŷ�����ֻ�ж�Ϊ2�Ͷ�Ϊ0�Ľ�㣬����n0=n2+1,��������=n0+n0-1
	*/
	HuffmanTree(huffTree);                  /*���ú���HuffmanTree���������*/
	HuffmanCode(huffTree);                  /*���ú���HuffmanCode�����������*/
	return 0;
}
 /*���ܣ������շ�����
����������洢�շ�������������huffTree[2 * N - 1]
  ���أ������շ�������������*/

void HuffmanTree(ElemType huffTree[ ])
{
    int i, k, i1, i2;
	for (i = 0; i < 2 * N - 1; i++)       /*��ʼ�������н���û��˫�׺ͺ���*/
     {
		 huffTree[i].parent = -1;
		 huffTree[i].lchild = -1;
		 huffTree[i].rchild = -1;
     }
	 for (i = 0; i < N; i++)         /*��ʼ��������n��ֻ���и����Ķ�����*/
		 huffTree[i].weight = w[i];
	 for (k = N; k < 2 *N  - 1; k++)        /*����n-1�κϲ�*/
	 {
		 Select(huffTree, k, &i1, &i2);  /*k�ǲ��ҷ�Χ������Ȩֵ��С����������㣬�±�Ϊi1��i2*/
		 huffTree[k].weight = huffTree[i1].weight + huffTree[i2].weight;
		 huffTree[i1].parent = k; huffTree[i2].parent = k;
		 huffTree[k].lchild = i1; huffTree[k].rchild = i2;
	}
}
/*����Ȩֵ��С����������㣬�β�i1��i2Ϊ���������������е�λ�ã�������*/
void Select(ElemType huffTree[ ], int k, int *i1, int *i2)
{
	int min1 = 100;  /*��ʼ��������Ƶ�ʾ�С��100*/
	int min2 = 100;
	int i;
	for (i = 0; i < k; i++)                  /*����Ȩֵ��С�����������*/
	{
		if (huffTree[i].parent == -1) {                  /*���i�Ǹ����*/
			if (huffTree[i].weight < min1)  /*С����Сֵ*/
            {
				min2 = min1;
				*i2 = *i1;
                min1 = huffTree[i].weight;
                *i1 = i;
			}
			else if (huffTree[i].weight < min2) /*С�ڴ���Сֵ*/
            {
                min2 = huffTree[i].weight;
                *i2 = i;
            }
		}
	}
}
/*�����������
����ջ����Ҷ�ӽ�㵽˫��ֱ������㣬����ջ�������
*/
void HuffmanCode(ElemType huffTree[ ])
{
	int i, j, k;
	int S[N], top = -1;                     /*˳��ջS�����õĹ���������*/
	for (i = 0; i < N; i++)                   /*��ÿһ��Ҷ�ӽ��Ĺ���������*/
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


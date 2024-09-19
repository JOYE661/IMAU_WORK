#include <stdio.h>
#define N 8                           /*假设字符集中有8个字符*/
 /*定义哈夫曼树的结点结构
 结点结构组成说明
 哈夫曼树的构建从叶子结点开始不断地构建新的父结点所以结点中应包含指向父结点的指针
 使用哈夫曼树时是从树根开始，遍历树中的结点，因此需要指向左孩子和右孩子的指针

 */
typedef struct
{
  int weight;                         /*假定权值为整数*/
  int parent, lchild, rchild;
} ElemType;

char ch[N] = {'A', 'B', 'C', 'D', 'E','F','G','H'};         /*定义字符集*/
int w[N] = {7, 11, 24, 16, 30,4,7,1};           /*每个字符出现的频率*/
void HuffmanTree(ElemType huffTree[ ]);              /*函数声明，建哈夫曼树*/
void Select(ElemType huffTree[ ], int k, int *i1, int *i2);   /*求两个最小值*/
void HuffmanCode(ElemType huffTree[ ]);               /*求哈夫曼编码*/

int main( )
{
	ElemType huffTree[2 * N - 1];
	/*数组huffTree存储哈夫曼树
	最优二叉树只有度为2和度为0的结点，根据n0=n2+1,则结点总数=n0+n0-1
	*/
	HuffmanTree(huffTree);                  /*调用函数HuffmanTree求哈夫曼树*/
	HuffmanCode(huffTree);                  /*调用函数HuffmanCode求哈夫曼编码*/
	return 0;
}
 /*功能：构建赫夫曼树
参数：传入存储赫夫曼树的数组数huffTree[2 * N - 1]
  返回：构建赫夫曼树树的数组*/

void HuffmanTree(ElemType huffTree[ ])
{
    int i, k, i1, i2;
	for (i = 0; i < 2 * N - 1; i++)       /*初始化，所有结点均没有双亲和孩子*/
     {
		 huffTree[i].parent = -1;
		 huffTree[i].lchild = -1;
		 huffTree[i].rchild = -1;
     }
	 for (i = 0; i < N; i++)         /*初始化，构造n棵只含有根结点的二叉树*/
		 huffTree[i].weight = w[i];
	 for (k = N; k < 2 *N  - 1; k++)        /*进行n-1次合并*/
	 {
		 Select(huffTree, k, &i1, &i2);  /*k是查找范围，查找权值最小的两个根结点，下标为i1和i2*/
		 huffTree[k].weight = huffTree[i1].weight + huffTree[i2].weight;
		 huffTree[i1].parent = k; huffTree[i2].parent = k;
		 huffTree[k].lchild = i1; huffTree[k].rchild = i2;
	}
}
/*查找权值最小的两个根结点，形参i1和i2为左右子树在数组中的位置，传引用*/
void Select(ElemType huffTree[ ], int k, int *i1, int *i2)
{
	int min1 = 100;  /*初始化，假设频率均小于100*/
	int min2 = 100;
	int i;
	for (i = 0; i < k; i++)                  /*查找权值最小的两个根结点*/
	{
		if (huffTree[i].parent == -1) {                  /*结点i是根结点*/
			if (huffTree[i].weight < min1)  /*小于最小值*/
            {
				min2 = min1;
				*i2 = *i1;
                min1 = huffTree[i].weight;
                *i1 = i;
			}
			else if (huffTree[i].weight < min2) /*小于次最小值*/
            {
                min2 = huffTree[i].weight;
                *i2 = i;
            }
		}
	}
}
/*求哈夫曼编码
利用栈，从叶子结点到双亲直到根结点，利用栈逆序输出
*/
void HuffmanCode(ElemType huffTree[ ])
{
	int i, j, k;
	int S[N], top = -1;                     /*顺序栈S存放求得的哈夫曼编码*/
	for (i = 0; i < N; i++)                   /*求每一个叶子结点的哈夫曼编码*/
	{
		printf("字符%c的编码是：", ch[i]);
		k = i;
		while (huffTree[k].parent != -1)      /*求结点k的双亲，直到根结点*/
		{
			j = huffTree[k].parent;          /* j为结点k的双亲*/
			if (huffTree[j].lchild == k)
				S[++top] = 0;             /*左分支编码为0*/
			else
				S[++top] = 1;             /*右分支编码为1*/
			k = j;
		}
		while (top != -1)                  /*逆序输出栈S中的编码*/
			printf("%d", S[top--]);
		printf("\n");
	}
}


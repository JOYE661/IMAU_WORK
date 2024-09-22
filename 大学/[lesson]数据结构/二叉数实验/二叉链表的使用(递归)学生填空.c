#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#define MaxSize 100
/*将二叉链表的结点结构定义和各个函数定义放到这里*/
typedef char DataType;   /*定义二叉树结点的数据类型，假设为char型*/
typedef struct BiNode             /*定义二叉链表的结点类型*/
{
  DataType data;
  struct BiNode *lchild, *rchild;
} BiNode;
void PreOrder(BiNode *root)
{
#include<stdio.h>
#include<malloc.h>
#define N 20
	typedef int DataType;            /*定义二叉树结点的数据类型，假设为char型*/
	typedef struct BiNode             /*定义二叉链表的结点类型*/
	{
		DataType data;
		struct BiNode *lchild, *rchild;
	} BiNode;
	BiNode *InsertBST(BiNode *root, int x);
	BiNode *CreatBST(BiNode *root, int r[], int n);
	void DeleteBST(BiNode *p, BiNode *f);
	void InOrder(BiNode *root);
	BiNode *SearchBST(BiNode *root, int k);
	void InOrder(BiNode *root)
	{
		if (root == NULL) return;           /*递归调用的结束条件*/
		else {
			InOrder(root->lchild);            /*中序递归遍历root的左子树*/
			printf("%c ", root->data);         /*访问根结点的数据域，为char型*/
			InOrder(root->rchild);            /*中序递归遍历root的右子树*/
		}
	}

	BiNode *InsertBST(BiNode *root, int x)
	{
		if (root == NULL) {
			BiNode *s = (BiNode*)malloc(sizeof(BiNode));
			s->data = x;
			s->lchild = s->rchild = NULL;
			root = s;
		}
		else if (root->data > x) InsertBST(root->lchild, x);
		else InsertBST(root->rchild, x);
	}
	BiNode *CreatBST(BiNode *root, int r[], int n)
	{
		for (int i = 0; i < n; i++)
			InsertBST(root, ril);
	}
	void DeleteBST(BiNode *p, BiNode *f)
	{
		if ((p->lchild == NULL) && (p->rchild == NULL)){
			f->lchild = NULL; free(p); return;
		}
		if (p->rchild == NULL){
			f->lchild = p->lchild; free(p); return;
		}
		if (p->lchild == NULL){
			f->lchild = p->rchild; free(p); return;
		}
	}
	BiNode *SearchBST(BiNode *root, int k)
	{
		if (root == NULL) return NULL;
		if (root->data == k) return root;
		else if (root->data > k) return SearchBST(root->lchild, k);
		else return SearchBST(root->rchild, k);
	}
if (root == NULL)  return;         /*递归调用的结束条件*/
else {
printf("%c ", root->data);        /*访问根结点的数据域，为char型*/
  PreOrder(root->lchild);          /*前序递归遍历root的左子树*/
PreOrder(root->rchild);          /*前序递归遍历root的右子树*/
}
 }
void InOrder (BiNode *root)
{
if (root == NULL) return;           /*递归调用的结束条件*/
else {
InOrder(root->lchild);            /*中序递归遍历root的左子树*/
 printf("%c ", root->data);         /*访问根结点的数据域，为char型*/
InOrder(root->rchild);            /*中序递归遍历root的右子树*/
}
}

void PostOrder(BiNode *root)
{
if (root == NULL) return;          /*递归调用的结束条件*/
else {
PostOrder(root->lchild);         /*后序递归遍历root的左子树*/
PostOrder(root->rchild);         /*后序递归遍历root的右子树*/
printf("%c ",root->data);              /*访问根结点的数据域，为char型*/
}
}
void LeverOrder(BiNode *root)
{
	int rear;
BiNode *q = NULL, *Q[MaxSize];        /*采用顺序队列*/
int front = rear = -1;                     /*初始化顺序队列*/
if (root == NULL) return;                /*二叉树为空，算法结束*/
Q[++rear] = root;                       /*根指针入队*/
while (front != rear)                     /*当队列非空时*/
{
q = Q[++front];                       /*出队*/
printf("%c ", q->data);                 /*访问结点，为char型*/
if (q->lchild != NULL)  Q[++rear] = q->lchild;
if (q->rchild != NULL)  Q[++rear] = q->rchild;
   }
}
BiNode * CreatBiTree(BiNode *root)
{
	char ch;
	scanf("%c", &ch);           /*输入结点的数据信息*/
	if (ch == '#') root = NULL;              /*递归结束，建立一棵空树*/
	else {
	root = (BiNode *)malloc(sizeof(BiNode));    /*生成新结点*/
	root->data = ch;                         /*新结点的数据域为ch*/
	root->lchild = CreatBiTree(root->lchild);           /*递归建立左子树*/
	root->rchild = CreatBiTree(root->rchild);           /*递归建立右子树*/
		}
return root;
}
void DestroyBiTree(BiNode *root)
{
	if (root == NULL) return;
	DestroyBiTree(root->lchild);
	DestroyBiTree(root->rchild);
	free(root);
}

int Deep_bitree(BiNode *root)
{//求二叉树的深度
	int n,nl,nr;
	if(root)
	{
		nl=Deep_bitree(root->lchild);
		nr=Deep_bitree(root->rchild);
		if(nl>=nr)
			n=nl+1;
		else
			n=nr+1;
	}
	else
		n=0;
	return n;
}// deep_bitree

int leaf_number(BiNode *root)
{//求二叉树叶子的数目
	int num,lnum,rnum;
	if(root)
	{
		if(!root->lchild &&!root->rchild)  {num=1;printf("%c ",root->data);}
		else
		{
			lnum=leaf_number(root->lchild);
			rnum=leaf_number(root->rchild);

			num=lnum+rnum;
		}
	}
	else num=0;
	return num;
}


int main( )
{
	BiNode *root = NULL;                  /*定义二叉树的根指针变量*/
    root = CreatBiTree(root);                  /*建立一棵二叉树*/
	printf("该二叉树的根结点是：%c\n", root->data);
	printf("\n该二叉树的前序遍历序列是：");
	PreOrder(root);
	printf("\n该二叉树的中序遍历序列是：");
	InOrder(root);
	printf("\n该二叉树的后序遍历序列是：");
	PostOrder(root);
	printf("\n该二叉树的层序遍历序列是：");
	LeverOrder(root);

	int deep;
    deep=Deep_bitree(root);
    printf("\n该二叉树的深度是：%d.",deep);

    int leafnumber;
    printf("\n该二叉树的叶子节点是：");
    leafnumber=leaf_number(root);
    printf("合计%d个。",leafnumber);


    DestroyBiTree(root);


	return 0;
}

#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#define MaxSize 100
/*����������Ľ��ṹ����͸�����������ŵ�����*/
typedef char DataType;   /*��������������������ͣ�����Ϊchar��*/
typedef struct BiNode             /*�����������Ľ������*/
{
  DataType data;
  struct BiNode *lchild, *rchild;
} BiNode;
void PreOrder(BiNode *root)
{
#include<stdio.h>
#include<malloc.h>
#define N 20
	typedef int DataType;            /*��������������������ͣ�����Ϊchar��*/
	typedef struct BiNode             /*�����������Ľ������*/
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
		if (root == NULL) return;           /*�ݹ���õĽ�������*/
		else {
			InOrder(root->lchild);            /*����ݹ����root��������*/
			printf("%c ", root->data);         /*���ʸ�����������Ϊchar��*/
			InOrder(root->rchild);            /*����ݹ����root��������*/
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
if (root == NULL)  return;         /*�ݹ���õĽ�������*/
else {
printf("%c ", root->data);        /*���ʸ�����������Ϊchar��*/
  PreOrder(root->lchild);          /*ǰ��ݹ����root��������*/
PreOrder(root->rchild);          /*ǰ��ݹ����root��������*/
}
 }
void InOrder (BiNode *root)
{
if (root == NULL) return;           /*�ݹ���õĽ�������*/
else {
InOrder(root->lchild);            /*����ݹ����root��������*/
 printf("%c ", root->data);         /*���ʸ�����������Ϊchar��*/
InOrder(root->rchild);            /*����ݹ����root��������*/
}
}

void PostOrder(BiNode *root)
{
if (root == NULL) return;          /*�ݹ���õĽ�������*/
else {
PostOrder(root->lchild);         /*����ݹ����root��������*/
PostOrder(root->rchild);         /*����ݹ����root��������*/
printf("%c ",root->data);              /*���ʸ�����������Ϊchar��*/
}
}
void LeverOrder(BiNode *root)
{
	int rear;
BiNode *q = NULL, *Q[MaxSize];        /*����˳�����*/
int front = rear = -1;                     /*��ʼ��˳�����*/
if (root == NULL) return;                /*������Ϊ�գ��㷨����*/
Q[++rear] = root;                       /*��ָ�����*/
while (front != rear)                     /*�����зǿ�ʱ*/
{
q = Q[++front];                       /*����*/
printf("%c ", q->data);                 /*���ʽ�㣬Ϊchar��*/
if (q->lchild != NULL)  Q[++rear] = q->lchild;
if (q->rchild != NULL)  Q[++rear] = q->rchild;
   }
}
BiNode * CreatBiTree(BiNode *root)
{
	char ch;
	scanf("%c", &ch);           /*�������������Ϣ*/
	if (ch == '#') root = NULL;              /*�ݹ����������һ�ÿ���*/
	else {
	root = (BiNode *)malloc(sizeof(BiNode));    /*�����½��*/
	root->data = ch;                         /*�½���������Ϊch*/
	root->lchild = CreatBiTree(root->lchild);           /*�ݹ齨��������*/
	root->rchild = CreatBiTree(root->rchild);           /*�ݹ齨��������*/
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
{//������������
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
{//�������Ҷ�ӵ���Ŀ
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
	BiNode *root = NULL;                  /*����������ĸ�ָ�����*/
    root = CreatBiTree(root);                  /*����һ�ö�����*/
	printf("�ö������ĸ�����ǣ�%c\n", root->data);
	printf("\n�ö�������ǰ����������ǣ�");
	PreOrder(root);
	printf("\n�ö�������������������ǣ�");
	InOrder(root);
	printf("\n�ö������ĺ�����������ǣ�");
	PostOrder(root);
	printf("\n�ö������Ĳ�����������ǣ�");
	LeverOrder(root);

	int deep;
    deep=Deep_bitree(root);
    printf("\n�ö�����������ǣ�%d.",deep);

    int leafnumber;
    printf("\n�ö�������Ҷ�ӽڵ��ǣ�");
    leafnumber=leaf_number(root);
    printf("�ϼ�%d����",leafnumber);


    DestroyBiTree(root);


	return 0;
}

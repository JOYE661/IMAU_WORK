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


int main()
{
	int k;
	BiNode *root=NULL;
	int r[10] = { 63, 55, 90, 42, 58, 70, 10, 45, 67, 83 };
	root=CreatBST(root, r, 10);
	printf("����Ԫ��Ϊ��\n");
	InOrder(root);
	printf("\n������Ҫ���ҵ�Ԫ�أ�\n");
	scanf("%d", &k);
	printf("�Ƚϵ�Ԫ���ǣ�");
	SearchBST(root, k);
	getchar(); getchar();
	return 0;
}
void InOrder(BiNode *root)
{
	
	if (root == NULL) return;           /*�ݹ���õĽ�������*/
	else {
		InOrder(root->lchild);            /*����ݹ����root��������*/
		printf("%d ", root->data);         /*���ʸ�����������Ϊchar��*/
		InOrder(root->rchild);            /*����ݹ����root��������*/
	}
}

BiNode *InsertBST(BiNode *root, int x)
{
	if (root == NULL) {                         /*�ҵ�����λ��*/
		BiNode *s = (BiNode *)malloc(sizeof(BiNode)); s->data = x;
		s->lchild = s->rchild = NULL;
		root = s;	
	}
	else if (root->data > x) root->lchild = InsertBST(root->lchild, x);
	else root->rchild = InsertBST(root->rchild, x);
	return root;
}
BiNode *CreatBST(BiNode *root, int r[], int n)
{
	int i;
	for (i = 0; i < n; i++)
		root=InsertBST(root, r[i]);
	return root;
}
void DeleteBST(BiNode *p, BiNode *f)
{
	if ((p->lchild == NULL) && (p->rchild == NULL)) {     /*pΪҶ��*/
		f->lchild = NULL; free(p); return;
	}
	if (p->rchild == NULL) {                 /*pֻ��������*/
		f->lchild = p->lchild; free(p); return;
	}
	if (p->lchild == NULL) {                 /*pֻ��������*/
		f->lchild = p->rchild; free(p); return;
	}
	BiNode *par = p, *s = p->rchild;          /*p����������������*/
	while (s->lchild != NULL)               /*���������½��*/
	{
		par = s;
		s = s->lchild;
	}
	p->data = s->data;
	if (par == p) par->rchild = s->rchild;      /*���������p���Һ�����������*/
	else par->lchild = s->rchild;
	free(s);
}
BiNode *SearchBST(BiNode *root, int k)
{
	if (root == NULL) return NULL;
	if (root->data == k)
	{
		printf("%d", root->data);
		return root;
	}
	else if (root->data > k) return SearchBST(root->lchild, k);
	else return SearchBST(root->rchild, k);
}


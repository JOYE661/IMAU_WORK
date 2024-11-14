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


int main()
{
	int k;
	BiNode *root=NULL;
	int r[10] = { 63, 55, 90, 42, 58, 70, 10, 45, 67, 83 };
	root=CreatBST(root, r, 10);
	printf("集合元素为：\n");
	InOrder(root);
	printf("\n请输入要查找的元素：\n");
	scanf("%d", &k);
	printf("比较的元素是：");
	SearchBST(root, k);
	getchar(); getchar();
	return 0;
}
void InOrder(BiNode *root)
{
	
	if (root == NULL) return;           /*递归调用的结束条件*/
	else {
		InOrder(root->lchild);            /*中序递归遍历root的左子树*/
		printf("%d ", root->data);         /*访问根结点的数据域，为char型*/
		InOrder(root->rchild);            /*中序递归遍历root的右子树*/
	}
}

BiNode *InsertBST(BiNode *root, int x)
{
	if (root == NULL) {                         /*找到插入位置*/
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
	if ((p->lchild == NULL) && (p->rchild == NULL)) {     /*p为叶子*/
		f->lchild = NULL; free(p); return;
	}
	if (p->rchild == NULL) {                 /*p只有左子树*/
		f->lchild = p->lchild; free(p); return;
	}
	if (p->lchild == NULL) {                 /*p只有右子树*/
		f->lchild = p->rchild; free(p); return;
	}
	BiNode *par = p, *s = p->rchild;          /*p的左右子树均不空*/
	while (s->lchild != NULL)               /*查找最左下结点*/
	{
		par = s;
		s = s->lchild;
	}
	p->data = s->data;
	if (par == p) par->rchild = s->rchild;      /*特殊情况，p的右孩子无左子树*/
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


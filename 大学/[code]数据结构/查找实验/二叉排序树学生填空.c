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
	BiNode *root = NULL;
	int r[10] = { 63, 55, 90, 42, 58, 70, 10, 45, 67, 83 };
	root = CreatBST(root, r, 10);
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
	if (root == NULL) return;
	else {
		InOrder(root->lchild);
		printf("%c ", root->data);
		InOrder(root->rchild);
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
		InsertBST(root, r[i]);
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



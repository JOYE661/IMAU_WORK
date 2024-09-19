#include<stdio.h>
#include<stdlib.h>
typedef char ElemType;
#define MaxSize 30
//结点结构
typedef struct BiTreeNode{
	ElemType  data;
	struct BiTreeNode *lchild,*rchild;
}BiTreeNode,*BiTree;

//创建二叉树
BiTree CreateBiTree(){
	ElemType ch;
	BiTree T;
	scanf("%c",&ch);
	if(ch=='#')
		T=NULL;
	else{
		T=(BiTree)malloc(sizeof(BiTreeNode));
        T->data=ch;//生成根结点
		T->lchild=CreateBiTree();//构造左子树
		T->rchild=CreateBiTree();//构造右子树
	}
	return T;
}
void DestroyBiTree(BiTree T)//删除二叉树结构
{
    if (T == NULL) return;
    else {
        DestroyBiTree(T->lchild);
        DestroyBiTree(T->rchild);
        free(T);
    }
}

//前序遍历以T为根的二叉树
void PreOrder(BiTree T)
{
	if(T==NULL)
        return;//递归结束条件
    else
	{
		printf("%c ",T->data);//访问根结点
		PreOrder(T->lchild);//先序遍历根的左子树
		PreOrder(T->rchild);//先序遍历根的右子树
	}
}

//中序遍历以T为根的二叉树
void InOrder(BiTree T)
{
	if(T==NULL)
        return;//递归结束条件
    else
	{
		InOrder(T->lchild);//中序遍历根的左子树
		printf("%c ",T->data);//访问根结点
		InOrder(T->rchild);//中序遍历根的右子树
	}
}

//后序遍历以T为根的二叉树
void PostOrder(BiTree T)
{
	if(T==NULL)
        return;//递归结束条件
    else
	{
		PostOrder(T->lchild);//后序遍历根的左子树
		PostOrder(T->rchild);//后序遍历根的右子树
		printf("%c ",T->data);//访问根结点
	}
}

//层序遍历
void LevelOrder(BiTree T)
{
	BiTree Q[MaxSize];//存放根结点的队列
	int front=0,rear=0;//队头队尾指针
	BiTree p; //工作指针
	if(T)//根结点入队
	{
		Q[rear]=T;
		rear=(rear+1)%MaxSize;
	}
	while(front!=rear){
		p=Q[front];//队头元素出队
		front=(front+1)%MaxSize;
		printf("%c ",p->data);;
		if(p->lchild)//左孩子不为空，入队
		{
			Q[rear]=p->lchild;
			rear=(rear+1)%MaxSize;
		}
		if(p->rchild)//右孩子不为空，入队
		{
		Q[rear]=p->rchild;
		rear=(rear+1)%MaxSize;
		}
	}
}
//恢复二叉树，传入前序遍历序列，中序遍历序列，结点个数
BiTree RecoverTree(char *front,char *mid,int len)
{
    if(len==0)//递归的结束条件
    {
        return NULL;
    }
    char temp=front[0];//先序找根
    int i=0,j=0;
    BiTree T;
    for(i=0;i<len;i++)//在中序中找到根
         if(mid[j]!=temp)
            j++;
    //中序分左右
    T=(BiTree)malloc(sizeof(BiTreeNode));
    T->data=temp;
    T->lchild=RecoverTree(front+1,mid,j);//恢复左子树
    T->rchild=RecoverTree(front+j+1,mid+j+1,len-j-1);//恢复右子树

}

//主函数
int main(){

    int x;
    int n,i;//记录结点个数,循环变量
    ElemType pre[MaxSize],in[MaxSize];
    BiTree tree=NULL;
    puts("1.创建二叉树并输出二叉树的四种遍历序列");
    puts("2.已知序列恢复二叉树");
    printf("请选择执行序号：");
    scanf("%d",&x);
    getchar();
    if(x==1)
    {
        puts("请输入二叉树序列,如：AB#C##D##");
        tree=CreateBiTree();
        puts("二叉树创建完成！~~");
        printf("层序遍历二叉树输出结果：");
        LevelOrder(tree);
        putchar('\n');
        printf("先序遍历二叉树输出结果：");
        PreOrder(tree);
        putchar('\n');
        printf("中序遍历二叉树输出结果：");
        InOrder(tree);
        putchar('\n');
        printf("后序遍历二叉树输出结果：");
        PostOrder(tree);
        putchar('\n');
    }
	else if(x==2)
    {
        puts("已知前序中序，输出后序\n");
        puts("示例：前序abcd中序bcad，输出后序cbda\n");
        printf("请输入结点个数：");
        scanf("%d",&n);
        getchar();
        printf("请输入前序序列：");
        for(i=0;i<n;i++)
        {
            pre[i]=getchar();
        }
        getchar();
        printf("请输入中序序列：");
        for(i=0;i<n;i++)
        {
            in[i]=getchar();
        }
        getchar();
        tree=RecoverTree(pre,in,n);//恢复序列
        printf("后序序列为：");
        PostOrder(tree);

    }else
        printf("序号输入错误！");

	DestroyBiTree(tree);
}

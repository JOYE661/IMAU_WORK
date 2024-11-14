#include<stdio.h>
#include<stdlib.h>
typedef char ElemType;
#define MaxSize 30
//���ṹ
typedef struct BiTreeNode{
	ElemType  data;
	struct BiTreeNode *lchild,*rchild;
}BiTreeNode,*BiTree;

//����������
BiTree CreateBiTree(){
	ElemType ch;
	BiTree T;
	scanf("%c",&ch);
	if(ch=='#')
		T=NULL;
	else{
		T=(BiTree)malloc(sizeof(BiTreeNode));
        T->data=ch;//���ɸ����
		T->lchild=CreateBiTree();//����������
		T->rchild=CreateBiTree();//����������
	}
	return T;
}
void DestroyBiTree(BiTree T)//ɾ���������ṹ
{
    if (T == NULL) return;
    else {
        DestroyBiTree(T->lchild);
        DestroyBiTree(T->rchild);
        free(T);
    }
}

//ǰ�������TΪ���Ķ�����
void PreOrder(BiTree T)
{
	if(T==NULL)
        return;//�ݹ��������
    else
	{
		printf("%c ",T->data);//���ʸ����
		PreOrder(T->lchild);//�����������������
		PreOrder(T->rchild);//�����������������
	}
}

//���������TΪ���Ķ�����
void InOrder(BiTree T)
{
	if(T==NULL)
        return;//�ݹ��������
    else
	{
		InOrder(T->lchild);//�����������������
		printf("%c ",T->data);//���ʸ����
		InOrder(T->rchild);//�����������������
	}
}

//���������TΪ���Ķ�����
void PostOrder(BiTree T)
{
	if(T==NULL)
        return;//�ݹ��������
    else
	{
		PostOrder(T->lchild);//�����������������
		PostOrder(T->rchild);//�����������������
		printf("%c ",T->data);//���ʸ����
	}
}

//�������
void LevelOrder(BiTree T)
{
	BiTree Q[MaxSize];//��Ÿ����Ķ���
	int front=0,rear=0;//��ͷ��βָ��
	BiTree p; //����ָ��
	if(T)//��������
	{
		Q[rear]=T;
		rear=(rear+1)%MaxSize;
	}
	while(front!=rear){
		p=Q[front];//��ͷԪ�س���
		front=(front+1)%MaxSize;
		printf("%c ",p->data);;
		if(p->lchild)//���Ӳ�Ϊ�գ����
		{
			Q[rear]=p->lchild;
			rear=(rear+1)%MaxSize;
		}
		if(p->rchild)//�Һ��Ӳ�Ϊ�գ����
		{
		Q[rear]=p->rchild;
		rear=(rear+1)%MaxSize;
		}
	}
}
//�ָ�������������ǰ��������У�����������У�������
BiTree RecoverTree(char *front,char *mid,int len)
{
    if(len==0)//�ݹ�Ľ�������
    {
        return NULL;
    }
    char temp=front[0];//�����Ҹ�
    int i=0,j=0;
    BiTree T;
    for(i=0;i<len;i++)//���������ҵ���
         if(mid[j]!=temp)
            j++;
    //���������
    T=(BiTree)malloc(sizeof(BiTreeNode));
    T->data=temp;
    T->lchild=RecoverTree(front+1,mid,j);//�ָ�������
    T->rchild=RecoverTree(front+j+1,mid+j+1,len-j-1);//�ָ�������

}

//������
int main(){

    int x;
    int n,i;//��¼������,ѭ������
    ElemType pre[MaxSize],in[MaxSize];
    BiTree tree=NULL;
    puts("1.��������������������������ֱ�������");
    puts("2.��֪���лָ�������");
    printf("��ѡ��ִ����ţ�");
    scanf("%d",&x);
    getchar();
    if(x==1)
    {
        puts("���������������,�磺AB#C##D##");
        tree=CreateBiTree();
        puts("������������ɣ�~~");
        printf("���������������������");
        LevelOrder(tree);
        putchar('\n');
        printf("���������������������");
        PreOrder(tree);
        putchar('\n');
        printf("���������������������");
        InOrder(tree);
        putchar('\n');
        printf("���������������������");
        PostOrder(tree);
        putchar('\n');
    }
	else if(x==2)
    {
        puts("��֪ǰ�������������\n");
        puts("ʾ����ǰ��abcd����bcad���������cbda\n");
        printf("�������������");
        scanf("%d",&n);
        getchar();
        printf("������ǰ�����У�");
        for(i=0;i<n;i++)
        {
            pre[i]=getchar();
        }
        getchar();
        printf("�������������У�");
        for(i=0;i<n;i++)
        {
            in[i]=getchar();
        }
        getchar();
        tree=RecoverTree(pre,in,n);//�ָ�����
        printf("��������Ϊ��");
        PostOrder(tree);

    }else
        printf("����������");

	DestroyBiTree(tree);
}

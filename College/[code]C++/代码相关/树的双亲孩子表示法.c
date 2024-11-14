#include<stdio.h>
#include<stdlib.h>
#define MAX_SIZE 20
#define ElemType char
//˫�׺��ӱ�ʾ��
typedef struct ChildNode {//���ӽ������
    int child;//���ӽ���������д洢λ�õ��±�
    struct ChildNode* next;
}ChildNode;
typedef struct { //��ͷ�ṹ
    ElemType data;//������������
    int parent;//˫�׽��λ��
    ChildNode* firstchild;//���������ͷָ��
}CTBox;
typedef struct {//���ṹ
    CTBox nodes[MAX_SIZE];//�洢��������
    int n, r;//���������������λ��
}CTree;
ChildNode* CreatChildNode(int i)
{
    ChildNode* s= (ChildNode*)malloc(sizeof(ChildNode));
    int x;
    s->next = NULL;
    printf("------�����%d�����ӽ���ڲ����е�λ�ã�",i);
    scanf("%d",&x);
    getchar();
    s->child=x-1;//�����Ŵ�0��ʼ
    return s;
}

//˫�׺��ӱ�ʾ���洢��ͨ��
void CreatTree(CTree* tree) {
    int i, num,x;//num��¼���ӵ�������x��ʱ���溢���ڲ������е�λ��
    ChildNode* p;
    tree->r = 0;//����λ��
    printf("�Ӹ���㿪ʼ���ղ��������������ֵ��\n");
    for (i = tree->r; i < tree->n; i++) {
        //Ϊ����Ԫ�ص�������ֵ��
        printf("--����� %d ������ֵ��", i + 1);
        scanf("%c", &(tree->nodes[i].data));
        getchar();
        printf("--����ý���˫�׽����ţ�");
        scanf("%d", &x);
        getchar();
        tree->nodes[i].parent=x-1;
        tree->nodes[i].firstchild = NULL;//����ָ��Ϊ��
        //��������
        printf("----������ %c �ĺ��ӽ��������", tree->nodes[i].data);
        scanf("%d", &num);
        getchar();

        if (num != 0) {//��Ϊ�����ָ����ָ���һ����㣬�ڶ�������ǵ�һ������next��ָ��
            p=CreatChildNode(1);
            tree->nodes[i].firstchild = p;//�����firstchildָ���һ�����ӽ��
            for (int j = 1; j < num; j++) {
                p->next=CreatChildNode(j+1);
                p = p->next;
            }
        }
    }
}
//��ĳ�����ĺ���
void findKids(CTree tree, char a) {
    int i, hasKids = 0;
    for (i = 0; i < tree.n; i++) {
        if (tree.nodes[i].data == a) {
            ChildNode* p = tree.nodes[i].firstchild;
            while (p) {
                hasKids = 1;
                printf("%c ", tree.nodes[p->child].data);
                p = p->next;
            }
            break;
        }
    }
    if (hasKids == 0) {
        printf("�˽��ΪҶ�ӽ��");
    }
}
//�ͷŸ�������ռ�õ��ڴ�
void deleteTree(CTree tree) {
    int i;
    //�����������
    for (i = 0; i < tree.n; i++) {
        ChildNode* p = tree.nodes[i].firstchild;
        //�ͷ������еĸ������
        while (p) {
            ChildNode* next = p;
            p = p->next;
            free(next);
        }
    }
}
int main()
{
    CTree tree;//�������ṹ
    int i;
    ElemType x;
    printf("���������Ľ�������");
    scanf("%d",&tree.n);
    getchar();
    CreatTree(&tree);
    for(i=0;i<tree.n;i++)
    {
        printf("%c %d\n",tree.nodes[i].data,tree.nodes[i].parent);
    }
    printf("�鿴�Ǹ����ĺ��ӽ�㣿");
    scanf("%c",&x);
    findKids(tree, x);
    //printf("�ҳ���� C ��˫�׽�㣺");
    //findParent(tree, 'C');
    deleteTree(tree);
    return 0;
}

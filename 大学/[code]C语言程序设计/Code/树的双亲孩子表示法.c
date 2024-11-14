#include<stdio.h>
#include<stdlib.h>
#define MAX_SIZE 20
#define ElemType char
//双亲孩子表示法
typedef struct ChildNode {//孩子结点链表
    int child;//孩子结点在数组中存储位置的下标
    struct ChildNode* next;
}ChildNode;
typedef struct { //表头结构
    ElemType data;//结点的数据类型
    int parent;//双亲结点位置
    ChildNode* firstchild;//孩子链表的头指针
}CTBox;
typedef struct {//树结构
    CTBox nodes[MAX_SIZE];//存储结点的数组
    int n, r;//结点数量和树根的位置
}CTree;
ChildNode* CreatChildNode(int i)
{
    ChildNode* s= (ChildNode*)malloc(sizeof(ChildNode));
    int x;
    s->next = NULL;
    printf("------输入第%d个孩子结点在层序中的位置：",i);
    scanf("%d",&x);
    getchar();
    s->child=x-1;//数组编号从0开始
    return s;
}

//双亲孩子表示法存储普通树
void CreatTree(CTree* tree) {
    int i, num,x;//num记录孩子的数量，x临时保存孩子在层序列中的位置
    ChildNode* p;
    tree->r = 0;//根的位置
    printf("从根结点开始按照层序输入各个结点的值：\n");
    for (i = tree->r; i < tree->n; i++) {
        //为数组元素的三个域赋值，
        printf("--输入第 %d 个结点的值：", i + 1);
        scanf("%c", &(tree->nodes[i].data));
        getchar();
        printf("--输入该结点的双亲结点序号：");
        scanf("%d", &x);
        getchar();
        tree->nodes[i].parent=x-1;
        tree->nodes[i].firstchild = NULL;//链表指针为空
        //孩子链表
        printf("----输入结点 %c 的孩子结点数量：", tree->nodes[i].data);
        scanf("%d", &num);
        getchar();

        if (num != 0) {//因为数组的指针域指向第一个结点，第二个结点是第一个结点的next域指向
            p=CreatChildNode(1);
            tree->nodes[i].firstchild = p;//数组的firstchild指向第一个孩子结点
            for (int j = 1; j < num; j++) {
                p->next=CreatChildNode(j+1);
                p = p->next;
            }
        }
    }
}
//找某个结点的孩子
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
        printf("此结点为叶子结点");
    }
}
//释放各个链表占用的内存
void deleteTree(CTree tree) {
    int i;
    //逐个遍历链表
    for (i = 0; i < tree.n; i++) {
        ChildNode* p = tree.nodes[i].firstchild;
        //释放链表中的各个结点
        while (p) {
            ChildNode* next = p;
            p = p->next;
            free(next);
        }
    }
}
int main()
{
    CTree tree;//创建树结构
    int i;
    ElemType x;
    printf("请输入树的结点个数：");
    scanf("%d",&tree.n);
    getchar();
    CreatTree(&tree);
    for(i=0;i<tree.n;i++)
    {
        printf("%c %d\n",tree.nodes[i].data,tree.nodes[i].parent);
    }
    printf("查看那个结点的孩子结点？");
    scanf("%c",&x);
    findKids(tree, x);
    //printf("找出结点 C 的双亲结点：");
    //findParent(tree, 'C');
    deleteTree(tree);
    return 0;
}

#define _CRT_SECURE_NO_WARNINGS 1
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define INFEASIBLE -1
#define OVERFLOW -2
typedef int Status;
typedef int ElemType;
#include<stdio.h>
#include<stdlib.h>
#include<iostream>
using namespace std;
//单链表图解：头指针L->[头结点][next]->[首元结点a1][next]->[a2][next]->

//typedef struct{
//	char num[8];
//	char name[8];
//	int score;
//}ElemType;				//学生学号、姓名、成绩的系统管控模板

//单链表1.
typedef struct LNode{						//加Lnode为了方便声明指向该结构体的指针类型
	ElemType data;							//结点数据域
	struct LNode *next;						//结点指针域
}LNode, *LinkList;							//Lnode为命名的结构体，LinkList为命名的该结构体指针
											//理解为定义链表：LinkLsit L; 定义结点指针：LNode *p <=> LinkList p;
											//两者为同种类型，只不过这样方便命名区分链表指针和结点指针
//单链表2.
typedef struct Node{
	ElemType data;
	struct Node *next;
}Node;

//一，初始化
Status InitList_L(LinkList &L){
	L = (LinkList)malloc(sizeof(LNode));	//1.生成新结点作头结点，用头指针L指向头结点
	//或者L=new LNode;
	L->next = NULL;							//2.将头结点的指针域置空
	return OK;
}//c++单链表的初始化
Node *InitList(){
	Node*first = (Node*)malloc(sizeof(Node));
	first->next = NULL;
	return first;
}

//二，判空
int ListEmpty(LinkList L){					//1.若L为空表，则返回1，否则返回0
	if (L->next)//非空
		return 0;
	else
		return 1;
}//c++单链表判空
int Empty(Node*first){
	if (first->next == NULL)
		return 1;
	else
		return 0;
}

//三，销毁
Status DestoryList_L(LinkList &L){			//删除包括头结点
	LNode *p;								//1.设立工作指针p，目的方便删除结点
	while (L != NULL){						//2.一直执行删除，直到L头指针指向空
		p = L;								//3.p指针拷贝L头指针（即为头结点处或者下一个结点处）
		L = L->next;						//4.L指针指向下一个结点的地址
		free(p);							//5.工作指针删除结点
		//或者delete p;
	}
	return OK;
}//c++销毁单链表

//四，清空
Status ClearList(LinkList &L){				//删除非头结点的结点
	LNode *p, *q;							//1.设立工作指针p和拷贝指针q,p删除节点,q提供下一个结点位置
	p = L->next;							//2.p拷贝首元指针地址
	while (p != NULL){						//3.一直执行删除，直到p、q空
		q = p->next;						//4.q指针移向下一个结点
		free(p);							//5.p指针可安全删除所指向结点	
		p = q;								//6.删除结束后p指针移向q,即下一个结点
	}
	L->next = NULL;							//7.清空结束后头结点指针域为空（初始化头结点
	return OK;
}//c++清空单链表

//五，表长
int ListLength_L(LinkList L){				//返回L中元素的个数
	LinkList p;
	p = L->next;							//1.p指向首元结点的地址
	int count = 0;							//2.设立计数器count
	while (p != NULL){						//3.执行计数直到p为空
		count++;
		p = p->next;						//4.p移向下一个结点的地址
	}
	return count;
}//c++求链表表长
int Length(Node*first){
	Node*p = first->next;
	int count = 0;
	while (p != NULL){
		count++;
		p = p->next;
	}
	return count;
}

//六，取值*
Status GetElem_L(LinkList L, int i, ElemType &e){
	LNode*p;
	p = L->next;							//1.p指向首元结点的地址
	int count = 1;							//2.设立计数器count
	while (p != NULL&&count < i){			//3.执行计数直到p为空或计数满足条件时或计数溢出
		count++;
		p = p->next;						//4.p移向下一个结点的地址
	}
	if (p == NULL || count>i)return ERROR;	//5.p为空或计数大于需求及找不到数
	e = p->data;							//6.用e返回所查找到的数
	return OK;
}//c++按位查找链表值
int Get(Node*first, int i, ElemType*ptr){
	Node*p = first->next;
	int count = 1;
	while (p != NULL&&count < i){
		count++;
		p = p->next;
	}
	if (p = NULL){
		printf("位置错误，查找失败\n");
		return 0;
	}
	else{
		*ptr = p->data;
		return 1;
	}
}//c按位查找

//七，查找*
LNode* LocateElem_L(LinkList L, ElemType e)	//输入值查找地址
{
	LNode*p;
	p = L->next;							//1.p指向首元结点的地址
	while (p != NULL&&p->data != e)			//2.执行计数直到p为空或满足条件时
	{
		p = p->next;						//3.p移向下一个结点的地址
	}
	return p;
}//c++按值查找地址 O(n)
int LocateEle_L(LinkList L, ElemType e)		//输入值查找位次
{
	LNode*p;
	p = L->next;							//1.p指向首元结点的地址
	int count = 1;							//2.设立计数器count
	while (p != NULL&&p->data != e)			//3.执行计数直到p为空或满足条件时
	{
		p = p->next;						//4.p移向下一个结点的地址
		count++;
	}
	if (p != NULL)							//5.查找成功
		return count;
	else									//6.查找失败
		return 0;
}//c++按值查找位次 O(n)
int Locate(Node*first, ElemType x){
	Node *p = first->next;
	int count = 1;
	while (p != NULL){
		if (p->data == x)
			return count;
		count++;
		p = p->next;
	}
	return 0;
}
//八，插入 
Status ListInsert_L(LinkList &L, int i, ElemType e)
{
	LNode*p;
	p = L;
	int count = 0;
	while (p != NULL&&count < i - 1){		//i-1的意思是循环直到所需插入位次的前一位
		p = p->next;
		count++;
	}										//寻找第i-1个结点，p指向i-1结点
	if (p == NULL || count>i - 1)
		return ERROR;						//i大于表长+1或者小于1，插入位置非法
	LNode*s;
	s = (LNode*)malloc(sizeof(LNode));
	s->data = e;							//开辟一个新结点，s为该结点指针，数据域为e
	s->next = p->next;						//s的next域接上上一个结点本应该指向的地址
	p->next = s;							//上一个结点的next域重新连接上新结点地址
	return OK;
}//c++按位插入新节点 O(n)
int Insert(Node*first, int i, ElemType x){
	Node*s = NULL, *p = first;
	int count = 0;
	while (p != NULL&&count < i - 1){
		p = p->next;
		count++;
	}
	if (p == NULL){
		printf("位置错误，插入失败\n");
		return 0;
	}
	else{
		s = (Node*)malloc(sizeof(Node));
		s->data = x;
		s->next = p->next;
		p->next = s;
		return 1;
	}
}
//九，删除
Status ListDelete_L(LinkList &L, int i, ElemType &e)
{
	LNode*p;
	p = L;
	int count = 0;
	while (p != NULL&&count < i - 1){		//i-1的意思是循环直到所需插入位次的前一位
		p = p->next;
		count++;
	}										//寻找第i-1个结点，p指向i-1结点
	if (p == NULL || count>i - 1)
		return ERROR;						//i大于表长+1或者小于1，插入位置非法
	LNode* q;
	q = p->next;							//q指向需要删除的结点
	p->next = q->next;						//p的next域跳过q结点指向q的next域
	e = q->data;							//保存所删除的数据
	free(q);
	return OK;
}//c++删除指定位节点 O(n)

//十，建表
void CreatList_H(LinkList &L, int n){
	//L = (LinkList)malloc(sizeof(LNode));	//先建立一个带头结点的单链表
	//L->next = NULL;
	for (int i = 0; i < n; i++)
	{
		LNode *p;
		p = (LNode*)malloc(sizeof(LNode));	//生成新节点
		scanf("%d", &p->data);
		p->next = L->next;					//每次生成的新节点后面接上原来那串结点
		L->next = p;						//建成的新链表接在头结点后面
	}
}//c++头插法建立新表 O(n)
void CreatList_R(LinkList &L, int n){
	//L = (LinkList)malloc(sizeof(LNode));	//先建立一个带头结点的单链表
	//L->next = NULL;
	LNode* rear;
	rear = L;
	for (int i = 0; i < n; i++)
	{
		LNode *p;
		p = (LNode*)malloc(sizeof(LNode));	//生成新节点
		scanf("%d", &p->data);
		p->next = NULL;
		rear->next = p;						//p插入到尾指针rear后面
		rear = p;							//尾指针rear指向p完成尾部更新
	}
}//c++尾插法建立新表 O(n)

//十一，遍历
void PrintList(LinkList L)
{
	LNode*p;
	p = L->next;
	printf("【Head:L】->");
	while (p != NULL)
	{
		printf("【%d】[%p]->", p->data, p->next);
		p = p->next;
	}
	printf("【NULL】");
	printf("\n");
}
void Print(Node*first){
	Node*p = first->next;
	while (p != NULL){
		printf("%d  ", p->data);
		p = p->next;
	}
}
//十二，双链表
typedef struct DuLNode{
	ElemType data;
	struct DuLNode *prior, *next;
}DuLNode, *DuLinkList;

//十三，双链表_初始化（创）
Status InitList_DuL(DuLinkList &L){
	L = (DuLinkList)malloc(sizeof(DuLNode));//1.生成新结点作头结点，用头指针L指向头结点
	//或者L=new LNode;
	L->next = NULL;							//2.将头结点的指针域指向头
	L->prior = NULL;
	return OK;
}

//十四，双链表_取值（创）
DuLNode* LocateElem_DuL(DuLinkList L, int i){
	DuLNode*p;
	p = L->next;
	int count = 1;
	while (p != NULL&&count != i){
		count++;
		p = p->next;
	}
	if (p == NULL || count>i)return ERROR;
	return p;
}//c++按位查找双链表地址

//十五，双链表_插入
Status ListInsert_DuL(DuLinkList &L, int i, ElemType e){
	DuLNode *p;
	p = LocateElem_DuL(L, i);				//查找操作使工作指针p指向所需位置
	if (p == NULL)return ERROR;
	DuLNode *s;
	s = (DuLNode*)malloc(sizeof(DuLNode));
	s->data = e;
	s->prior = p->prior;					//新结点的前驱指向p的前驱（原p结点的前一个结点)
	s->next = p;							//新节点的后继指向p
	p->prior->next = s;						//原p结点的前一个结点的后继改为s
	p->prior = s;							//p结点的前驱改为s
	return OK;
}

//十六，双链表_删除
Status ListDelete_DuL(DuLinkList&L, int i, ElemType &e){
	DuLNode *p;								//查找操作使工作指针p指向所需位置
	p = LocateElem_DuL(L, i);
	if (p == NULL)return ERROR;
	e = p->data;
	p->prior->next = p->next;				//原p结点的前一个结点的后继改为p的next(即原p结点的下一个结点地址)
	p->next->prior = p->prior;				//原p结点的后一个结点的前驱改为p的prior(即原p结点的上一个结点地址）
	free(p);
	return OK;
}

//十七，双链表_尾插（创）
void CreatDuList_R(DuLinkList &L, int n)
{
	//L = (LinkList)malloc(sizeof(LNode));	//先建立一个带头结点的单链表
	//L->next = NULL;
	DuLNode* rear;
	rear = L;
	for (int i = 0; i < n; i++)
	{
		DuLNode *p;
		p = (DuLNode*)malloc(sizeof(DuLNode));	//生成新节点
		scanf("%d", &p->data);
		p->next = NULL;
		p->prior = rear;
		rear->next = p;						//p插入到尾指针rear后面
		rear = p;							//尾指针rear指向p完成尾部更新
	}
}

//十八，遍历双链表（创）
void PrintDuList(DuLinkList L){
	DuLNode* p;
	p = L->next;
	printf("【head:Q】->");
	while (p != NULL){
		printf("[%p]【%d】[%p]->", p->prior, p->data, p->next);
		p = p->next;
	}
	printf("【NULL】\n");
}

//十九，循环链表_初始化（创）
Status InitList_CL(LinkList &L){
	L = (LinkList)malloc(sizeof(LNode));	//1.生成新结点作头结点，用头指针L指向头结点
	//或者L=new LNode;
	L->next = L;							//2.将头结点的指针域指向头
	return OK;
} 

//二十，合并有序表
void Combine_ordered(LinkList &La,LinkList &Lb,LinkList &Lc){
	LNode*pa = La->next;
	LNode*pb = Lb->next;
	LNode*pc = Lc = La;						//用La的头结点作为Lc的头结点
	while (pa != NULL&&pb != NULL){
		if (pa->data <= pb->data){
			pc->next = pa;
			pc = pa;
			pa = pa->next;
		}
		else{
			pc->next = pb;
			pc = pb;
			pb = pb->next;
		}
	}
	pc->next = pa ? pa : pb;				//插入剩余段
	free(Lb);
}
int main()
{
	LinkList L;
	printf("————执行初始化表：————\n");
	InitList_L(L);
	//建表
	printf("————执行尾插建表：————\n");
	int length = 0;
	printf("The length you wanna: ");
	scanf("%d", &length);
	printf("Enter data:\n");
	CreatList_R(L, length);
	PrintList(L);
	//建表
	printf("————执行头插建表：————\n");
	printf("The length you wanna: ");
	scanf("%d", &length);
	printf("Enter data:\n");
	CreatList_H(L, length);
	PrintList(L);
	//插人
	printf("————执行在n位插入【data】：————\n");
	int location = 0;
	printf("The location you wanna to insert: ");
	scanf("%d", &location);
	int data = 0;
	printf("The data you wanna to insert: ");
	scanf("%d", &data);
	ListInsert_L(L, location, data);
	PrintList(L);
	//表长
	printf("————执行求表长：————\n");
	int ListLength;
	ListLength = ListLength_L(L);
	printf("当前表长为：%d\n", ListLength);
	//删除
	printf("————执行在n位次删除：————\n");
	ElemType delet;
	printf("The location you wanna to delet: ");
	scanf("%d", &location);
	ListDelete_L(L, location, delet);
	PrintList(L);
	printf("which data is delet:【%d】\n", delet);
	//查找
	printf("————执行按值查找：————\n");
	ElemType search;
	int search_for;
	printf("what data you wanna to search?:");
	scanf("%d", &search);
	search_for = LocateEle_L(L, search);
	printf("this data is in [第%d位]\n", search_for);
	//取值
	printf("————执行按位取值：————\n");
	int number;
	int number_for;
	printf("what location number you wanna to check?:");
	scanf("%d", &number);
	GetElem_L(L, number, number_for);
	printf("you wanna data is 【%d】\n", number_for);
	//清空
	printf("————执行清空链表：————\n");
	ClearList(L);
	PrintList(L);
	//判空
	printf("————执行判空链表：————\n");
	ListEmpty(L);
	if (ListEmpty(L)) 
		printf("链表为空\n");
	else
		printf("链表非空\n");
	//销毁
	printf("————执行销毁链表：————\n");
	ClearList(L);

	//双链表部分
	DuLinkList Q;
	printf("————执行初始化双链表：————\n");
	InitList_DuL(Q);
	//建表
	printf("————执行头插建双链表：————\n");
	printf("please enter three data to creat DuList:\n");
	CreatDuList_R(Q, 3);
	PrintDuList(Q);
	//插入
	printf("————执行双链表按位插入数据：————\n");
	ElemType Insert_Data = 0;
	int Du_Location = 0;
	printf("The location you wanna to insert: ");
	scanf("%d", &Du_Location);
	printf("The data you wanna to insert: ");
	scanf("%d", &Insert_Data);
	ListInsert_DuL(Q, Du_Location, Insert_Data);
	PrintDuList(Q);
	//删除
	printf("————执行双链表按位删除数据：————\n");
	printf("The location you wanna to delet: ");
	scanf("%d", &Du_Location);
	ElemType Delete_Data = 0;
	ListDelete_DuL(Q, Du_Location, Delete_Data);
	PrintDuList(Q);
	printf("which data you delete:【%d】\n", Delete_Data);

	//合并部分
	printf("————执行合并有序链表：————\n");
	LinkList La, Lb, Lc;
	InitList_L(La);
	InitList_L(Lb);
	printf("输入三个有序数据创建链表La：\n");
	CreatList_R(La, 3);
	PrintList(La);
	printf("输入两个有序数据创建链表Lb：\n");
	CreatList_R(Lb, 2);
	PrintList(Lb);
	Combine_ordered(La, Lb, Lc);
	printf("合并为新的有序表Lc：\n");
	PrintList(Lc);
	return 0;
}
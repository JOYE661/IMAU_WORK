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
//������ͼ�⣺ͷָ��L->[ͷ���][next]->[��Ԫ���a1][next]->[a2][next]->

//typedef struct{
//	char num[8];
//	char name[8];
//	int score;
//}ElemType;				//ѧ��ѧ�š��������ɼ���ϵͳ�ܿ�ģ��

//������1.
typedef struct LNode{						//��LnodeΪ�˷�������ָ��ýṹ���ָ������
	ElemType data;							//���������
	struct LNode *next;						//���ָ����
}LNode, *LinkList;							//LnodeΪ�����Ľṹ�壬LinkListΪ�����ĸýṹ��ָ��
											//���Ϊ��������LinkLsit L; ������ָ�룺LNode *p <=> LinkList p;
											//����Ϊͬ�����ͣ�ֻ������������������������ָ��ͽ��ָ��
//������2.
typedef struct Node{
	ElemType data;
	struct Node *next;
}Node;

//һ����ʼ��
Status InitList_L(LinkList &L){
	L = (LinkList)malloc(sizeof(LNode));	//1.�����½����ͷ��㣬��ͷָ��Lָ��ͷ���
	//����L=new LNode;
	L->next = NULL;							//2.��ͷ����ָ�����ÿ�
	return OK;
}//c++������ĳ�ʼ��
Node *InitList(){
	Node*first = (Node*)malloc(sizeof(Node));
	first->next = NULL;
	return first;
}

//�����п�
int ListEmpty(LinkList L){					//1.��LΪ�ձ��򷵻�1�����򷵻�0
	if (L->next)//�ǿ�
		return 0;
	else
		return 1;
}//c++�������п�
int Empty(Node*first){
	if (first->next == NULL)
		return 1;
	else
		return 0;
}

//��������
Status DestoryList_L(LinkList &L){			//ɾ������ͷ���
	LNode *p;								//1.��������ָ��p��Ŀ�ķ���ɾ�����
	while (L != NULL){						//2.һֱִ��ɾ����ֱ��Lͷָ��ָ���
		p = L;								//3.pָ�뿽��Lͷָ�루��Ϊͷ��㴦������һ����㴦��
		L = L->next;						//4.Lָ��ָ����һ�����ĵ�ַ
		free(p);							//5.����ָ��ɾ�����
		//����delete p;
	}
	return OK;
}//c++���ٵ�����

//�ģ����
Status ClearList(LinkList &L){				//ɾ����ͷ���Ľ��
	LNode *p, *q;							//1.��������ָ��p�Ϳ���ָ��q,pɾ���ڵ�,q�ṩ��һ�����λ��
	p = L->next;							//2.p������Ԫָ���ַ
	while (p != NULL){						//3.һֱִ��ɾ����ֱ��p��q��
		q = p->next;						//4.qָ��������һ�����
		free(p);							//5.pָ��ɰ�ȫɾ����ָ����	
		p = q;								//6.ɾ��������pָ������q,����һ�����
	}
	L->next = NULL;							//7.��ս�����ͷ���ָ����Ϊ�գ���ʼ��ͷ���
	return OK;
}//c++��յ�����

//�壬��
int ListLength_L(LinkList L){				//����L��Ԫ�صĸ���
	LinkList p;
	p = L->next;							//1.pָ����Ԫ���ĵ�ַ
	int count = 0;							//2.����������count
	while (p != NULL){						//3.ִ�м���ֱ��pΪ��
		count++;
		p = p->next;						//4.p������һ�����ĵ�ַ
	}
	return count;
}//c++�������
int Length(Node*first){
	Node*p = first->next;
	int count = 0;
	while (p != NULL){
		count++;
		p = p->next;
	}
	return count;
}

//����ȡֵ*
Status GetElem_L(LinkList L, int i, ElemType &e){
	LNode*p;
	p = L->next;							//1.pָ����Ԫ���ĵ�ַ
	int count = 1;							//2.����������count
	while (p != NULL&&count < i){			//3.ִ�м���ֱ��pΪ�ջ������������ʱ��������
		count++;
		p = p->next;						//4.p������һ�����ĵ�ַ
	}
	if (p == NULL || count>i)return ERROR;	//5.pΪ�ջ�������������Ҳ�����
	e = p->data;							//6.��e���������ҵ�����
	return OK;
}//c++��λ��������ֵ
int Get(Node*first, int i, ElemType*ptr){
	Node*p = first->next;
	int count = 1;
	while (p != NULL&&count < i){
		count++;
		p = p->next;
	}
	if (p = NULL){
		printf("λ�ô��󣬲���ʧ��\n");
		return 0;
	}
	else{
		*ptr = p->data;
		return 1;
	}
}//c��λ����

//�ߣ�����*
LNode* LocateElem_L(LinkList L, ElemType e)	//����ֵ���ҵ�ַ
{
	LNode*p;
	p = L->next;							//1.pָ����Ԫ���ĵ�ַ
	while (p != NULL&&p->data != e)			//2.ִ�м���ֱ��pΪ�ջ���������ʱ
	{
		p = p->next;						//3.p������һ�����ĵ�ַ
	}
	return p;
}//c++��ֵ���ҵ�ַ O(n)
int LocateEle_L(LinkList L, ElemType e)		//����ֵ����λ��
{
	LNode*p;
	p = L->next;							//1.pָ����Ԫ���ĵ�ַ
	int count = 1;							//2.����������count
	while (p != NULL&&p->data != e)			//3.ִ�м���ֱ��pΪ�ջ���������ʱ
	{
		p = p->next;						//4.p������һ�����ĵ�ַ
		count++;
	}
	if (p != NULL)							//5.���ҳɹ�
		return count;
	else									//6.����ʧ��
		return 0;
}//c++��ֵ����λ�� O(n)
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
//�ˣ����� 
Status ListInsert_L(LinkList &L, int i, ElemType e)
{
	LNode*p;
	p = L;
	int count = 0;
	while (p != NULL&&count < i - 1){		//i-1����˼��ѭ��ֱ���������λ�ε�ǰһλ
		p = p->next;
		count++;
	}										//Ѱ�ҵ�i-1����㣬pָ��i-1���
	if (p == NULL || count>i - 1)
		return ERROR;						//i���ڱ�+1����С��1������λ�÷Ƿ�
	LNode*s;
	s = (LNode*)malloc(sizeof(LNode));
	s->data = e;							//����һ���½�㣬sΪ�ý��ָ�룬������Ϊe
	s->next = p->next;						//s��next�������һ����㱾Ӧ��ָ��ĵ�ַ
	p->next = s;							//��һ������next�������������½���ַ
	return OK;
}//c++��λ�����½ڵ� O(n)
int Insert(Node*first, int i, ElemType x){
	Node*s = NULL, *p = first;
	int count = 0;
	while (p != NULL&&count < i - 1){
		p = p->next;
		count++;
	}
	if (p == NULL){
		printf("λ�ô��󣬲���ʧ��\n");
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
//�ţ�ɾ��
Status ListDelete_L(LinkList &L, int i, ElemType &e)
{
	LNode*p;
	p = L;
	int count = 0;
	while (p != NULL&&count < i - 1){		//i-1����˼��ѭ��ֱ���������λ�ε�ǰһλ
		p = p->next;
		count++;
	}										//Ѱ�ҵ�i-1����㣬pָ��i-1���
	if (p == NULL || count>i - 1)
		return ERROR;						//i���ڱ�+1����С��1������λ�÷Ƿ�
	LNode* q;
	q = p->next;							//qָ����Ҫɾ���Ľ��
	p->next = q->next;						//p��next������q���ָ��q��next��
	e = q->data;							//������ɾ��������
	free(q);
	return OK;
}//c++ɾ��ָ��λ�ڵ� O(n)

//ʮ������
void CreatList_H(LinkList &L, int n){
	//L = (LinkList)malloc(sizeof(LNode));	//�Ƚ���һ����ͷ���ĵ�����
	//L->next = NULL;
	for (int i = 0; i < n; i++)
	{
		LNode *p;
		p = (LNode*)malloc(sizeof(LNode));	//�����½ڵ�
		scanf("%d", &p->data);
		p->next = L->next;					//ÿ�����ɵ��½ڵ�������ԭ���Ǵ����
		L->next = p;						//���ɵ����������ͷ������
	}
}//c++ͷ�巨�����±� O(n)
void CreatList_R(LinkList &L, int n){
	//L = (LinkList)malloc(sizeof(LNode));	//�Ƚ���һ����ͷ���ĵ�����
	//L->next = NULL;
	LNode* rear;
	rear = L;
	for (int i = 0; i < n; i++)
	{
		LNode *p;
		p = (LNode*)malloc(sizeof(LNode));	//�����½ڵ�
		scanf("%d", &p->data);
		p->next = NULL;
		rear->next = p;						//p���뵽βָ��rear����
		rear = p;							//βָ��rearָ��p���β������
	}
}//c++β�巨�����±� O(n)

//ʮһ������
void PrintList(LinkList L)
{
	LNode*p;
	p = L->next;
	printf("��Head:L��->");
	while (p != NULL)
	{
		printf("��%d��[%p]->", p->data, p->next);
		p = p->next;
	}
	printf("��NULL��");
	printf("\n");
}
void Print(Node*first){
	Node*p = first->next;
	while (p != NULL){
		printf("%d  ", p->data);
		p = p->next;
	}
}
//ʮ����˫����
typedef struct DuLNode{
	ElemType data;
	struct DuLNode *prior, *next;
}DuLNode, *DuLinkList;

//ʮ����˫����_��ʼ��������
Status InitList_DuL(DuLinkList &L){
	L = (DuLinkList)malloc(sizeof(DuLNode));//1.�����½����ͷ��㣬��ͷָ��Lָ��ͷ���
	//����L=new LNode;
	L->next = NULL;							//2.��ͷ����ָ����ָ��ͷ
	L->prior = NULL;
	return OK;
}

//ʮ�ģ�˫����_ȡֵ������
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
}//c++��λ����˫�����ַ

//ʮ�壬˫����_����
Status ListInsert_DuL(DuLinkList &L, int i, ElemType e){
	DuLNode *p;
	p = LocateElem_DuL(L, i);				//���Ҳ���ʹ����ָ��pָ������λ��
	if (p == NULL)return ERROR;
	DuLNode *s;
	s = (DuLNode*)malloc(sizeof(DuLNode));
	s->data = e;
	s->prior = p->prior;					//�½���ǰ��ָ��p��ǰ����ԭp����ǰһ�����)
	s->next = p;							//�½ڵ�ĺ��ָ��p
	p->prior->next = s;						//ԭp����ǰһ�����ĺ�̸�Ϊs
	p->prior = s;							//p����ǰ����Ϊs
	return OK;
}

//ʮ����˫����_ɾ��
Status ListDelete_DuL(DuLinkList&L, int i, ElemType &e){
	DuLNode *p;								//���Ҳ���ʹ����ָ��pָ������λ��
	p = LocateElem_DuL(L, i);
	if (p == NULL)return ERROR;
	e = p->data;
	p->prior->next = p->next;				//ԭp����ǰһ�����ĺ�̸�Ϊp��next(��ԭp������һ������ַ)
	p->next->prior = p->prior;				//ԭp���ĺ�һ������ǰ����Ϊp��prior(��ԭp������һ������ַ��
	free(p);
	return OK;
}

//ʮ�ߣ�˫����_β�壨����
void CreatDuList_R(DuLinkList &L, int n)
{
	//L = (LinkList)malloc(sizeof(LNode));	//�Ƚ���һ����ͷ���ĵ�����
	//L->next = NULL;
	DuLNode* rear;
	rear = L;
	for (int i = 0; i < n; i++)
	{
		DuLNode *p;
		p = (DuLNode*)malloc(sizeof(DuLNode));	//�����½ڵ�
		scanf("%d", &p->data);
		p->next = NULL;
		p->prior = rear;
		rear->next = p;						//p���뵽βָ��rear����
		rear = p;							//βָ��rearָ��p���β������
	}
}

//ʮ�ˣ�����˫��������
void PrintDuList(DuLinkList L){
	DuLNode* p;
	p = L->next;
	printf("��head:Q��->");
	while (p != NULL){
		printf("[%p]��%d��[%p]->", p->prior, p->data, p->next);
		p = p->next;
	}
	printf("��NULL��\n");
}

//ʮ�ţ�ѭ������_��ʼ��������
Status InitList_CL(LinkList &L){
	L = (LinkList)malloc(sizeof(LNode));	//1.�����½����ͷ��㣬��ͷָ��Lָ��ͷ���
	//����L=new LNode;
	L->next = L;							//2.��ͷ����ָ����ָ��ͷ
	return OK;
} 

//��ʮ���ϲ������
void Combine_ordered(LinkList &La,LinkList &Lb,LinkList &Lc){
	LNode*pa = La->next;
	LNode*pb = Lb->next;
	LNode*pc = Lc = La;						//��La��ͷ�����ΪLc��ͷ���
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
	pc->next = pa ? pa : pb;				//����ʣ���
	free(Lb);
}
int main()
{
	LinkList L;
	printf("��������ִ�г�ʼ������������\n");
	InitList_L(L);
	//����
	printf("��������ִ��β�彨����������\n");
	int length = 0;
	printf("The length you wanna: ");
	scanf("%d", &length);
	printf("Enter data:\n");
	CreatList_R(L, length);
	PrintList(L);
	//����
	printf("��������ִ��ͷ�彨����������\n");
	printf("The length you wanna: ");
	scanf("%d", &length);
	printf("Enter data:\n");
	CreatList_H(L, length);
	PrintList(L);
	//����
	printf("��������ִ����nλ���롾data������������\n");
	int location = 0;
	printf("The location you wanna to insert: ");
	scanf("%d", &location);
	int data = 0;
	printf("The data you wanna to insert: ");
	scanf("%d", &data);
	ListInsert_L(L, location, data);
	PrintList(L);
	//��
	printf("��������ִ���������������\n");
	int ListLength;
	ListLength = ListLength_L(L);
	printf("��ǰ��Ϊ��%d\n", ListLength);
	//ɾ��
	printf("��������ִ����nλ��ɾ������������\n");
	ElemType delet;
	printf("The location you wanna to delet: ");
	scanf("%d", &location);
	ListDelete_L(L, location, delet);
	PrintList(L);
	printf("which data is delet:��%d��\n", delet);
	//����
	printf("��������ִ�а�ֵ���ң���������\n");
	ElemType search;
	int search_for;
	printf("what data you wanna to search?:");
	scanf("%d", &search);
	search_for = LocateEle_L(L, search);
	printf("this data is in [��%dλ]\n", search_for);
	//ȡֵ
	printf("��������ִ�а�λȡֵ����������\n");
	int number;
	int number_for;
	printf("what location number you wanna to check?:");
	scanf("%d", &number);
	GetElem_L(L, number, number_for);
	printf("you wanna data is ��%d��\n", number_for);
	//���
	printf("��������ִ�����������������\n");
	ClearList(L);
	PrintList(L);
	//�п�
	printf("��������ִ���п�������������\n");
	ListEmpty(L);
	if (ListEmpty(L)) 
		printf("����Ϊ��\n");
	else
		printf("����ǿ�\n");
	//����
	printf("��������ִ������������������\n");
	ClearList(L);

	//˫������
	DuLinkList Q;
	printf("��������ִ�г�ʼ��˫������������\n");
	InitList_DuL(Q);
	//����
	printf("��������ִ��ͷ�彨˫������������\n");
	printf("please enter three data to creat DuList:\n");
	CreatDuList_R(Q, 3);
	PrintDuList(Q);
	//����
	printf("��������ִ��˫����λ�������ݣ���������\n");
	ElemType Insert_Data = 0;
	int Du_Location = 0;
	printf("The location you wanna to insert: ");
	scanf("%d", &Du_Location);
	printf("The data you wanna to insert: ");
	scanf("%d", &Insert_Data);
	ListInsert_DuL(Q, Du_Location, Insert_Data);
	PrintDuList(Q);
	//ɾ��
	printf("��������ִ��˫����λɾ�����ݣ���������\n");
	printf("The location you wanna to delet: ");
	scanf("%d", &Du_Location);
	ElemType Delete_Data = 0;
	ListDelete_DuL(Q, Du_Location, Delete_Data);
	PrintDuList(Q);
	printf("which data you delete:��%d��\n", Delete_Data);

	//�ϲ�����
	printf("��������ִ�кϲ�����������������\n");
	LinkList La, Lb, Lc;
	InitList_L(La);
	InitList_L(Lb);
	printf("���������������ݴ�������La��\n");
	CreatList_R(La, 3);
	PrintList(La);
	printf("���������������ݴ�������Lb��\n");
	CreatList_R(Lb, 2);
	PrintList(Lb);
	Combine_ordered(La, Lb, Lc);
	printf("�ϲ�Ϊ�µ������Lc��\n");
	PrintList(Lc);
	return 0;
}
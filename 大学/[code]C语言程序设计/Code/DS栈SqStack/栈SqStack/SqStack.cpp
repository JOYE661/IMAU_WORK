#define _CRT_SECURE_NO_WARNINGS 1
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define INFEASIBLE -1
#define OVERFLOW -2
typedef int Status;
typedef int SElemType;
#include<stdio.h>
#include<stdlib.h>
#include<iostream>
using namespace std;
//˳��ջ(c++)��������������������������������������������������������������������������������������������������������������������������������������������������������������
#define MAXSIZE 100
typedef struct{
	SElemType *base;		//ջ��ָ��
	SElemType *top;			//ջ��ָ��(�����ݸ���һλ��
	int stacksize;			//ջ�����������
}SqStack;
//һ����ʼ
Status InitStack(SqStack &S){				//1.c++˳��ջ
	S.base = (SElemType*)malloc(sizeof(SElemType)*MAXSIZE);
	if (S.base == NULL)exit(OVERFLOW);
	S.top = S.base;
	S.stacksize = MAXSIZE;
	return OK;
}
//�����п�
Status StackEmpt(SqStack S){				//1.c++˳��ջ
	if (S.top == S.base)
		return TRUE;
	else
		return FALSE;
}
//������
int StackLength(SqStack S){					//c++˳��ջ
	return S.top - S.base;
}
//�ģ����
Status ClearStack(SqStack &S){				//c++˳��ջ
	if (S.base != NULL)
		S.top = S.base;
	return OK;
}
//�壬����
Status DestroyStack(SqStack &S){			//c++˳��ջ
	if (S.base != NULL){
		free(S.base);
		S.stacksize = 0;
		S.base = S.top = NULL;
	}
	return OK;
}
//������ջ
Status Push(SqStack &S, SElemType e){		//1.c++˳��ջ
	if (S.top - S.base == S.stacksize)//ջ��
		return ERROR;
	*S.top = e;
	S.top++;
	return OK;
}
//�ߣ���ջ
Status Pop(SqStack &S, SElemType &e){		//1.c++˳��ջ
	if (S.top == S.base)
		return ERROR;
	(S.top)--;
	e = *(S.top);
	return OK;
}
//�ˣ�ȡ��
SElemType GetTop_SqStack(SqStack &S){
	return *S.top - 1;
}
//�ţ�����
void Print_SqStack(SqStack &S){
	printf("˳��ջ�ṹ��");
	SElemType*p = S.base;
	for (int i = 0; i < S.top - S.base; i++){
		printf("[%d]", *p);
		p++;
	}
	printf("\n");
}
//˳��ջ(c���ԣ���������������������������������������������������������������������������������������������������������������������������������������������������������������
#define StackSize 100
typedef struct{
	SElemType data[StackSize];
	int top;
}SeqStack;
//һ����ʼ
void InitSeqStack(SeqStack *S){				//2.c˳��ջ
	S->top = 0;
}
//�����п�
int Empty(SeqStack*S){						//2.c˳��ջ
	if (S->top == -1)
		return 1;
	else
		return 0;
}
//������
//�ģ����
//�壬����
void DestroySeqStack(SeqStack *S){
	S->top = 0;
}
//������ջ
int push(SeqStack*S, SElemType x){			//2.c˳��ջ
	if (S->top == StackSize - 1){
		printf("������󣬲���ʧ��\n");
		return 0;
	}
	S->data[S->top] = x;
	S->top++;
	return 1;
}
//�ߣ���ջ
int pop(SeqStack*S, SElemType *ptr){		//2.c˳��ջ
	if (S->top == -1){
		printf("�������,ɾ��ʧ��\n");
		return 0;
	}
	*ptr = S->data[S->top - 1];
	S->top--;
	return 1;
}
//�ˣ�ȡ��
SElemType GetTop_SeqStack(SeqStack *S){
	return S->data[S->top - 1];
}
//�ţ�����
void Print_SeqStack(SeqStack *S){
	printf("˳��ջ�ṹ��");
	int j = S->top;
	for (int i = 0; i < j; i++){
		printf("[%d]", S->data[i]);
	}
	printf("\n");
}
//��ջ(c++)(����ͷ���)��������������������������������������������������������������������������������������������������������������������������������������������������������������
typedef struct StackNode{
	SElemType data;
	struct StackNode*next;	//nextΪ���¼�ͷ
}StackNode, *LinkStack;
//һ����ʼ
Status InitLinkStack(LinkStack &S){			//3.c++��ջ
	S = NULL;
	return OK;
}
//�����п�
Status LinkStackEmpty(LinkStack S){			//3.c++��ջ

	if (S == NULL)
		return TRUE;
	else
		return FALSE;
}
//������
//�ģ����
void CleatLinkStack(LinkStack &S){
	if (S->next = NULL){
		printf("ջ��\n");
	}
	LinkStack q, p;
	p = S->next;
	while (p != NULL){
		q = p;
		free(q);
		p = p->next;
	}
	S->data = 0;
	S->next = NULL;
}
//�壬����
Status DestroyLinkStack(LinkStack &S){
	LinkStack p;
	while (S != NULL){
		p = S;
		S = S->next;
		free(p);
	}
	return OK;
}
//������ջ
Status PushLink(LinkStack &S, SElemType e){	//3.c++��ջ
	StackNode*p;
	p = (LinkStack)malloc(sizeof(StackNode));	//�����½��
	p->data = e;								//�½��������Ϊe
	p->next = S;								//������ջ��S�ĺ���
	S = p;										//ջ��S����
	return OK;
}
//�ߣ���ջ
Status LinkPop(LinkStack &S, SElemType &e){	 //3.c++��ջ
	StackNode*p;
	if (S == NULL)return ERROR;
	e = S->data;
	p = S;
	S = S->next;
	free(p);
	return OK;
}
//�ˣ�ȡ��
SElemType GetTop_Link(LinkStack S){
	if (S != NULL)
		return S->data;
}
//�ţ�����
void Print_LinkStack(LinkStack &S){
	printf("��ջ�ṹ��\n");
	StackNode* p;
	p = S;
	while (p != NULL){
		printf("%d->\n", p->data);
		p = p->next;
	}
}
//��ջ(c����)(��ͷ���)��������������������������������������������������������������������������������������������������������������������������������������������������������������
//��ջ2.
typedef struct Node{
	SElemType data;
	struct Node*next;
}Node;
//һ����ʼ
void InitLink(Node *top){					//3.c++��ջ
	top = (Node*)malloc(sizeof(Node));
	top->next = NULL;
	top->data = 0;
}
//�����п�
//������
//�ģ����
//�壬����
//������ջ
void pushlink(Node*top, SElemType x){		//4.c��ջ
	Node*s = (Node*)malloc(sizeof(Node));
	s->data = x;
	s->next = top->next;
	top->next = s;
}
//�ߣ���ջ
int linkpop(Node *top, SElemType *ptr){		//4.c��ջ
	Node*p = top->next;
	if (top == NULL){
		printf("�������,ɾ��ʧ��\n");
		return 0;
	}
	*ptr = p->data;
	top->next = p->next;
	free(p);
	return 1;
}
//�ˣ�ȡ��
//�ţ�����
void Print_Link(Node *S){
	printf("��ջ�ṹ��\n");
	Node* p;
	p = S;
	while (p != NULL){
		p = p->next;
		printf("%d->\n", p->data);
		
	}
}
//��������������������������������������������������������������������������������������������������������������������������������������������������������������
int main(){
	SqStack s;
	InitStack(s);
	Push(s, 1);
	Push(s, 2);
	Push(s, 3);
	Print_SqStack(s);
	SElemType e;
	Pop(s, e);
	printf("��������Ϊ[%d]\n", e);
	Print_SqStack(s);
	printf("��ǰջ��Ϊ[%d]\n", GetTop_SqStack(s));
	ClearStack(s);
	DestroyStack(s);

	SeqStack Seq;
	InitSeqStack(&Seq);
	push(&Seq, 4);
	push(&Seq, 5);
	push(&Seq, 6);
	Print_SeqStack(&Seq);
	SElemType ptr;
	pop(&Seq, &ptr);
	printf("��������Ϊ[%d]\n", ptr);
	Print_SeqStack(&Seq);
	printf("��ǰջ��Ϊ[%d]\n", GetTop_SeqStack(&Seq));
	DestroySeqStack(&Seq);

	LinkStack Ls;
	InitLinkStack(Ls);
	PushLink(Ls, 7);
	PushLink(Ls, 8);
	PushLink(Ls, 9);
	Print_LinkStack(Ls);
	SElemType E;
	LinkPop(Ls, E);
	printf("��������Ϊ[%d]\n", E);
	Print_LinkStack(Ls);
	printf("��ǰջ��Ϊ[%d]\n", GetTop_Link(Ls));
	CleatLinkStack(Ls);
	DestroyLinkStack(Ls);

	Node L;
	InitLink(&L);
	pushlink(&L, 10);
	pushlink(&L, 11);
	pushlink(&L, 12);
	Print_Link(&L);
	return 0;
}
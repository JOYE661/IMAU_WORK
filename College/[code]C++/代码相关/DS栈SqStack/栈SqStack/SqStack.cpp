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
//顺序栈(c++)———————————————————————————————————————————————————————————————————————————————
#define MAXSIZE 100
typedef struct{
	SElemType *base;		//栈底指针
	SElemType *top;			//栈顶指针(在数据更上一位）
	int stacksize;			//栈可用最大容量
}SqStack;
//一，初始
Status InitStack(SqStack &S){				//1.c++顺序栈
	S.base = (SElemType*)malloc(sizeof(SElemType)*MAXSIZE);
	if (S.base == NULL)exit(OVERFLOW);
	S.top = S.base;
	S.stacksize = MAXSIZE;
	return OK;
}
//二，判空
Status StackEmpt(SqStack S){				//1.c++顺序栈
	if (S.top == S.base)
		return TRUE;
	else
		return FALSE;
}
//三，求长
int StackLength(SqStack S){					//c++顺序栈
	return S.top - S.base;
}
//四，清空
Status ClearStack(SqStack &S){				//c++顺序栈
	if (S.base != NULL)
		S.top = S.base;
	return OK;
}
//五，销毁
Status DestroyStack(SqStack &S){			//c++顺序栈
	if (S.base != NULL){
		free(S.base);
		S.stacksize = 0;
		S.base = S.top = NULL;
	}
	return OK;
}
//六，入栈
Status Push(SqStack &S, SElemType e){		//1.c++顺序栈
	if (S.top - S.base == S.stacksize)//栈满
		return ERROR;
	*S.top = e;
	S.top++;
	return OK;
}
//七，出栈
Status Pop(SqStack &S, SElemType &e){		//1.c++顺序栈
	if (S.top == S.base)
		return ERROR;
	(S.top)--;
	e = *(S.top);
	return OK;
}
//八，取顶
SElemType GetTop_SqStack(SqStack &S){
	return *S.top - 1;
}
//九，遍历
void Print_SqStack(SqStack &S){
	printf("顺序栈结构：");
	SElemType*p = S.base;
	for (int i = 0; i < S.top - S.base; i++){
		printf("[%d]", *p);
		p++;
	}
	printf("\n");
}
//顺序栈(c语言）———————————————————————————————————————————————————————————————————————————————
#define StackSize 100
typedef struct{
	SElemType data[StackSize];
	int top;
}SeqStack;
//一，初始
void InitSeqStack(SeqStack *S){				//2.c顺序栈
	S->top = 0;
}
//二，判空
int Empty(SeqStack*S){						//2.c顺序栈
	if (S->top == -1)
		return 1;
	else
		return 0;
}
//三，求长
//四，清空
//五，销毁
void DestroySeqStack(SeqStack *S){
	S->top = 0;
}
//六，入栈
int push(SeqStack*S, SElemType x){			//2.c顺序栈
	if (S->top == StackSize - 1){
		printf("上溢错误，插入失败\n");
		return 0;
	}
	S->data[S->top] = x;
	S->top++;
	return 1;
}
//七，出栈
int pop(SeqStack*S, SElemType *ptr){		//2.c顺序栈
	if (S->top == -1){
		printf("下溢错误,删除失败\n");
		return 0;
	}
	*ptr = S->data[S->top - 1];
	S->top--;
	return 1;
}
//八，取顶
SElemType GetTop_SeqStack(SeqStack *S){
	return S->data[S->top - 1];
}
//九，遍历
void Print_SeqStack(SeqStack *S){
	printf("顺序栈结构：");
	int j = S->top;
	for (int i = 0; i < j; i++){
		printf("[%d]", S->data[i]);
	}
	printf("\n");
}
//链栈(c++)(不带头结点)———————————————————————————————————————————————————————————————————————————————
typedef struct StackNode{
	SElemType data;
	struct StackNode*next;	//next为向下箭头
}StackNode, *LinkStack;
//一，初始
Status InitLinkStack(LinkStack &S){			//3.c++链栈
	S = NULL;
	return OK;
}
//二，判空
Status LinkStackEmpty(LinkStack S){			//3.c++链栈

	if (S == NULL)
		return TRUE;
	else
		return FALSE;
}
//三，求长
//四，清空
void CleatLinkStack(LinkStack &S){
	if (S->next = NULL){
		printf("栈空\n");
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
//五，销毁
Status DestroyLinkStack(LinkStack &S){
	LinkStack p;
	while (S != NULL){
		p = S;
		S = S->next;
		free(p);
	}
	return OK;
}
//六，入栈
Status PushLink(LinkStack &S, SElemType e){	//3.c++链栈
	StackNode*p;
	p = (LinkStack)malloc(sizeof(StackNode));	//生成新结点
	p->data = e;								//新结点数据域为e
	p->next = S;								//结点接在栈顶S的后面
	S = p;										//栈顶S上移
	return OK;
}
//七，出栈
Status LinkPop(LinkStack &S, SElemType &e){	 //3.c++链栈
	StackNode*p;
	if (S == NULL)return ERROR;
	e = S->data;
	p = S;
	S = S->next;
	free(p);
	return OK;
}
//八，取顶
SElemType GetTop_Link(LinkStack S){
	if (S != NULL)
		return S->data;
}
//九，遍历
void Print_LinkStack(LinkStack &S){
	printf("链栈结构：\n");
	StackNode* p;
	p = S;
	while (p != NULL){
		printf("%d->\n", p->data);
		p = p->next;
	}
}
//链栈(c语言)(带头结点)———————————————————————————————————————————————————————————————————————————————
//链栈2.
typedef struct Node{
	SElemType data;
	struct Node*next;
}Node;
//一，初始
void InitLink(Node *top){					//3.c++链栈
	top = (Node*)malloc(sizeof(Node));
	top->next = NULL;
	top->data = 0;
}
//二，判空
//三，求长
//四，清空
//五，销毁
//六，入栈
void pushlink(Node*top, SElemType x){		//4.c链栈
	Node*s = (Node*)malloc(sizeof(Node));
	s->data = x;
	s->next = top->next;
	top->next = s;
}
//七，出栈
int linkpop(Node *top, SElemType *ptr){		//4.c链栈
	Node*p = top->next;
	if (top == NULL){
		printf("下溢错误,删除失败\n");
		return 0;
	}
	*ptr = p->data;
	top->next = p->next;
	free(p);
	return 1;
}
//八，取顶
//九，遍历
void Print_Link(Node *S){
	printf("链栈结构：\n");
	Node* p;
	p = S;
	while (p != NULL){
		p = p->next;
		printf("%d->\n", p->data);
		
	}
}
//———————————————————————————————————————————————————————————————————————————————
int main(){
	SqStack s;
	InitStack(s);
	Push(s, 1);
	Push(s, 2);
	Push(s, 3);
	Print_SqStack(s);
	SElemType e;
	Pop(s, e);
	printf("弹出数据为[%d]\n", e);
	Print_SqStack(s);
	printf("当前栈顶为[%d]\n", GetTop_SqStack(s));
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
	printf("弹出数据为[%d]\n", ptr);
	Print_SeqStack(&Seq);
	printf("当前栈顶为[%d]\n", GetTop_SeqStack(&Seq));
	DestroySeqStack(&Seq);

	LinkStack Ls;
	InitLinkStack(Ls);
	PushLink(Ls, 7);
	PushLink(Ls, 8);
	PushLink(Ls, 9);
	Print_LinkStack(Ls);
	SElemType E;
	LinkPop(Ls, E);
	printf("弹出数据为[%d]\n", E);
	Print_LinkStack(Ls);
	printf("当前栈顶为[%d]\n", GetTop_Link(Ls));
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
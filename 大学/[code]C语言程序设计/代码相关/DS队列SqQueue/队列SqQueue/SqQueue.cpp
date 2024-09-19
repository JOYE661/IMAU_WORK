#define _CRT_SECURE_NO_WARNINGS 1
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define INFEASIBLE -1
#define OVERFLOW -2
typedef int Status;
typedef int QElemType;
#include<stdio.h>
#include<stdlib.h>
#include<iostream>
using namespace std;

#define MAXQSIZE 100
//顺序队列———————————————————————————————————————————————————————————————————————————————
typedef struct{
	QElemType *base;
	int front;
	int rear;
}SqQueue;

//一，初始
Status InitQueue(SqQueue &Q){
	Q.base = (QElemType*)malloc(MAXQSIZE*sizeof(QElemType));//分配空间
	if (Q.base==NULL)exit(OVERFLOW);						//分配失败
	Q.front = Q.rear = 0;									//头尾指针为0，队空
	return OK;
}

//二，求长
int QueueLength(SqQueue Q){
	return ((Q.rear - Q.front + MAXQSIZE) % MAXQSIZE);		//尾指针可能为前置
}

//三，入队
Status EnQueue(SqQueue &Q, QElemType e){
	if ((Q.rear + 1) % MAXQSIZE == Q.front)return ERROR;	//队满
	Q.base[Q.rear] = e;										//入队
	Q.rear = (Q.rear + 1) % MAXQSIZE;						//队尾加1
	return OK;
}

//四，出队
Status DeQueue(SqQueue &Q, QElemType &e){
	if (Q.front == Q.rear)return ERROR;						//队空
	e = Q.base[Q.front];									//保存
	Q.front = (Q.front + 1) % MAXQSIZE;						//队头加1
	return OK;
}

//五，取头
QElemType GetHead(SqQueue Q){
	if (Q.front != Q.rear)									//队不空
		return Q.base[Q.front];
}

//六，打印
void PrintSQ(SqQueue &Q){
	printf("StackQueue:");
	for (int i = Q.front; i != Q.rear; i = (i + 1) % MAXQSIZE){
		printf("%d ", Q.base[i]);
	}
	printf("\n");

}
//链式队列———————————————————————————————————————————————————————————————————————————————
typedef struct Qnode{
	QElemType data;
	struct Qnode *next;
}QNode,*QueuePtr;
typedef struct{
	QueuePtr front;											//队头指针
	QueuePtr rear;											//队尾指针
}LinkQueue;

 //一，初始
Status InitLQueue(LinkQueue &Q){
	Q.front = Q.rear = (QueuePtr)malloc(sizeof(QNode));
	Q.front->next = NULL;
	return OK;
}

//二，销毁
Status DestroyLQueue(LinkQueue &Q){
	while (Q.front != NULL){
		QNode*p = Q.front->next;
		free(Q.front);
		Q.front = p;
	}
	return OK;
}

//三，入队
Status EnLQueue(LinkQueue &Q, QElemType e){
	QNode*p = (QueuePtr)malloc(sizeof(QNode));
	p->data = e;
	p->next = NULL;
	Q.rear->next = p;
	Q.rear = p;
	return OK;
}

//四，出队
Status DeLQueue(LinkQueue &Q, QElemType &e){
	if (Q.front == Q.rear)return ERROR;
	QNode* p = Q.front->next;								//p指向头结点下一个
	e = p->data;
	Q.front->next = p->next;								//头结点接上删除后的下一个结点
	if (Q.rear == p)Q.rear = Q.front;						//如果下一个结点就是尾结点了，置空
	free(p);
	return OK;
}

//五，取头
QElemType GetHeadLQ(LinkQueue Q) {
	if (Q.front == Q.rear)return ERROR;
	return(Q.front->next->data);
}

//六，打印
void PrintLQ(LinkQueue &Q){
	QNode*p;
	p = Q.front->next;
	printf("LinkQueue:");
	while (p != NULL){
		printf("%d  ", p->data);
		p = p->next;
	}
	printf("\n");
}
//———————————————————————————————————————————————————————————————————————————————
int main(){
	SqQueue SQ;
	InitQueue(SQ);
	EnQueue(SQ, 1);
	EnQueue(SQ, 2);
	EnQueue(SQ, 3);
	PrintSQ(SQ);
	QElemType e;
	DeQueue(SQ, e);
	printf("出队的是值：%d\n", e);
	PrintSQ(SQ);


	LinkQueue LQ;
	InitLQueue(LQ);
	EnLQueue(LQ, 4);
	EnLQueue(LQ, 5);
	EnLQueue(LQ, 6);
	PrintLQ(LQ);
	QElemType E;
	DeLQueue(LQ, E);
	printf("出队的是值：%d\n", E);
	PrintLQ(LQ);
	DestroyLQueue(LQ);
	return 0;
}
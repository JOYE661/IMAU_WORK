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
//˳����С�������������������������������������������������������������������������������������������������������������������������������������������������������������
typedef struct{
	QElemType *base;
	int front;
	int rear;
}SqQueue;

//һ����ʼ
Status InitQueue(SqQueue &Q){
	Q.base = (QElemType*)malloc(MAXQSIZE*sizeof(QElemType));//����ռ�
	if (Q.base==NULL)exit(OVERFLOW);						//����ʧ��
	Q.front = Q.rear = 0;									//ͷβָ��Ϊ0���ӿ�
	return OK;
}

//������
int QueueLength(SqQueue Q){
	return ((Q.rear - Q.front + MAXQSIZE) % MAXQSIZE);		//βָ�����Ϊǰ��
}

//�������
Status EnQueue(SqQueue &Q, QElemType e){
	if ((Q.rear + 1) % MAXQSIZE == Q.front)return ERROR;	//����
	Q.base[Q.rear] = e;										//���
	Q.rear = (Q.rear + 1) % MAXQSIZE;						//��β��1
	return OK;
}

//�ģ�����
Status DeQueue(SqQueue &Q, QElemType &e){
	if (Q.front == Q.rear)return ERROR;						//�ӿ�
	e = Q.base[Q.front];									//����
	Q.front = (Q.front + 1) % MAXQSIZE;						//��ͷ��1
	return OK;
}

//�壬ȡͷ
QElemType GetHead(SqQueue Q){
	if (Q.front != Q.rear)									//�Ӳ���
		return Q.base[Q.front];
}

//������ӡ
void PrintSQ(SqQueue &Q){
	printf("StackQueue:");
	for (int i = Q.front; i != Q.rear; i = (i + 1) % MAXQSIZE){
		printf("%d ", Q.base[i]);
	}
	printf("\n");

}
//��ʽ���С�������������������������������������������������������������������������������������������������������������������������������������������������������������
typedef struct Qnode{
	QElemType data;
	struct Qnode *next;
}QNode,*QueuePtr;
typedef struct{
	QueuePtr front;											//��ͷָ��
	QueuePtr rear;											//��βָ��
}LinkQueue;

 //һ����ʼ
Status InitLQueue(LinkQueue &Q){
	Q.front = Q.rear = (QueuePtr)malloc(sizeof(QNode));
	Q.front->next = NULL;
	return OK;
}

//��������
Status DestroyLQueue(LinkQueue &Q){
	while (Q.front != NULL){
		QNode*p = Q.front->next;
		free(Q.front);
		Q.front = p;
	}
	return OK;
}

//�������
Status EnLQueue(LinkQueue &Q, QElemType e){
	QNode*p = (QueuePtr)malloc(sizeof(QNode));
	p->data = e;
	p->next = NULL;
	Q.rear->next = p;
	Q.rear = p;
	return OK;
}

//�ģ�����
Status DeLQueue(LinkQueue &Q, QElemType &e){
	if (Q.front == Q.rear)return ERROR;
	QNode* p = Q.front->next;								//pָ��ͷ�����һ��
	e = p->data;
	Q.front->next = p->next;								//ͷ������ɾ�������һ�����
	if (Q.rear == p)Q.rear = Q.front;						//�����һ��������β����ˣ��ÿ�
	free(p);
	return OK;
}

//�壬ȡͷ
QElemType GetHeadLQ(LinkQueue Q) {
	if (Q.front == Q.rear)return ERROR;
	return(Q.front->next->data);
}

//������ӡ
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
//��������������������������������������������������������������������������������������������������������������������������������������������������������������
int main(){
	SqQueue SQ;
	InitQueue(SQ);
	EnQueue(SQ, 1);
	EnQueue(SQ, 2);
	EnQueue(SQ, 3);
	PrintSQ(SQ);
	QElemType e;
	DeQueue(SQ, e);
	printf("���ӵ���ֵ��%d\n", e);
	PrintSQ(SQ);


	LinkQueue LQ;
	InitLQueue(LQ);
	EnLQueue(LQ, 4);
	EnLQueue(LQ, 5);
	EnLQueue(LQ, 6);
	PrintLQ(LQ);
	QElemType E;
	DeLQueue(LQ, E);
	printf("���ӵ���ֵ��%d\n", E);
	PrintLQ(LQ);
	DestroyLQueue(LQ);
	return 0;
}
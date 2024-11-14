#pragma once
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<stdbool.h>

typedef int QDataType;

typedef struct QueueNode
{
	struct QueueNode*next;
	QDataType data;
}QNode;

typedef struct Queue
{
	QueueNode*head;
	QueueNode*tail;
}Queue;

void QueueInit(Queue*pq);
void Destroy(Queue*pq);
void QueuePush(Queue*pq, QDataType x);
void QueuePop(Queue*pq);
QDataType QueueFront(Queue*pq);
QDataType QueueBack(Queue*pq);
int QueueSize(Queue*pq);
bool QueueEmpty(Queue*pq);

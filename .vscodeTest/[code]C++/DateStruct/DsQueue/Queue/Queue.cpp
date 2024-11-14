#include"Queue.h"

void QueueInit(Queue*pq)
{
	assert(pq);
	pq->head = NULL;
	pq->tail = NULL;
}
void Destroy(Queue*pq)
{
	assert(pq);
	QueueNode*cur = pq->head;
	while (cur != NULL)
	{
		QueueNode*next = cur->next;
		free(cur);
		cur = next;
	}
	pq->head = pq->tail = NULL;	
}
void QueuePush(Queue*pq, QDataType x)
{
	assert(pq);
	QueueNode*newnode = (QueueNode*)malloc(sizeof(QueueNode));
	newnode->data = x;
	newnode->next = NULL;
	if (pq->head == NULL)
	{
		pq->head = pq->tail = newnode;
	}
	else
	{
		pq->tail->next = newnode;
		pq->tail = newnode;
	}
}
void QueuePop(Queue*pq)
{
	assert(pq);
	assert(!QueueEmpty(pq));
	QueueNode*next = pq->head->next;
	free(pq->head);
	pq->head = next;
	if (pq->head == NULL)
	{
		pq->tail == NULL;
	}
}
QDataType QueueFront(Queue*pq)
{
	assert(pq);
	assert(!QueueEmpty(pq));
	return pq->head->data;
}
QDataType QueueBack(Queue*pq)
{
	assert(pq);
	assert(!QueueEmpty(pq));
	return pq->tail->data;
}
int QueueSize(Queue*pq)
{
	assert(pq);
	int n = 0;
	QueueNode*cur = pq->head;
	while (cur)
	{
		++n;
		cur = cur->next;
	}
	return n;
}
bool QueueEmpty(Queue*pq)
{
	assert(pq);
	return pq->head == NULL;
}

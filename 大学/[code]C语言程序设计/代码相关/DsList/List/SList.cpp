#include"SList.h"
#include<stdlib.h>

SLTNode*BuyListNode(SLTDateType x)
{
	SLTNode*newnode = (SLTNode*)malloc(sizeof(SLTNode));
	newnode->data = x;
	newnode->next = NULL;
	return newnode;
}

void SListPrint(SLTNode*phead)
{
	SLTNode*cur = phead;
	while (cur != NULL)
	{
		printf("%d->", cur->data);
		cur = cur->next;
	}
	printf("NULL\n");
}
void SListPushBack(SLTNode**pphead, SLTDateType x)
{
	SLTNode*newnode = BuyListNode(x);

	if (*pphead == NULL)
	{
		*pphead = newnode;
	}
	else
	{
		//ÕÒµ½Î²½áµã
		SListNode*tail = *pphead;
		while (tail->next != NULL)
		{
			tail = tail->next;
		}
		tail->next = newnode;
	}
}
void SListPushFront(SLTNode**pphead, SLTDateType x)
{
	SLTNode*newnode = BuyListNode(x);
	newnode->next = *pphead;
	*pphead = newnode;
}
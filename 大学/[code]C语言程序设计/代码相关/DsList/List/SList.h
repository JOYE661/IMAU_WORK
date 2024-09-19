#pragma once
#include<stdio.h>
#include<stdlib.h>
typedef int SLTDateType;

typedef struct SListNode
{
	int data;
	struct SListNode*next;
}SLTNode;

void SListPrint(SLTNode* phead);
void SListPushBack(SLTNode**pphead, SLTDateType x);
void SListPushFront(SLTNode**pphead, SLTDateType x);
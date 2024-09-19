#pragma once
#include<stdio.h>
#include<stdlib.h>
#define N 100
typedef int SLDataType;

 typedef struct SeqList
{
	SLDataType*a;
	int size;
	int capacity;
}SL;
void SeqListPrint(SL* ps);
void SeqListInit(SL* ps);
void SeqListDestory(SL* ps);
void SeqListPushBack(SL*ps, SLDataType x);
void SeqListPopBack(SL*ps);
void SeqListPushFront(SL*ps, SLDataType x);
void SeqListPopFront(SL*ps); 
void SeqListCheckCapacity(SL*ps);
//�ҵ��˷���xλ���±꣬û���ҵ�����-1
int SeqListFind(SL*ps, SLDataType x);
//��ָ��λ��pos����
void SeqListInsert(SL*ps,int pos,SLDataType x);
//��ָ��λ��posɾ��
void SeqListErase(SL*ps, int pos);

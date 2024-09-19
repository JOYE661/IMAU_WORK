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
//找到了返回x位置下标，没有找到返回-1
int SeqListFind(SL*ps, SLDataType x);
//从指定位置pos插入
void SeqListInsert(SL*ps,int pos,SLDataType x);
//从指定位置pos删除
void SeqListErase(SL*ps, int pos);

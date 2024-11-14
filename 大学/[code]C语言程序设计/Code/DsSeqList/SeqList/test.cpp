#include"SeqList.h"
void TestSeqList1()
{
	SL sl;
	SeqListInit(&sl);
	SeqListPushBack(&sl, 1);
	SeqListPushBack(&sl, 2);
	SeqListPushBack(&sl, 3);
	SeqListPushBack(&sl, 4);
	SeqListPushBack(&sl, 5);
	SeqListPrint(&sl);

	SeqListPopBack(&sl);
	SeqListPopBack(&sl);
	SeqListPrint(&sl);


	SeqListDestory(&sl);
}
void TestSeqList2()
{
	SL sl;
	SeqListInit(&sl);
	SeqListPushBack(&sl, 1);
	SeqListPushBack(&sl, 2);
	SeqListPushBack(&sl, 3);
	SeqListPushBack(&sl, 4);
	SeqListPrint(&sl);

	SeqListPushFront(&sl, 10);
	SeqListPushFront(&sl, 20);
	SeqListPushFront(&sl, 30);
	SeqListPushFront(&sl, 40);
	SeqListPrint(&sl);

	SeqListPopFront(&sl);
	SeqListPopFront(&sl);
	SeqListPrint(&sl);

	SeqListDestory(&sl);
}
void TestSeqList3()
{
	SL sl;
	SeqListInit(&sl);
	SeqListPushBack(&sl, 1);
	SeqListPushBack(&sl, 2);
	SeqListPushBack(&sl, 3);
	SeqListPushBack(&sl, 4);
	SeqListInsert(&sl,2,30);
	SeqListPrint(&sl);

	int pos = SeqListFind(&sl, 4);
	if (pos != -1)
	{
		SeqListInsert(&sl, pos, 40);
	}
	SeqListPrint(&sl);

	SeqListDestory(&sl);
}
void TestSeqList4()
{
	SL sl;
	SeqListInit(&sl);
	SeqListPushBack(&sl, 1);
	SeqListPushBack(&sl, 2);
	SeqListPushBack(&sl, 3);
	SeqListPushBack(&sl, 4);
	SeqListInsert(&sl, 2, 30);
	SeqListErase(&sl,2);
	SeqListPrint(&sl);

}
int main()
{
	//TestSeqList1();
	//TestSeqList2();
	//TestSeqList3();
	TestSeqList4();
	return 0;
}
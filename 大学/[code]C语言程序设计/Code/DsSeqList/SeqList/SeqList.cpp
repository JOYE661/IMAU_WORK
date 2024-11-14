#include"SeqList.h"
void SeqListCheckCapacity(SL*ps)//判断是否需要扩容
{
	if (ps->size == ps->capacity)
	{
		int newcapacity = ps->capacity == 0 ? 4 : ps->capacity * 2;
		SLDataType*tmp = (SLDataType*)realloc(ps->a, newcapacity*sizeof(SLDataType));
		//三目运算符（也叫条件运算符），b?x:y  先计算条件b，然后进行判断。如果b的值为true，计算x的值，运算结果为x的值
		//指针名=（数据类型*）realloc（要改变内存大小的指针名，新的大小）
		if (tmp == NULL)
		{
			printf("realloc fail\n");
			exit(-1);
		}
		ps->a = tmp;
		ps->capacity = newcapacity;
	}
}
void SeqListPrint(SL* ps)//遍历顺序表函数
{
	for (int i = 0; i < ps->size; ++i)
	{
		printf("%d ", ps->a[i]);
	}
	printf("\n");
}
void SeqListInit(SL* ps)//初始化顺序表函数
{
	ps->a = NULL;
	ps->size = ps->capacity = 0;
}
void SeqListDestory(SL* ps)//清空顺序表函数
{
	free(ps->a);
	ps->a = NULL;
	ps->capacity = ps->size = 0;
}
void SeqListPushBack(SL*ps, SLDataType x)//从后边插入值
{
	SeqListCheckCapacity(ps);
	ps->a[ps->size] = x;
	ps->size++;
}
void SeqListPopBack(SL*ps)//从后边删除值
{
	if (ps->size>0)
	//ps->a[ps->size - 1] = 0;
	ps->size--;
}
void SeqListPushFront(SL*ps, SLDataType x)//从前面插入值
{
	SeqListCheckCapacity(ps); 
	//挪动数据
	int end = ps->size - 1;
	while (end >= 0)
	{
		ps->a[end + 1] = ps->a[end];
		--end;
	}
	ps->a[0]=x;
	ps->size++;
}
void SeqListPopFront(SL*ps)//从前面删除值
{
	//挪动数据
	if (ps->size > 0)
	{
		int begin = 1;
		while (begin < ps->size)
		{
			ps->a[begin - 1] = ps->a[begin];
			++begin;	
		}
		ps->size--;
	}
}
int SeqListFind(SL*ps, SLDataType x)//查找值是否存在
{
	for (int i = 0; i < ps->size; i++)
	{
		if (ps->a[i] == x)
		{
			return i;
		}
	}
	return -1;
}
void SeqListInsert(SL*ps, int pos, SLDataType x)//任意指定处插入值
{
	if (pos>ps->size||pos<=0)
	{
		printf("pos invalid\n");
		return;
	}
	//挪动数据
	SeqListCheckCapacity(ps);
	int end = ps->size - 1;
	while (end >= pos)
	{
		ps->a[end+1] = ps->a[end];
		--end;
	}
	ps->a[pos] = x;
	ps->size++;
}
void SeqListErase(SL*ps, int pos)//任意指定处删除值
{
	if (pos>ps->size || pos <= 0)
	{
		printf("pos invalid\n");
		return;
	}
	int begin = pos + 1;
	while (begin < ps->size)
	{
		ps->a[begin - 1] = ps->a[begin];
		++begin;	
	}
	ps->size--;
}
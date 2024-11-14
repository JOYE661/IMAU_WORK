#include"SeqList.h"
void SeqListCheckCapacity(SL*ps)//�ж��Ƿ���Ҫ����
{
	if (ps->size == ps->capacity)
	{
		int newcapacity = ps->capacity == 0 ? 4 : ps->capacity * 2;
		SLDataType*tmp = (SLDataType*)realloc(ps->a, newcapacity*sizeof(SLDataType));
		//��Ŀ�������Ҳ���������������b?x:y  �ȼ�������b��Ȼ������жϡ����b��ֵΪtrue������x��ֵ��������Ϊx��ֵ
		//ָ����=����������*��realloc��Ҫ�ı��ڴ��С��ָ�������µĴ�С��
		if (tmp == NULL)
		{
			printf("realloc fail\n");
			exit(-1);
		}
		ps->a = tmp;
		ps->capacity = newcapacity;
	}
}
void SeqListPrint(SL* ps)//����˳�����
{
	for (int i = 0; i < ps->size; ++i)
	{
		printf("%d ", ps->a[i]);
	}
	printf("\n");
}
void SeqListInit(SL* ps)//��ʼ��˳�����
{
	ps->a = NULL;
	ps->size = ps->capacity = 0;
}
void SeqListDestory(SL* ps)//���˳�����
{
	free(ps->a);
	ps->a = NULL;
	ps->capacity = ps->size = 0;
}
void SeqListPushBack(SL*ps, SLDataType x)//�Ӻ�߲���ֵ
{
	SeqListCheckCapacity(ps);
	ps->a[ps->size] = x;
	ps->size++;
}
void SeqListPopBack(SL*ps)//�Ӻ��ɾ��ֵ
{
	if (ps->size>0)
	//ps->a[ps->size - 1] = 0;
	ps->size--;
}
void SeqListPushFront(SL*ps, SLDataType x)//��ǰ�����ֵ
{
	SeqListCheckCapacity(ps); 
	//Ų������
	int end = ps->size - 1;
	while (end >= 0)
	{
		ps->a[end + 1] = ps->a[end];
		--end;
	}
	ps->a[0]=x;
	ps->size++;
}
void SeqListPopFront(SL*ps)//��ǰ��ɾ��ֵ
{
	//Ų������
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
int SeqListFind(SL*ps, SLDataType x)//����ֵ�Ƿ����
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
void SeqListInsert(SL*ps, int pos, SLDataType x)//����ָ��������ֵ
{
	if (pos>ps->size||pos<=0)
	{
		printf("pos invalid\n");
		return;
	}
	//Ų������
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
void SeqListErase(SL*ps, int pos)//����ָ����ɾ��ֵ
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
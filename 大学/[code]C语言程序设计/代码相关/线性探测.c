#include<stdio.h>
#include<stdlib.h>
int HashSearch1(int ht[], int m, int k, int *p);
int H(int k);

int main()
{
	int index, i;
	int r[] = { 47, 7, 29, 11, 16, 92, 22, 8, 3 };
	int ht[11] = { 0 };
	for (i = 0; i < 9; i++)
	{
		HashSearch1(ht, 11, r[i], &index);
		printf("元素%d的存储下标是%d\n", r[i], index);
	}
	for (i = 0; i < 11; i++)
		printf("%d ", ht[i]);
	getchar();
	return 0;
}
int HashSearch1(int ht[], int m, int k, int *p)    /*形参p传指针，返回位置*/
{
	int i, j, flag = 0;                      /*flag=0表示散列表未满*/
	j = H(k);                            /*计算散列地址*/
	i = j;                               /*记载比较的起始位置*/
	while (ht[i] != 0 && flag == 0)
	{
		if (ht[i] == k) {                    /*比较若干次查找成功*/
			*p = i; return 1;
		}
		else i = (i + 1) % m;                /*向后探测一个位置*/
		if (i == j) flag = 1;                  /*表已满*/
	}
	if (flag == 1) { printf("溢出"); exit(-1); }   /*表满，产生溢出*/
	else {                              /*比较若干次查找不成功，插入*/
		ht[i] = k; *p = i; return 0;
	}
}
int H(int k)
{
	return k % 11;
}

#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#define size 10

void InsertSort(int *num, int len)
{
	int i, j, temp;
	for (i = 1; i < len; i++)
	{

		if (num[i - 1] > num[i])
		{

			temp = num[i];
			for (j = i - 1; j >= 0 && num[j] > temp; j--)
			{
				num[j + 1] = num[j];
			}
			num[j + 1] = temp;
		}
	}
}
void Sort(int *num, int len)
{
	int i, j, temp, k;
	for (i = 0; i<len - 2; i++)
	{
		k = i;
		for (j = k + 1; j<len; j++)
		{
			if (num[k]>num[j])
				k = j;
			temp = num[i];
			num[i] = num[k];
			num[k] = temp;
		}
	}
}
void BubbleSort(int r[], int n)
{
	int j, exchange, bound;
	exchange = n;
	while (exchange != 0)
	{
		bound = exchange;
		exchange = 0;
		for (j = 1; j < bound; j++)
		{
			if (r[j] > r[j + 1])
			{
				r[0] = r[j]; r[j] = r[j + 1]; r[j + 1] = r[0];
				exchange = j;
			}
		}
	}
}

int main()
{
	int i, num[size];
	for (i = 0; i<10; i++)
		scanf("%d", &num[i]);
	InsertSort(num, size);
	printf("²åÈëÅÅÐò:\n");
	for (i = 0; i < size; i++)
	{
		printf("%d ", num[i]);
	}
	printf("\n");
	Sort(num, size);
	printf("Ñ¡ÔñÅÅÐò:\n");
	for (i = 0; i < size; i++)
	{
		printf("%d ", num[i]);
	}
	printf("\n");
	BubbleSort(num, size);
	printf("½»»»ÅÅÐò:\n");
	for (i = 0; i < size; i++)
	{
		printf("%d ", num[i]);
	}
	printf("\n");
	return 0;
}
#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
int main()
{
	int n;
	scanf("%d", &n);
	int arr[1000];
	int i, j, k;
	int count = 0;
	for (i = 0; i < n; i++)
	{
		scanf("%d", &arr[i]);
	}
	for (i = 0; i < n; i++)
	{
		for (j = i + 1; j < n; j++)
		{
			int sum;
			sum = arr[i] + arr[j];
			for (k = 0; k < n; k++)//���Һ��Ƿ���ԭ������
			{
				if (sum == arr[k])
				{
					count++;
				}
			}
		}
	}
	printf("%d", count);
	return 0;
}
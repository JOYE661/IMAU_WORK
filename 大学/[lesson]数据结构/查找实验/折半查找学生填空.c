#include<stdio.h>
//#define N 10
int BinSearch1(int r[], int n, int k);
int BinSearch2(int r[], int low, int high, int k);

int main()
{
	int i, x, fun1, fun2;
	int r[10] = { 0, 5, 12, 17, 24, 30, 32, 38, 40, 53 };
	printf("数组的序列是:");
	for (i = 1; i < 10; i++)
		printf("%3d", r[i]);
	printf("\n");
	printf("请输入一个数:");
	scanf("%d", &x);
	fun1 = BinSearch1(r, 9, x);
	if (fun1 == 0)
		printf("没有找到\n");
	else
		printf("%d在数组的下标是%d\n", x, fun1);
	fun2 = BinSearch2(r, 1, 9, x);
	if (fun2 == 0)printf("没有找到\n");
	else
		printf("%d在数组的下标是%d\n", x, fun2);
	return 0;
}
int BinSearch1(int r[], int n, int k)      /*查找集合存储在r[1]~r[n]*/
{
	int mid, low = 1, high = n;
	while (low <= high)
	{
		mid = (low + high) / 2;
		if (k < r[mid]) high = mid - 1;
		else if (k > r[mid]) low = mid + 1;
		else return mid;
	}
	return 0;
}

int BinSearch2(int r[], int low, int high, int k)
{
	int mid;
	if (low > high) return 0;
	else{
		mid = (low + high) / 2;
		if (k < r[mid]) return BinSearch2(r, low, mid - 1, k);
		else if (k > r[mid]) return BinSearch2(r, mid + 1, high, k);
		else return mid;
	}
}



//输出斐波那契数序列的前10项1（1,1,2,3,5,8,13,21,34,55)前两个数是1，往后两个数a,b相加得c,然后b,c再相加如此循环
#include<stdio.h>
int main()
{
	int a = 0, b = 0, c = 0, i;
	a = b = 1;
	printf("%d,%d,", a, b);
	for ( i = 3; i <=10 ; i++){
		c = a + b;
		printf("%d,", c);
		a = b;
		b = c;
	}
	return 0;
}

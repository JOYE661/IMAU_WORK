#include<stdio.h>
#include<stdlib.h>
#define N 10

int SeqSearch(int r[ ], int n, int k);
int main( )
{
	int i,x,fun;
	int r[N+1]={0,22,23,5,43,67,24,9,34,12,10};
	for(i = 1; i <= N; i++)
	printf("%d\t",r[i]);
	printf("\n");
	printf("������һ����:");
	scanf("%d",&x);
	fun = SeqSearch(r,N,x);
	if(fun == 0)printf("û���ҵ�\n");
	else
	printf("%d��������±���%d\n",x,fun);
	return 0;
}

int SeqSearch(int r[ ], int n, int k)      /*���鼯�ϴ洢������r[1]~r[n]*/
{   

	int i = n;
	while (i > 0 && r[i] != k)
		i--;
	return i;
}


//���쳲����������е�ǰ10��1��1,1,2,3,5,8,13,21,34,55)ǰ��������1������������a,b��ӵ�c,Ȼ��b,c��������ѭ��
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

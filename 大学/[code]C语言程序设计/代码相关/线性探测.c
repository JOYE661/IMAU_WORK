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
		printf("Ԫ��%d�Ĵ洢�±���%d\n", r[i], index);
	}
	for (i = 0; i < 11; i++)
		printf("%d ", ht[i]);
	getchar();
	return 0;
}
int HashSearch1(int ht[], int m, int k, int *p)    /*�β�p��ָ�룬����λ��*/
{
	int i, j, flag = 0;                      /*flag=0��ʾɢ�б�δ��*/
	j = H(k);                            /*����ɢ�е�ַ*/
	i = j;                               /*���رȽϵ���ʼλ��*/
	while (ht[i] != 0 && flag == 0)
	{
		if (ht[i] == k) {                    /*�Ƚ����ɴβ��ҳɹ�*/
			*p = i; return 1;
		}
		else i = (i + 1) % m;                /*���̽��һ��λ��*/
		if (i == j) flag = 1;                  /*������*/
	}
	if (flag == 1) { printf("���"); exit(-1); }   /*�������������*/
	else {                              /*�Ƚ����ɴβ��Ҳ��ɹ�������*/
		ht[i] = k; *p = i; return 0;
	}
}
int H(int k)
{
	return k % 11;
}

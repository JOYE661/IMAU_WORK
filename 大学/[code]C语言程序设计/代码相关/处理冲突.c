#include<stdio.h>
#include<stdlib.h>

int HashSearch1(int ht[ ], int m, int k, int *p)    /*�β�p��ָ�룬����λ��*/
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
if (flag == 1) {printf("���"); exit(-1);}   /*�������������*/
 else {                              /*�Ƚ����ɴβ��Ҳ��ɹ�������*/
ht[i] = k; *p = i; return 0;
 }
}
int H(int key)
{
	return key%11;
}
int main()
{
	int i,index;
	int h[]={47, 7, 29, 11, 16, 92, 22, 8, 3};
	int ht[11] ={0};
	for(i= 0; i < 9; i++)
	{
		HashSearch1(ht, 11, h[i], &index);
		printf("\nԪ��%d�Ĵ洢�±���%d",h[i],index);
	}
	printf("\n��ӡ������:");
	for( i =0; i< 9; i++)
	printf("%3d", ht[i]);

	return 0;
}

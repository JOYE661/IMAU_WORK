#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
typedef struct
{
	char book_name[50];
	char book_author[50];
	int number;
}BookInfo;
typedef struct
{
	BookInfo books[50];// ÿ������Ԫ�ؼ�¼һ����
	int length;// ӵ��ͼ��ĸ���
}BookShelf;// typedef�ؼ��ּ򻯽ṹ��������
void Add(BookShelf *B, BookInfo x)
{
	B->length++;
	B->books[B->length - 1] = x;
}
int GetNumber(BookShelf *B)
{
	return B->length;
}
void Print(BookShelf *B)
{
	int i = 0;
	printf("���  ����  ����\n");
	for (i = 0; i<B->length; i++)
	{
		printf("%d:,%s,%s\n", B->books[i].number, B->books[i].book_name, B->books[i].book_author);
	}
}
void menu()
{
	printf("***********************\n");
	printf("*�ҵ��鼮��¼ϵͳ     *\n");
	printf("*1. ���������Ϣ      *\n");
	printf("*2. ��ӵ�е��鼮      *\n");
	printf("*3. ��������          *\n");
	printf("***********************\n");
}
int main()
{
	int c, count = 1;
	BookInfo x = { "C���Գ������", "��С��", 1 };
	BookShelf b = { { x }, 1 };
	menu();
	while (1)
	{
		printf("\n�����빦�ܱ�ţ�");
		scanf("%d", &c);
		switch (c)
		{
		case 1:
			printf("������������");
			scanf("%s", &x.book_name);
			printf("�������������ƣ�");
			scanf("%s", &x.book_author);
			x.number = ++count;
			Add(&b, x);
			break;
		case 2:
			printf("\n�����ڹ���%d����\n", GetNumber(&b));
			printf("\n");
			Print(&b);
			break;
		case 3:
			return 0;
		}
	}
}
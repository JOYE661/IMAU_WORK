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
	BookInfo books[50];// 每个数组元素记录一本书
	int length;// 拥有图书的个数
}BookShelf;// typedef关键字简化结构体类型名
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
	printf("编号  书名  作者\n");
	for (i = 0; i<B->length; i++)
	{
		printf("%d:,%s,%s\n", B->books[i].number, B->books[i].book_name, B->books[i].book_author);
	}
}
void menu()
{
	printf("***********************\n");
	printf("*我的书籍记录系统     *\n");
	printf("*1. 添加新书信息      *\n");
	printf("*2. 我拥有的书籍      *\n");
	printf("*3. 结束程序          *\n");
	printf("***********************\n");
}
int main()
{
	int c, count = 1;
	BookInfo x = { "C语言程序设计", "苏小红", 1 };
	BookShelf b = { { x }, 1 };
	menu();
	while (1)
	{
		printf("\n请输入功能编号：");
		scanf("%d", &c);
		switch (c)
		{
		case 1:
			printf("请输入书名：");
			scanf("%s", &x.book_name);
			printf("请输入作者名称：");
			scanf("%s", &x.book_author);
			x.number = ++count;
			Add(&b, x);
			break;
		case 2:
			printf("\n你现在共有%d本书\n", GetNumber(&b));
			printf("\n");
			Print(&b);
			break;
		case 3:
			return 0;
		}
	}
}
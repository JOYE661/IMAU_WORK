#define _CRT_SECURE_NO_WARNINGS 1
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define INFEASIBLE -1
#define OVERFLOW -2
typedef int Status;
typedef int ElemType;
#include<stdio.h>
#include<iostream>
using namespace std;

#define MAXSIZE 100
typedef struct{
	ElemType *elem;
	int length;
}SqList;
//一，初始
Status InitList_Sq(SqList &L)
{
	//L.elem = new ElemType[MAXSIZE];
	L.elem = (ElemType*)malloc(sizeof(ElemType[MAXSIZE]));
	if (!L.elem)exit(OVERFLOW);
	L.length = 0;
	return OK;
}//c++初始化线性表 O(1)
void InitList(SqList *L)
{
	L->length = 0;
}//c初始化顺序表 O(1)

//二，建表
int CreatList(SqList *L, ElemType a[], int n)
{
	if (n > MAXSIZE){
		printf("顺序表的空间不够，无法建立顺序表\n");
		return 0;
	}
	for (int i = 0; i < n; i++)
		L->elem[i] = a[i];
	L->length = n;
	return 1;
}//c建立顺序表

//三，销毁
void DestroyList(SqList &L)
{
	if (L.elem)delete L.elem;
}//c++销毁线性表 O(1)

//四，清空
void ClearList(SqList &L)
{
	L.length = 0;
}//c++清空线性表 O(1)

//五，判空
int IsEmpty(SqList *L)
{
	if (L->length == 0)return 1;
	else return 0;
}//c&c++判空顺序表 O(1)

//六，求长
int GetLength(SqList L)
{
	return(L.length);
}//c++求线性表长度 O(1)
int Length(SqList *L)
{
	return L->length;
}//c求顺序表长度 O(1)

//七，取值
int GetElem(SqList L, int i, ElemType &e)
{
	if (i<1 || i>L.length)return ERROR;
	e = L.elem[i - 1];
	return OK;
}//c++顺序表的取值 O(1)

//八，查找
int LocateElem(SqList L, ElemType e)
{
	for (int i = 0; i < L.length; i++)
	{
		if (L.elem[i] == e)
			return i + 1;
	}
	return 0;
}//c++顺序表的查找 ASL=n+1/2  O(n)
int Locate(SqList*L, ElemType x)
{
	for (int i = 0; i < L->length; i++)
	if (L->elem[i] == x)
		return i + 1;
	return 0;
}//c顺序表查找 ASL=n+1/2  O(n)

//九，插入
Status ListInsert_Sq(SqList &L, int i, ElemType e)
{
	if (i<1 || i>L.length + 1)return ERROR;		//1.判断i值是否合法
	if (L.length == MAXSIZE)return ERROR;		//2.判断存储空间是否满
	for (int j = L.length - 1; j >= i - 1; j--)
	{
		L.elem[j + 1] = L.elem[j];
	}											//3.插入位置及其之后的元素后移
	L.elem[i - 1] = e;							//4.将新元素e放入第i个位置
	L.length++;									//5.表长加1
	return OK;
}//c++顺序表的插入 ASL平均移动次数=n/2  O(n)
int Insert(SqList*L, int i, ElemType x)
{
	if (i<1 || i>L->length + 1){
		printf("位置错误，插入失败\n");
		return 0;
	}
	if (L->length >= MAXSIZE){
		printf("上溢错误，插入失败\n");
		return 0;
	}
	for (int j = L->length; j >= i; j--){
		L->elem[j] = L->elem[j - 1];
	}
	L->elem[i - 1] = x;
	L->length++;
	return 1;
}//c顺序表的插入

//十，删除
Status ListDelete_Sq(SqList &L, int i)
{
	if (i<1 || i>L.length)return ERROR;//1.判断i值是否合法
	for (int j = i; j <= L.length - 1; j++)
	{
		L.elem[j - 1] = L.elem[j];		//2.被删除元素之后的元素前移
	}
	L.length--;							//3.表长减1					
	return OK;

}//c++顺序表的删除 ASL平均移动次数=n-1/2	O(n)

//十一，打印
void Print_Sq(SqList *L)
{
	for (int i = 0; i < L->length; i++)
	{
		printf("[%d]", L->elem[i]);
	}
	printf("\n");
}//打印顺序表

//十二，合并
void Combine_unordered(SqList &La,SqList Lb){
	int La_len = GetLength(La);
	int Lb_len = GetLength(Lb);
	ElemType e = 0;
	for (int i = 1; i <= Lb_len; i++)
	{
		GetElem(Lb, i, e);
		if (!LocateElem(La, e))
			ListInsert_Sq(La, ++La_len, e);
	}
}//合并无序表
void Combine_ordered(SqList &La, SqList Lb,SqList &Lc)
{
	ElemType*pa = La.elem;
	ElemType*pb = Lb.elem;									//指针pa和pb的初值分别指向两个表的第一个元素
	Lc.length = La.length + Lb.length;						//新表的长度等于两个表的长度之和
	Lc.elem = (ElemType*)malloc(sizeof(ElemType[MAXSIZE]));	//为合并后的新表分配一个数组空间
	ElemType*pc = Lc.elem;									//指针pc指向新表的第一个元素
	ElemType*pa_last = La.elem+La.length-1;					//指针pa-last指向La表的最后一个元素
	ElemType*pb_last = Lb.elem + Lb.length - 1;				//指针pb-last指向Lb表的最后一个元素
	while (pa <= pa_last&&pb <= pb_last){					//两个表都非空
		if (*pa <= *pb) *pc++ = *pa++;						//依次摘取两表中值较小的结点
		else*pc++ = *pb++;
	}
	while (pa <= pa_last)
		*pc++ = *pa++;										//Lb表已到表尾，将la剩余元素加到lc
	while (pb <= pb_last)
		*pc++ = *pb++;		 								//La表已到表尾，将la剩余元素加到lc
}//合并有序表
int main()
{
	SqList L;
	printf("————执行初始化表：————\n");
	InitList_Sq(L);
	printf("————执行在第一位插入[1]：————\n");
	Insert(&L, 1, 1);//在第一位插入1
	Print_Sq(&L);
	printf("————执行在第二位插入[3]：————\n");
	ListInsert_Sq(L, 2, 3);//在第二位插入3
	Print_Sq(&L);
	printf("————执行删除第一位：————\n");
	ListDelete_Sq(L, 1);//删除第一位
	Print_Sq(&L);
	printf("————执行创建一个数组：————\n");
	int n = 0, m;
	printf("自定义数组大小：");
	scanf("%d", &m);
	n = m;
	ElemType b[MAXSIZE];
	printf("依次输入自定义元素：");
	for (int i = 0; i < n; i++)
		scanf("%d", &b[i]);
	//自定义一个数组
	printf("————执行以数组重建顺序表：————\n");
	CreatList(&L, b, n);//以数组重建顺序表
	Print_Sq(&L);
	printf("————执行删除第一位：————\n");
	ListDelete_Sq(L, 1);//删除第一位
	Print_Sq(&L);
	printf("————执行清空顺序表：————\n");
	ClearList(L);
	printf("————执行销毁顺序表：————\n");
	DestroyList(L);

	printf("————执行合并无序表：————\n");
	SqList La, Lb;
	InitList_Sq(La);
	InitList_Sq(Lb);
	ElemType a1[] = { 1, 5, 3 };
	ElemType b1[] = { 9, 4 };
	CreatList(&La, a1, 3);
	CreatList(&Lb, b1, 2);
	printf("表一：");
	Print_Sq(&La);
	printf("表二：");
	Print_Sq(&Lb);
	Combine_unordered(La, Lb);
	printf("合并后：");
	Print_Sq(&La);

	printf("————执行合并有序表：————\n");
	SqList La1, Lb1,Lc;
	InitList_Sq(La1);
	InitList_Sq(Lb1);
	ElemType a11[] = { 1, 3, 5 };
	ElemType b11[] = { 4, 9 };
	CreatList(&La1, a11, 3);
	CreatList(&Lb1, b11, 2);
	printf("表一：");
	Print_Sq(&La1);
	printf("表二：");
	Print_Sq(&Lb1);
	Combine_ordered(La1, Lb1, Lc);
	printf("合并后：");
	Print_Sq(&Lc);
	return 0;
}
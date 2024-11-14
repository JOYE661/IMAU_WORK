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
//һ����ʼ
Status InitList_Sq(SqList &L)
{
	//L.elem = new ElemType[MAXSIZE];
	L.elem = (ElemType*)malloc(sizeof(ElemType[MAXSIZE]));
	if (!L.elem)exit(OVERFLOW);
	L.length = 0;
	return OK;
}//c++��ʼ�����Ա� O(1)
void InitList(SqList *L)
{
	L->length = 0;
}//c��ʼ��˳��� O(1)

//��������
int CreatList(SqList *L, ElemType a[], int n)
{
	if (n > MAXSIZE){
		printf("˳���Ŀռ䲻�����޷�����˳���\n");
		return 0;
	}
	for (int i = 0; i < n; i++)
		L->elem[i] = a[i];
	L->length = n;
	return 1;
}//c����˳���

//��������
void DestroyList(SqList &L)
{
	if (L.elem)delete L.elem;
}//c++�������Ա� O(1)

//�ģ����
void ClearList(SqList &L)
{
	L.length = 0;
}//c++������Ա� O(1)

//�壬�п�
int IsEmpty(SqList *L)
{
	if (L->length == 0)return 1;
	else return 0;
}//c&c++�п�˳��� O(1)

//������
int GetLength(SqList L)
{
	return(L.length);
}//c++�����Ա��� O(1)
int Length(SqList *L)
{
	return L->length;
}//c��˳����� O(1)

//�ߣ�ȡֵ
int GetElem(SqList L, int i, ElemType &e)
{
	if (i<1 || i>L.length)return ERROR;
	e = L.elem[i - 1];
	return OK;
}//c++˳����ȡֵ O(1)

//�ˣ�����
int LocateElem(SqList L, ElemType e)
{
	for (int i = 0; i < L.length; i++)
	{
		if (L.elem[i] == e)
			return i + 1;
	}
	return 0;
}//c++˳���Ĳ��� ASL=n+1/2  O(n)
int Locate(SqList*L, ElemType x)
{
	for (int i = 0; i < L->length; i++)
	if (L->elem[i] == x)
		return i + 1;
	return 0;
}//c˳������ ASL=n+1/2  O(n)

//�ţ�����
Status ListInsert_Sq(SqList &L, int i, ElemType e)
{
	if (i<1 || i>L.length + 1)return ERROR;		//1.�ж�iֵ�Ƿ�Ϸ�
	if (L.length == MAXSIZE)return ERROR;		//2.�жϴ洢�ռ��Ƿ���
	for (int j = L.length - 1; j >= i - 1; j--)
	{
		L.elem[j + 1] = L.elem[j];
	}											//3.����λ�ü���֮���Ԫ�غ���
	L.elem[i - 1] = e;							//4.����Ԫ��e�����i��λ��
	L.length++;									//5.����1
	return OK;
}//c++˳���Ĳ��� ASLƽ���ƶ�����=n/2  O(n)
int Insert(SqList*L, int i, ElemType x)
{
	if (i<1 || i>L->length + 1){
		printf("λ�ô��󣬲���ʧ��\n");
		return 0;
	}
	if (L->length >= MAXSIZE){
		printf("������󣬲���ʧ��\n");
		return 0;
	}
	for (int j = L->length; j >= i; j--){
		L->elem[j] = L->elem[j - 1];
	}
	L->elem[i - 1] = x;
	L->length++;
	return 1;
}//c˳���Ĳ���

//ʮ��ɾ��
Status ListDelete_Sq(SqList &L, int i)
{
	if (i<1 || i>L.length)return ERROR;//1.�ж�iֵ�Ƿ�Ϸ�
	for (int j = i; j <= L.length - 1; j++)
	{
		L.elem[j - 1] = L.elem[j];		//2.��ɾ��Ԫ��֮���Ԫ��ǰ��
	}
	L.length--;							//3.����1					
	return OK;

}//c++˳����ɾ�� ASLƽ���ƶ�����=n-1/2	O(n)

//ʮһ����ӡ
void Print_Sq(SqList *L)
{
	for (int i = 0; i < L->length; i++)
	{
		printf("[%d]", L->elem[i]);
	}
	printf("\n");
}//��ӡ˳���

//ʮ�����ϲ�
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
}//�ϲ������
void Combine_ordered(SqList &La, SqList Lb,SqList &Lc)
{
	ElemType*pa = La.elem;
	ElemType*pb = Lb.elem;									//ָ��pa��pb�ĳ�ֵ�ֱ�ָ��������ĵ�һ��Ԫ��
	Lc.length = La.length + Lb.length;						//�±�ĳ��ȵ���������ĳ���֮��
	Lc.elem = (ElemType*)malloc(sizeof(ElemType[MAXSIZE]));	//Ϊ�ϲ�����±����һ������ռ�
	ElemType*pc = Lc.elem;									//ָ��pcָ���±�ĵ�һ��Ԫ��
	ElemType*pa_last = La.elem+La.length-1;					//ָ��pa-lastָ��La������һ��Ԫ��
	ElemType*pb_last = Lb.elem + Lb.length - 1;				//ָ��pb-lastָ��Lb������һ��Ԫ��
	while (pa <= pa_last&&pb <= pb_last){					//�������ǿ�
		if (*pa <= *pb) *pc++ = *pa++;						//����ժȡ������ֵ��С�Ľ��
		else*pc++ = *pb++;
	}
	while (pa <= pa_last)
		*pc++ = *pa++;										//Lb���ѵ���β����laʣ��Ԫ�ؼӵ�lc
	while (pb <= pb_last)
		*pc++ = *pb++;		 								//La���ѵ���β����laʣ��Ԫ�ؼӵ�lc
}//�ϲ������
int main()
{
	SqList L;
	printf("��������ִ�г�ʼ������������\n");
	InitList_Sq(L);
	printf("��������ִ���ڵ�һλ����[1]����������\n");
	Insert(&L, 1, 1);//�ڵ�һλ����1
	Print_Sq(&L);
	printf("��������ִ���ڵڶ�λ����[3]����������\n");
	ListInsert_Sq(L, 2, 3);//�ڵڶ�λ����3
	Print_Sq(&L);
	printf("��������ִ��ɾ����һλ����������\n");
	ListDelete_Sq(L, 1);//ɾ����һλ
	Print_Sq(&L);
	printf("��������ִ�д���һ�����飺��������\n");
	int n = 0, m;
	printf("�Զ��������С��");
	scanf("%d", &m);
	n = m;
	ElemType b[MAXSIZE];
	printf("���������Զ���Ԫ�أ�");
	for (int i = 0; i < n; i++)
		scanf("%d", &b[i]);
	//�Զ���һ������
	printf("��������ִ���������ؽ�˳�����������\n");
	CreatList(&L, b, n);//�������ؽ�˳���
	Print_Sq(&L);
	printf("��������ִ��ɾ����һλ����������\n");
	ListDelete_Sq(L, 1);//ɾ����һλ
	Print_Sq(&L);
	printf("��������ִ�����˳�����������\n");
	ClearList(L);
	printf("��������ִ������˳�����������\n");
	DestroyList(L);

	printf("��������ִ�кϲ��������������\n");
	SqList La, Lb;
	InitList_Sq(La);
	InitList_Sq(Lb);
	ElemType a1[] = { 1, 5, 3 };
	ElemType b1[] = { 9, 4 };
	CreatList(&La, a1, 3);
	CreatList(&Lb, b1, 2);
	printf("��һ��");
	Print_Sq(&La);
	printf("�����");
	Print_Sq(&Lb);
	Combine_unordered(La, Lb);
	printf("�ϲ���");
	Print_Sq(&La);

	printf("��������ִ�кϲ��������������\n");
	SqList La1, Lb1,Lc;
	InitList_Sq(La1);
	InitList_Sq(Lb1);
	ElemType a11[] = { 1, 3, 5 };
	ElemType b11[] = { 4, 9 };
	CreatList(&La1, a11, 3);
	CreatList(&Lb1, b11, 2);
	printf("��һ��");
	Print_Sq(&La1);
	printf("�����");
	Print_Sq(&Lb1);
	Combine_ordered(La1, Lb1, Lc);
	printf("�ϲ���");
	Print_Sq(&Lc);
	return 0;
}
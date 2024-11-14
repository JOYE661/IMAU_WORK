#define _crt_secure_no_warnings 1
#include<stdio.h>
#define n 100
typedef int datatype;
typedef struct
{
	datatype data[n];
	int front, rear;
}cirqueue;

void initqueue(cirqueue *q)
{
	q->front = q->rear = n - 1;
}
int enquene(cirqueue *q, datatype x)
{
	if ((q->rear + 1) % n == q->front)
	{
		printf("�������,����ʧ��\n");
		return 0;
	}
	q->rear = (q->rear + 1) % n;
	q->data[q->rear] = x;
	return 1;
}
int dequeue(cirqueue *q, datatype *ptr)
{
	if (q->rear == q->front){
		printf("�������ɾ��ʧ��\n");
		return 0;
	}
	q->front = (q->front + 1) % n;
	*ptr = q->data[q->front];
	return 1;
}
int gethead(cirqueue *q, datatype *ptr)
{
	int i;
	if (q->rear == q->front){
		printf("�������,ȡ��ͷԪ��ʧ��\n");
		return 0;
	}
	i = (q->front + 1) % n;
	*ptr = q->data[i];
	return 1;
}
int empty(cirqueue *q){
	if (q->rear == q->front)
		return 1;
	else
		return 0;
}
int main(){
	printf("������ͻ�����:");
	int n;
	scanf("%d", &n);
	datatype x;
	datatype y;
	cirqueue q;
	initqueue(&q);
	int i;
	int z = 0;
	for (i = 0; i < n; i++){
		printf("%��ͻ�ȡ��:");
		scanf("%d", &x);
		enquene(&q, x);
		z++;
	}
	for (i = 0; i < n; i++){
		gethead(&q, &x);
		z--;
		printf("��%d�ſͻ�ǰ�����ڰ�ҵ��,��ǰ�ȴ�����Ϊ%d��\n", x, z);
		printf("�����ѿ���\n");
		dequeue(&q, &x);
	}
	return 0;
}
#include<stdio.h>
#include<stdlib.h>
typedef int SElemType;
//Á´Õ»2.
typedef struct Node{
	SElemType data;
	struct Node*next;
}Node;
void InitLink(Node *top){					//3.c++Á´Õ»
	top = NULL;

}
void pushlink(Node*top, SElemType x){		//4.cÁ´Õ»
	Node*s = (Node*)malloc(sizeof(Node));
	s->data = x;
	s->next = top;
	top = s;
}
int linkpop(Node *top, SElemType *ptr){		//4.cÁ´Õ»
	Node*p = top;
	if (top == NULL){
		//printf("ÏÂÒç´íÎó,É¾³ýÊ§°Ü\n");
		return 0;
	}
	*ptr = top->data;
	top = top->next;
	free(p);
	return 1;
}
void Print_Link(Node *S){
	//printf("Á´Õ»½á¹¹£º\n");
	Node* p;
	p = S;
	while (p != NULL){
		printf("%d->\n", p->data);
		p = p->next;
	}
}
int main(){
    Node *L;
    InitLink(L);
    pushlink(L,1);
    pushlink(L,2);
    Print_Link(L);
    return 0;
}

#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
	int value;
	struct Node *next;
} Node;

Node* createCircularList(int n) {
	Node *head = NULL, *prev = NULL;

	for (int i = 1; i <= n; i++) {
		Node *newNode = (Node*)malloc(sizeof(Node));
		newNode->value = i;

		if (head == NULL) {
			head = newNode;
		}
		else {
			prev->next = newNode;
		}

		prev = newNode;
		prev->next = head;
	}

	return head;
}

void josephusCircle(Node** headRef, int k) {
	if (*headRef == NULL || k <= 0) {
		return;
	}

	Node *current = *headRef, *prev = NULL;

	while (current->next != current) {
		// �ҵ��� k ���ڵ�
		for (int i = 1; i < k; i++) {
			prev = current;
			current = current->next;
		}

		// ɾ����ǰ�ڵ�
		prev->next = current->next;
		Node *temp = current;
		current = current->next;
		free(temp);
	}

	// ���ʣ�µĽڵ㼴Ϊʤ��
	*headRef = current;
}

void displayCircularList(Node* head) {
	if (head == NULL) {
		return;
	}

	Node *current = head;

	do {
		printf("%d ", current->value);
		current = current->next;
	} while (current != head);

	printf("\n");
}

int main() {
	int n, k;
	printf("Enter the number of people: ");
	scanf("%d", &n);

	printf("Enter the value of k: ");
	scanf("%d", &k);

	Node *head = createCircularList(n);

	printf("Initial Circle: ");
	displayCircularList(head);

	josephusCircle(&head, k);

	printf("Josephus Circle: ");
	displayCircularList(head);

	free(head);

	return 0;
}
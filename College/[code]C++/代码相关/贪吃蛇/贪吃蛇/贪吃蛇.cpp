#define _CRT_SECURE_NO_WARNINGS 1
/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    ���汣��       ����崻�     ����BUG
*/
#include<stdio.h>
#include<time.h>//�����������������
#include<conio.h>//������������
#include<Windows.h>//Ϊ��ʹ��gotoxy(����ƶ�������
#define MAP_MODE "��"
#define SNAKE_HEAD "��"
#define SNAKE_BODY "��"
#define MAP_WIDTH 80
#define MAP_HEIGHT 30
#define MOVE_CENTER 12
#define INITLEN 3
#define MAXLEN 30
void welcome();
void createMap();
void createFood();
void initSnake();
void moveSnake();
int statement();
void gotoxy(int x, int y);
struct Food{
	int x;
	int y;
}food;
struct Snake{
	int x[MAXLEN];
	int y[MAXLEN];
	int currentLen;//�ߵĳ���
}snake;
int direct = 'a';
int flag = 1;//�Ƿ���Ҫ����ʳ��
int score = 0;//����
int main(){
	welcome();
	createMap();
	while (1){
		Sleep(300);
		//createFood();
		if (flag){
			createFood();
		}
		moveSnake();
		if (statement())
		{
			gotoxy(MAP_WIDTH / 2, MAP_HEIGHT / 2);
			printf("Game Over\n");
			gotoxy(96, 0);
			exit(0);
		}
	}

	return 0;
}
void welcome()
{
	gotoxy(40, 12);

	system("title c����ѧϰ");

	printf("��ӭ����̰������Ϸ��");

	gotoxy(40, 25);

	printf("*****c����ʵ��*****     \n");

	system("pause");

	system("cls");

	gotoxy(25, 12);

	printf("W��A��S��D����������ƶ�����\n");

	gotoxy(25, 13);

	//printf("F1Ϊ���٣�F2Ϊ����\n");

	system("pause");

	system("cls");
}
void createMap()
{
	for (int i = 0 + MOVE_CENTER; i < MAP_WIDTH + MOVE_CENTER; i += 2){
		gotoxy(i, 0);//�ı�x,y����,������ı߳�
		printf(MAP_MODE);

		gotoxy(i, MAP_HEIGHT - 1);//�ı�x,y����,������ı߳�
		printf(MAP_MODE);
	}
	for (int i = 0; i < MAP_HEIGHT; i += 1){
		gotoxy(0 + MOVE_CENTER, i);//�ı�y,x����,������ı߳�
		printf(MAP_MODE);

		gotoxy(MAP_WIDTH + MOVE_CENTER, i);//�ı�y,x����,������ı߳�
		printf(MAP_MODE);

	}
	gotoxy(96, 0);
	initSnake();
}
void createFood()
{
	srand(time(NULL));//�������
	int isCreate = 1;//��ʾʳ���Ƿ���Ա�����
	food.x = rand() % (MAP_WIDTH - 4 + 2) + MOVE_CENTER;//����ʳ����������ڱ߿���
	food.y = rand() % (MAP_HEIGHT - 2 + 1);////����ʳ����������ڱ߿���
	if (food.x % 2 == 0)//���������Ϊż������Ϊ����ռ���񣬲�Ϊż���߳Բ���ʳ��
	{
		//����ʳ�ﲻ���ߵ�����
		for (int i = 0; i < snake.currentLen; i++){
			if (snake.x[i] == food.x&&snake.y[i] == food.y){
				isCreate = 0;
			}
			if (isCreate)
			{
				gotoxy(food.x, food.y);
				printf("��");
				flag = 0;//������ʳ������
				gotoxy(96, 0);
			}
		}
	}
}
void initSnake()
{
	snake.currentLen = INITLEN;
	snake.x[0] = MAP_WIDTH / 2 + MOVE_CENTER;
	snake.y[0] = MAP_HEIGHT / 2;

	gotoxy(snake.x[0], snake.y[0]);
	printf(SNAKE_HEAD);
	for (int i = 1; i < snake.currentLen; i++)
	{
		snake.x[i] = snake.x[i - 1] + 2;
		snake.y[i] = snake.y[i - 1];
		gotoxy(snake.x[i], snake.y[i]);
		printf(SNAKE_BODY);
	}
	gotoxy(96, 0);

}
void moveSnake()
{
	if (_kbhit()){//������������
		fflush(stdin);
		direct = _getch();
	}
	//�������һ����β
	gotoxy(snake.x[snake.currentLen - 1], snake.y[snake.currentLen - 1]);
	printf("  ");
	//��ʼ�滻���꣬�ƶ���
	for (int i = snake.currentLen - 1; i > 0; i--)
	{
		snake.x[i] = snake.x[i - 1];
		snake.y[i] = snake.y[i - 1];
		gotoxy(snake.x[i], snake.y[i]);
		printf(SNAKE_BODY);
	}
	switch (direct){
	case 'W':
	case'w':
		snake.y[0]--;
		break;
	case 'S':
	case's':
		snake.y[0]++;
		break;
	case 'a':
	case'A':
		snake.x[0] -= 2;
		break;
	case 'd':
	case'D':
		snake.x[0] += 2;
		break;
	}
	//�ƶ�֮������ͷ��λ��
	gotoxy(snake.x[0], snake.y[0]);
	printf(SNAKE_HEAD);
	gotoxy(96, 0);
	printf("����%d", score);
	//�ж���ͷ�������Ƿ��ʳ�����
	if (snake.x[0] == food.x&&snake.y[0] == food.y)
	{
		snake.currentLen++;//�߳�ʳ����ȼ�1
		flag = 1;
		score++;
	}
}
int statement()//�ж���Ϸ��ǰ״̬
{
	//�ж���ͷ�Ƿ�ײ��ǽ��
	if (snake.x[0] == 0 + MOVE_CENTER || snake.x[0] == MAP_WIDTH + MOVE_CENTER || snake.y[0] == 0 || snake.y[0] == MAP_HEIGHT - 1)
	{
		return 1;
	}
	//��ͷ�Ե��Լ�����
	for (int i = 1; i < snake.currentLen; i++){
		if (snake.x[0] == snake.x[i] && snake.y[0] == snake.y[i])
		{
			return 1;
		}

	}
	return 0;
}
void gotoxy(int x, int y)//ϵͳ��������
{
	COORD pos{ x, y };
	HANDLE hOut = GetStdHandle(STD_OUTPUT_HANDLE);
	SetConsoleCursorPosition(hOut, pos);
}

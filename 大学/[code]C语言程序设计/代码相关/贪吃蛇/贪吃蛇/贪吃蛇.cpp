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
    佛祖保佑       永不宕机     永无BUG
*/
#include<stdio.h>
#include<time.h>//随机种子来出现事物
#include<conio.h>//监听键盘输入
#include<Windows.h>//为了使用gotoxy(光标移动函数）
#define MAP_MODE "■"
#define SNAKE_HEAD "■"
#define SNAKE_BODY "□"
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
	int currentLen;//蛇的长度
}snake;
int direct = 'a';
int flag = 1;//是否需要创建食物
int score = 0;//积分
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

	system("title c语言学习");

	printf("欢迎来到贪吃蛇游戏！");

	gotoxy(40, 25);

	printf("*****c语言实现*****     \n");

	system("pause");

	system("cls");

	gotoxy(25, 12);

	printf("W、A、S、D控制蛇身的移动方向\n");

	gotoxy(25, 13);

	//printf("F1为加速，F2为减速\n");

	system("pause");

	system("cls");
}
void createMap()
{
	for (int i = 0 + MOVE_CENTER; i < MAP_WIDTH + MOVE_CENTER; i += 2){
		gotoxy(i, 0);//改变x,y不变,最上面的边长
		printf(MAP_MODE);

		gotoxy(i, MAP_HEIGHT - 1);//改变x,y不变,最下面的边长
		printf(MAP_MODE);
	}
	for (int i = 0; i < MAP_HEIGHT; i += 1){
		gotoxy(0 + MOVE_CENTER, i);//改变y,x不变,最左面的边长
		printf(MAP_MODE);

		gotoxy(MAP_WIDTH + MOVE_CENTER, i);//改变y,x不变,最右面的边长
		printf(MAP_MODE);

	}
	gotoxy(96, 0);
	initSnake();
}
void createFood()
{
	srand(time(NULL));//随机种子
	int isCreate = 1;//表示食物是否可以被创建
	food.x = rand() % (MAP_WIDTH - 4 + 2) + MOVE_CENTER;//限制食物随机出现在边框中
	food.y = rand() % (MAP_HEIGHT - 2 + 1);////限制食物随机出现在边框中
	if (food.x % 2 == 0)//横坐标必需为偶数，因为左右占两格，不为偶数蛇吃不到食物
	{
		//限制食物不在蛇的身上
		for (int i = 0; i < snake.currentLen; i++){
			if (snake.x[i] == food.x&&snake.y[i] == food.y){
				isCreate = 0;
			}
			if (isCreate)
			{
				gotoxy(food.x, food.y);
				printf("★");
				flag = 0;//创建出食物后拔旗
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
	if (_kbhit()){//监听键盘输入
		fflush(stdin);
		direct = _getch();
	}
	//擦除最后一节蛇尾
	gotoxy(snake.x[snake.currentLen - 1], snake.y[snake.currentLen - 1]);
	printf("  ");
	//开始替换坐标，移动蛇
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
	//移动之后，新蛇头的位置
	gotoxy(snake.x[0], snake.y[0]);
	printf(SNAKE_HEAD);
	gotoxy(96, 0);
	printf("积分%d", score);
	//判断蛇头的坐标是否和食物相等
	if (snake.x[0] == food.x&&snake.y[0] == food.y)
	{
		snake.currentLen++;//蛇吃食物，长度加1
		flag = 1;
		score++;
	}
}
int statement()//判断游戏当前状态
{
	//判断蛇头是否撞到墙壁
	if (snake.x[0] == 0 + MOVE_CENTER || snake.x[0] == MAP_WIDTH + MOVE_CENTER || snake.y[0] == 0 || snake.y[0] == MAP_HEIGHT - 1)
	{
		return 1;
	}
	//蛇头吃到自己身体
	for (int i = 1; i < snake.currentLen; i++){
		if (snake.x[0] == snake.x[i] && snake.y[0] == snake.y[i])
		{
			return 1;
		}

	}
	return 0;
}
void gotoxy(int x, int y)//系统辅助函数
{
	COORD pos{ x, y };
	HANDLE hOut = GetStdHandle(STD_OUTPUT_HANDLE);
	SetConsoleCursorPosition(hOut, pos);
}

#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
int BMI(float bmi,int sex)
{
	int score;
	if (sex = 0)
	{
		if (bmi >= 17.9&&bmi <= 23.9)
		{
			score = 100;
		}
		else if ((bmi>=0 && bmi <= 17.8) || (bmi >= 24.0 && bmi <= 27.9))
		{
			score = 80;
		}
		else if (bmi >= 28.0)
		{
			score = 60;
		}
		else
		{
			score = 30;
		}
	}
	if(sex = 1)
	{
		if (bmi >= 17.2&&bmi <= 23.9)
		{
			score = 100;
		}
		else if ((bmi >= 0 && bmi <= 17.8) || (bmi >= 24.0 && bmi <= 27.9))
		{
			score = 80;
		}
		else if (bmi >= 28.0)
		{
			score = 60;
		}
		else
		{
			score = 30;
		}
	}
	return score;
}
int FVC(int fvc,int sex)
{
	int score;
	if (sex = 0)
	{
		if (fvc >4800)
		{
			score = 100;
		}
		else if (fvc >= 4181 && fvc <= 4800)
		{
			score = 80;
		}
		else if (fvc >= 3101 && fvc <= 4180)
		{
			score = 60;
		}
		else if (fvc >= 0 && fvc <= 3100)
		{
			score = 30;
		}
	}
	if (sex = 1)
	{
		if (fvc >3400)
		{
			score = 100;
		}
		else if (fvc >= 3001 && fvc <= 3400)
		{
			score = 80;
		}
		else if (fvc >= 2051 && fvc <= 3000)
		{
			score = 60;
		}
		else if (fvc >= 0 && fvc <= 2050)
		{
			score = 30;
		}
	}
	return score;
}
int YTXS(int ytxs)
{
	int score;
	
		if (ytxs >19)
		{
			score = 100;
		}
		else if ( ytxs>= 16 && ytxs <= 19)
		{
			score = 80;
		}
		else if (ytxs >= 10 && ytxs <= 15)
		{
			score = 60;
		}
		else if (ytxs >= 0 && ytxs <= 9)
		{
			score = 30;
		}
	
	return score;
}
int YWQZ(int ywqz)
{
	int score;

	if (ywqz >56)
	{
		score = 100;
	}
	else if (ywqz >= 53 && ywqz <= 56)
	{
		score = 80;
	}
	else if (ywqz >= 25 && ywqz <= 52)
	{
		score = 60;
	}
	else if (ywqz >= 0 && ywqz <= 16)
	{
		score = 30;
	}

	return score;
}
void SCORE(int sex)
{
	float score;
	float bmi;
	int fvc, ytxs, ywqz;
	if (sex = 0)
	{
		printf("BMI: FVC: 引体向上：");
		scanf("%f%d%d", &bmi, &fvc, &ytxs);
		score = BMI(bmi, 0)*0.25 + FVC(fvc, 0)*0.35 + YTXS(ytxs)*0.4;
		printf("%f分", score);
		if (score >= 95 && score <= 100)
		{
			printf("优秀\n");
		}
		else if(score >= 80 && score <= 94)
		{
			printf("良好\n");
		}
		else if (score >= 60 && score <= 79)
		{
			printf("及格\n");
		}
		else if (score <60)
		{
			printf("不及格\n");
		}
	}
	if (sex = 1)
	{
		printf("BMI: FVC: 仰卧起坐：");
		scanf("%f%d%d", &bmi, &fvc, &ywqz);
		score = BMI(bmi, 1)*0.25 + FVC(fvc, 1)*0.35 + YWQZ(ywqz)*0.4;
		printf("%f分", score);
		if (score >= 95 && score <= 100)
		{
			printf("优秀\n");
		}
		else if (score >= 80 && score <= 94)
		{
			printf("良好\n");
		}
		else if (score >= 60 && score <= 79)
		{
			printf("及格\n");
		}
		else if (score <60)
		{
			printf("不及格\n");
		}
	}
}
void menu()
{
	printf("功能菜单\n");
	printf("=========\n");
	printf("1.体重指数BMI\n");
	printf("2.肺活量FVC\n");
	printf("3.引体向上\n");
	printf("4.仰卧起坐\n");
	printf("5.总成绩\n");
	printf("0.退出\n");
	printf("=========\n");
	printf("请输入性别（男：0）/(女：1)：");
	int score,sex,n;
	scanf("%d", &sex);
	printf("\n选择功能：");
	scanf("%d", &n);
	switch (n)
	{
	case 1:
		float bmi;
		printf("BMI:");
		scanf("%f", &bmi);
		score = BMI(bmi, sex);
		printf("%d", score);
		break;
	case 2:
		int fvc;
		printf("FVC:");
		scanf("%d", &fvc);
		score = FVC(fvc, sex);
		printf("%d", score);
		break;
	case 3:
		int ytxs;
		printf("引体向上:");
		scanf("%d", &ytxs);
		score = YTXS(ytxs);
		printf("%d", score);
		break;
	case 4:
		int ywqz;
		printf("仰卧起坐:");
		scanf("%d", &ywqz);
		score = YWQZ(ywqz);
		printf("%d", score);
		break;
	case 5:
		SCORE(sex);
		break;
	case 0:
		break;
	}
	
}
int main()
{
	menu();
	return 0;
}
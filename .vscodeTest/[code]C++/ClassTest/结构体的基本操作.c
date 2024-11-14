//学生基本信息包括学号，两门课成绩，编写程序计算某学生的平均成绩并输出该学生的有关信息
#include<stdio.h>
struct ex1
{
    int num;
    float yy;
    float sx;
};
int main()
{
    struct ex1 w;
    float ave;
    w.num=20211;
    w.yy=89.5;
    w.sx=90;
    ave=(w.yy+w.sx)/2;
    printf("%d %f %f\n",w.num,w.yy,w.sx);
    printf("%f\n",ave);
    return 0;
}

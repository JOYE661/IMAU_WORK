//ѧ��������Ϣ����ѧ�ţ����ſγɼ�����д�������ĳѧ����ƽ���ɼ��������ѧ�����й���Ϣ
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

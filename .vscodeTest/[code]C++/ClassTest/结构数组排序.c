//���벢����10��ѧ����Ϣ
//���㲢���ƽ����
//�Ӹߵ���������ǵ���Ϣ
#include<stdio.h>
struct student
{
    int num;
    char name[20];
    int score;
};
int main()
{
   struct student s[10],temp;
   int i,j,maxk;
   float ave,sum=0;
   for(i=0;i<10;i++)
   {
       printf("NO.%d:num,name,score",i+1);
       scanf("%d%s%d",&s[i].num,&s[i].name,&s[i].score);
       sum=sum+s[i].score;
   }
   ave=sum/10.0;
   printf("ave=%f\n",ave);
   for(i=0;i<9;i++)
   {
        maxk=i;
        for(j=i+1;j<10;j++)
        {
            if(s[j].score>s[maxk].score)
            maxk=j;
            temp=s[i];s[i]=s[maxk];s[maxk]=temp;
        }
   }
   for(i=0;i<10;i++)
    printf("%d %s %d\n",s[i].num,s[i].name,s[i].score);
}

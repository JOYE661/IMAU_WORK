#include<stdio.h>
//����ʮ���ˣ��еİ�����ש��Ů�İ�2�飬����С����һ�飬����ʮ���ש������ŮС������
int main()
{
    int m,w,c;
    for(m=0;m<=45;m++)
        for(w=0;w<=45;w++)
            for(c=0;c<=45;c++)
                if(m+w+c==45&&m*3+w*2+c*0.5==45)
                    printf("men=%d,woman=%d,child=%d\n" ,m,w,c);
    return 0;
}

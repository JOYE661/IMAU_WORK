#include<stdio.h>
//共四十五人，男的搬三块砖，女的搬2块，两个小孩搬一块，共四十五块砖，问男女小孩人数
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

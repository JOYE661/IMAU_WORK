#include <stdio.h>              
int Match(char *str);                      /*函数声明，形参为字符串指针*/
                                               
int main( )
{
 char str[100];           /*定义尽可能大的字符数组以接收键盘的输入*/
  int k;                        /*k接收调用函数Match的结果*/
  printf("请输入一个算术表达式：");
  scanf("%s", str);                  /*将表达式以字符串方式输入*/
  k = Match(str);                    /*函数调用，实参为字符数组的首地址*/
  if ( ① )
      printf("正确匹配\n");
  else if ( ② )
      printf("多左括号\n");
  else
      printf("多右括号\n");
  return 0;
                    
}
int Match(char *str)
{
 char s[100];                        /*定义顺序栈，并假定不会发生溢出*/
  int i, top = -1;                      /*top为栈s的栈顶指针*/
  for (i = 0; str[i] != '\0'; i++)   /*依次对每一个字符str[i]进行处理*/
  {
	if (str[i] == ')') {                    /*当前扫描的字符是右括号*/
	  if ( ③ ) top--;                    /*出栈前判断栈是否为空*/
	  else return -1;
    }
	else if (str[i] == '(')                 /*当前扫描的字符是左括号*/
	     s[ ④ ] = str[i];                  /*执行入栈操作*/
  }
  if (top == -1) return 0;                    /*栈空则括号正确匹配*/
  else return 1;
}


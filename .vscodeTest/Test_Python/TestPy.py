print("Hello Python")
#此乃注释#
print(1/2)
print("——————————随机数测试——————————")
import random as rd
print(rd.random())
print("——————————数学模块测试———————————")
import math
print(math.pi)
print(math.e)
print("10/3  =",10/3)    #取除
print("10//3 =",10//3)   #取整除
print("10%3  =",10%3)    #取余
print("——————————字符串———————————")
import string
input_string="hello world"
print(string.capwords(input_string))    #首字母大写
#   string.center(str,20)
#   count_l=input_string.count("l")
print(input_string.count("l"))          #统计字母出现次数
#   print(input_string.find("l",beg=0,end=len(input_string)))
print(input_string.find("l" ))          #查找字母位置




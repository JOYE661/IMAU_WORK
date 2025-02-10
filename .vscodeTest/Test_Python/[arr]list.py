#4.1.1列表的创建
l1=['sara',95.5,"lisa",85,'tom',90]
print('4.1.1(1)',l1)

l2=list([2,"red",2,"green",3,"blue"])
print('4.1.1(2)',l2)
x=list("abcde")                         #重点标记 变量=list(可迭代对象) 构造
print('4.1.1(2)',x)
y=list(range(1,11))
print('4.1.1(2)',y) 

num=[1,2,3,4,5]
l3=[n*2 for n in num]                   #重点标记 [变量 for 临时变量 in 可迭代对象 if 条件]
print('4.1.1(3)',l3)
l4=[n for n in num if n%2==0]
print('4.1.1(3)',l4)

#4.1.2列表的基本操作
l5=['joye','lisa','tom']
s=l5[0]
print('4.1.2(1)',s)                     #重点标记 负数下标的倒使用
s=l5[-1]
print('4.1.2(1)',s)
print('4.1.2(1)',len(l5))
nums=[1,2,3,4,5]
nums[0]=nums[1]+nums[-1] #1+6
print('4.1.2(1)',nums)

lst=list("内蒙古农业大学")                 #重点标记 截取 列表名[start: end: step], end=下标-1=实际数
print('4.1.2(2)',lst)                   
print('4.1.2(2)',lst[0:4])
print('4.1.2(2)',lst[::-1])

l5=['joye','jo','joy']
for s in l5:
    print('4.1.2(3)',s)
i=0   
while i<len(l5):
    print('4.1.2(3)',l5[i])
    i=i+1

#列表的相关方法
x=[1,2,3,4,5]
x.append(7)
print('4.1.3(1)',x)
x.insert(5,6)                           #插入位置取实际数
print('4.1.3(1)',x)





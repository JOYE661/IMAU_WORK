n=int(input('input n'))
sum=0
while n>0 :
    sum=sum+n%10
    n=n//10

print("每位数之和是:",sum)

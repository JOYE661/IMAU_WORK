list1=[]
while 1:
    data=input()
    if data=='':
        break
    else:
        list1.append(data)
print(list1)
list1.sort()
a=float(list1[0])
b=float(list1[-1])
c=(a+b)/2
print("max=",b,"min=",a,"avg=",c)
